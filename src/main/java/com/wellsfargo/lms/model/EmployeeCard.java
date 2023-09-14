package com.wellsfargo.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class EmployeeCard {

    @Id
    @Setter(AccessLevel.NONE)
    @SequenceGenerator(name = "EC_UID", initialValue = 101, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "EC_UID")
    private Long EmployeeCardId;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    @JsonIgnore
    private LoanCard loanCard;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

    private Date cardIssueDate;
}
