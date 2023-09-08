package com.wellsfargo.lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class LoanCard {

    @Id
    private String loanId;
    private String loanType;
    private Integer loanDurationYrs;
}
