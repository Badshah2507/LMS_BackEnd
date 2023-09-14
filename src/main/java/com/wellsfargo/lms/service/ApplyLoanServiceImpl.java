package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.*;
import com.wellsfargo.lms.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
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
        long millis = System.currentTimeMillis();
        Date issueDate = new Date(millis);
        Calendar c = Calendar.getInstance();
        c.setTime(issueDate);
        c.add(Calendar.YEAR, loanCardRepository.findByLoanType(applyLoanDetails.get("itemCategory")).getLoanDurationYrs());
        Date returnDate = new Date(c.getTimeInMillis());

        Employee empDAO = new Employee();
        LoanCard loanCardDAO = new LoanCard();
        Item itemDAO = new Item();


        try {
            empDAO = fetchEmployee(applyLoanDetails.get("employeeId"));
            loanCardDAO = fetchLoanCard(applyLoanDetails.get("itemCategory"));
            itemDAO = fetchItem(applyLoanDetails.get("itemCategory"), applyLoanDetails.get("itemDescription"));

            EmployeeCard employeeCard = EmployeeCard.builder()
                    .cardIssueDate(issueDate)
                    .loanCard(loanCardDAO)
                    .employee(empDAO)
                    .build();

            EmployeeIssueDetails employeeIssueDetails = EmployeeIssueDetails.builder()
                    .issueDate(issueDate)
                    .returnDate(returnDate)
                    .employee(empDAO)
                    .item(itemDAO)
                    .build();

            try {
                employeeCardRepository.save(employeeCard);
                employeeIssueDetailsRepository.save(employeeIssueDetails);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return "Loan Applied Successfully";

        } catch (Exception e) {
            return null;
        }

    }
}
