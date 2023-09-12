package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.Employee;
import com.wellsfargo.lms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDataServiceImpl implements EmployeeDataService{

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public String addEmployee(Employee empDto) {
        try {
            employeeRepository.save(empDto);
            return "Employee was Added";
        } catch (Exception e) {
            return "Employee was NOT Added \n"+e.getMessage();
        }


    }
}
