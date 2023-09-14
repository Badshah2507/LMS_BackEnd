package com.wellsfargo.lms.service;

import com.wellsfargo.lms.repository.EmployeeCardRepository;

import java.util.Map;

public interface ApplyLoanService {
    void saveApplyLoanData(Map<String,String> applyLoanDetails);


}
