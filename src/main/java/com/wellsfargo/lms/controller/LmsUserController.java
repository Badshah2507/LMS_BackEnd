package com.wellsfargo.lms.controller;

import com.wellsfargo.lms.model.EmployeeCard;
import com.wellsfargo.lms.model.EmployeeIssueDetails;
import com.wellsfargo.lms.service.ApplyLoanService;
import com.wellsfargo.lms.service.ApplyLoanServiceImpl;
import com.wellsfargo.lms.service.EmployeeCardService;
import com.wellsfargo.lms.service.EmployeeIssueDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class LmsUserController {
    @Autowired
    ApplyLoanService applyLoanService;
    @Autowired
    EmployeeCardService employeeCardService;
    @Autowired
    EmployeeIssueDetailsService employeeIssueDetailsService;

    @PostMapping("/applyLoan")
    public String applyLoan(@RequestBody Map<String, String> employeeLoanDetails)
    {
        return applyLoanService.saveApplyLoanData(employeeLoanDetails);
    }

    @GetMapping("/getEmployeeCard")
    public ResponseEntity<List<EmployeeCard>> getEmployeeCards(@RequestParam("emplId") String empId) {
        return new ResponseEntity<>(employeeCardService.getEmployeeCard(empId), HttpStatus.OK);
    }

    @GetMapping("/getEmplIssues")
    public ResponseEntity<List<EmployeeIssueDetails>> getEmpIssues(@RequestParam("emplId") String empId) {
        return new ResponseEntity<>(employeeIssueDetailsService.getAllEmpIssues(empId), HttpStatus.OK);
    }

}
