package com.wellsfargo.lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class EmployeeCard {
    @Id
    private String loanId;
    private String employeeId;
    private Date cardIssueDate;
}
