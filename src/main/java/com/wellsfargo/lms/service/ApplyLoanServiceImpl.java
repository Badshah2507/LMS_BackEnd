package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.EmployeeCard;
import com.wellsfargo.lms.model.EmployeeIssueDetails;
import com.wellsfargo.lms.repository.EmployeeCardRepository;
import com.wellsfargo.lms.repository.EmployeeIssueDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ApplyLoanServiceImpl implements ApplyLoanService{
    @Autowired
    private EmployeeCardRepository employeeCardRepository;
    @Autowired
    private EmployeeIssueDetailsRepository employeeIssueDetailsRepository;

    public void saveApplyLoanData(Map<String,String> applyLoanDetails)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        EmployeeCard employeeCard = new EmployeeCard();
        EmployeeIssueDetails employeeIssueDetails = new EmployeeIssueDetails();
        employeeCard.setLoanId(applyLoanDetails.get("loanId"));
        employeeCard.setEmployeeId(applyLoanDetails.get("employeeId"));
        employeeCard.setCardIssueDate(java.sql.Date.valueOf(formatter.format(date)));
        employeeIssueDetails.setEmployeeId(applyLoanDetails.get("employeeId"));
        employeeIssueDetails.setIssueDate(employeeCard.getCardIssueDate());
        employeeIssueDetails.setItemId();
        employeeIssueDetails.setReturnDate();
        employeeCardRepository.save(employeeCard);
        employeeIssueDetailsRepository.save(employeeIssueDetails);

    }
}
