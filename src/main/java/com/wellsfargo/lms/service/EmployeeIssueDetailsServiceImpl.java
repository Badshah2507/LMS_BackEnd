package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.EmployeeIssueDetails;
import com.wellsfargo.lms.repository.EmployeeIssueDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeIssueDetailsServiceImpl implements EmployeeIssueDetailsService{
    @Autowired
    EmployeeIssueDetailsRepository employeeIssueDetailsRepository;
    @Override
    public List<EmployeeIssueDetails> getAllEmpIssues(String empId) {
        return employeeIssueDetailsRepository.findAllByEmployeeId(empId);
    }
}
