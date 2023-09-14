package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.EmployeeCard;
import com.wellsfargo.lms.model.EmployeeIssueDetails;
import com.wellsfargo.lms.repository.EmployeeCardRepository;
import com.wellsfargo.lms.repository.EmployeeIssueDetailsRepository;
import com.wellsfargo.lms.repository.ItemRepository;
import com.wellsfargo.lms.repository.LoanCardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
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

    public void saveApplyLoanData(Map<String,String> applyLoanDetails)
    {
        Calendar calendar =Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = calendar.getTime();
        EmployeeCard employeeCard = new EmployeeCard();
        EmployeeIssueDetails employeeIssueDetails = new EmployeeIssueDetails();
        employeeCard.setLoanId(loanCardRepository.findByLoanType(applyLoanDetails.get("itemCategory")).getLoanId());
        employeeCard.setEmployeeId(applyLoanDetails.get("employeeId"));
        employeeCard.setCardIssueDate(java.sql.Date.valueOf(formatter.format(date)));
        employeeIssueDetails.setEmployeeId(applyLoanDetails.get("employeeId"));
        employeeIssueDetails.setIssueDate(java.sql.Date.valueOf(formatter.format(date)));
        employeeIssueDetails.setItemId(itemRepository.findByItemCategoryAndItemDescription(applyLoanDetails.get("itemCategory"),applyLoanDetails.get("itemDescription")).getItemId());
        calendar.add(Calendar.YEAR , loanCardRepository.findByLoanType(applyLoanDetails.get("itemCategory")).getLoanDurationYrs());
        Date date1 = calendar.getTime();
        employeeIssueDetails.setReturnDate(java.sql.Date.valueOf(formatter.format(date1)));
        employeeCardRepository.save(employeeCard);
        employeeIssueDetailsRepository.save(employeeIssueDetails);


    }
}
