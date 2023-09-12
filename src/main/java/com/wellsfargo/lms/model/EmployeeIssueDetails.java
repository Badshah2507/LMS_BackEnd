package com.wellsfargo.lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class EmployeeIssueDetails {
    @Id
    private String issueId;
    private String employeeId;
    private String itemId;
    private Date issueDate;
    private Date returnDate;
}
