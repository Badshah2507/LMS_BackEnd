package com.wellsfargo.lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Employee {
    @Id
    private String employeeId;
    private String employeeName;
    private String designation;
    private String department;
    private String gender;
    private Date dateOfBirth;
    private Date dateOfJoining;
}
