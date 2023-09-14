package com.wellsfargo.lms.controller;

import com.wellsfargo.lms.service.ApplyLoanService;
import com.wellsfargo.lms.service.ApplyLoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class LmsUserController {
    @Autowired
    ApplyLoanServiceImpl applyLoanService;

    @PostMapping("/applyLoan")
    public String applyLoan(@RequestBody Map<String, String> employeeLoanDetails)
    {
        return applyLoanService.saveApplyLoanData(employeeLoanDetails);
    }

}
