package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.Employee;
import com.wellsfargo.lms.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeDataServiceImplTest {

    @Autowired
    EmployeeDataService employeeDataService;
    @MockBean
    EmployeeRepository employeeRepository;

    @Test
    void addEmployee() {
        Employee employee = Employee.builder()
                .employeeId("E0001")
                .dateOfBirth(new Date(25072001))
                .dateOfJoining(new Date(30012023))
                .department("Technology")
                .designation("Associate")
                .employeeName("Prathamesh")
                .gender("Male")
                .build();

        String response = employeeDataService.addEmployee(employee);
        assertEquals("Employee was Added", response);
    }

    @Test
    void getAllEmployees() {
        Employee employee1 = Employee.builder()
                .employeeId("E0001")
                .dateOfBirth(new Date(25072001))
                .dateOfJoining(new Date(30012023))
                .department("Technology")
                .designation("Associate")
                .employeeName("Prathamesh")
                .gender("Male")
                .build();

        Employee employee2 = Employee.builder()
                .employeeId("E0002")
                .dateOfBirth(new Date(25072001))
                .dateOfJoining(new Date(30012023))
                .department("HR")
                .designation("Manager")
                .employeeName("Om")
                .gender("Male")
                .build();
        List<Employee> result = new ArrayList<>();
        result.add(employee1);
        result.add(employee2);
        when(employeeRepository.findAll()).thenReturn(result);

        List<Employee> response = employeeDataService.getAllEmployees();
        assertEquals("E0001", response.get(0).getEmployeeId());
        assertEquals("E0002", response.get(1).getEmployeeId());
        assertEquals("Technology", response.get(0).getDepartment());
        assertEquals("HR", response.get(1).getDepartment());
        assertEquals("Associate", response.get(0).getDesignation());
        assertEquals("Manager", response.get(1).getDesignation());
        assertEquals("Prathamesh", response.get(0).getEmployeeName());
        assertEquals("Om", response.get(1).getEmployeeName());
        assertEquals("Male", response.get(0).getGender());
        assertEquals("Male", response.get(1).getGender());
    }
}