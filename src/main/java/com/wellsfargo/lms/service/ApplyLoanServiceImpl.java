package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.*;
import com.wellsfargo.lms.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional

public class ApplyLoanServiceImpl implements ApplyLoanService{
    @Autowired
    private EmployeeCardRepository employeeCardRepository;
    @Autowired
    private EmployeeIssueDetailsRepository employeeIssueDetailsRepository;
    @Autowired
    private LoanCardRepository loanCardRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee fetchEmployee(String empId) {
        Optional<Employee> emp = employeeRepository.findById(empId);
        return emp.orElse(null);
    }
    private LoanCard fetchLoanCard(String loantype) {
        return loanCardRepository.findByLoanType(loantype);
    }
    private Item fetchItem(String itemCat, String itemDesc) {
        return itemRepository.findByItemCategoryAndItemDescription(itemCat,itemDesc);
    }

    public String saveApplyLoanData(Map<String,String> applyLoanDetails)
    {
        Calendar calendar =Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = calendar.getTime();

        calendar.add(Calendar.YEAR , loanCardRepository.findByLoanType(applyLoanDetails.get("itemCategory")).getLoanDurationYrs());
        Date returnDate = calendar.getTime();

        Employee empDAO = new Employee();
        LoanCard loanCardDAO = new LoanCard();
        Item itemDAO = new Item();

        System.out.println("Here1");

        try {
            empDAO = fetchEmployee(applyLoanDetails.get("employeeId"));
            loanCardDAO = fetchLoanCard(applyLoanDetails.get("loanType"));
            itemDAO = fetchItem(applyLoanDetails.get("itemCategory"), applyLoanDetails.get("itemDescription"));

            System.out.println("Here2");
//            System.out.println(empDAO.toString());
            System.out.println(loanCardDAO.toString());
            System.out.println(itemDAO.toString());

            EmployeeCard employeeCard = EmployeeCard.builder()
                    .cardIssueDate(java.sql.Date.valueOf(formatter.format(date)))
                    .loanCard(loanCardDAO)
                    .employee(empDAO)
                    .build();


            EmployeeIssueDetails employeeIssueDetails = EmployeeIssueDetails.builder()
                    .issueDate(java.sql.Date.valueOf(formatter.format(date)))
                    .returnDate(java.sql.Date.valueOf(formatter.format(returnDate)))
                    .employee(empDAO)
                    .item(itemDAO)
                    .build();

            System.out.println("Here3");
            System.out.println(employeeCard.toString());
            System.out.println(employeeIssueDetails.toString());

            employeeCardRepository.save(employeeCard);
            employeeIssueDetailsRepository.save(employeeIssueDetails);

            return "Loan Applied Successfully";

        } catch (Exception e) {
            return null;
        }

    }
}
