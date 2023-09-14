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
public class EmployeeCard {
    @Id

    private String loanId;
    private String employeeId;
    private Date cardIssueDate;
//    @OneToOne
//    @JoinColumn(name = "loan_id")
//    private LoanCard loanCard;
}
