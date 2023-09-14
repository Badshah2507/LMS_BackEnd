package com.wellsfargo.lms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
public class LoanCard {

    @Id
    private String loanId;
    private String loanType;
    private Integer loanDurationYrs;

    @OneToMany(mappedBy = "loanCard")
    private List<EmployeeCard> employeeCards;

}
