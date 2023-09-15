package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.EmployeeCard;
import com.wellsfargo.lms.repository.EmployeeCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService{
    @Autowired
    EmployeeCardRepository employeeCardRepository;
    @Override
    public List<EmployeeCard> getEmployeeCard() {
        return employeeCardRepository.findAll();
    }
}
