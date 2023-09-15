package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.Employee;
import com.wellsfargo.lms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        try
        {
            return employeeRepository.findAll();
        }
        catch(Exception e)
        {
            return null;
        }
    }

    @Override
    public String deleteEmployee(String empId) {
        try
        {
            employeeRepository.deleteById(empId);
            return "Employee was deleted!";
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
