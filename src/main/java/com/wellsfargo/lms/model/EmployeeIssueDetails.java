package com.wellsfargo.lms.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeIssueDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String issueId;
    private String employeeId;

    private String itemId;
    private Date issueDate;
    private Date returnDate;
}
