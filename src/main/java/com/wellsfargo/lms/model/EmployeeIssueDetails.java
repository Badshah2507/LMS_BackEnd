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
@Builder
public class EmployeeIssueDetails {
    @Id
    @SequenceGenerator(name = "EI_UID", initialValue = 101, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "EI_UID")
    private Long issueId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private Date issueDate;
    private Date returnDate;
}
