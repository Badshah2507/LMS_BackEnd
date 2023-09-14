package com.wellsfargo.lms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class LoanCard {

    @Id
//    @OneToOne(mappedBy = "loanCard",cascade = CascadeType.ALL)
    private String loanId;
    private String loanType;
    private Integer loanDurationYrs;

}
