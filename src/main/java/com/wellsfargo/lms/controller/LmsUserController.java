package com.wellsfargo.lms.controller;

import com.wellsfargo.lms.service.ApplyLoanService;
import com.wellsfargo.lms.service.ApplyLoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class LmsUserController {
    @Autowired
    ApplyLoanServiceImpl applyLoanService;

    @PostMapping("/applyLoan")
    public String applyLoan(Map<String,String> employeeLoanDetails)
    {
        applyLoanService.saveApplyLoanData(employeeLoanDetails);
        return "Successfully saved";

    }

}
