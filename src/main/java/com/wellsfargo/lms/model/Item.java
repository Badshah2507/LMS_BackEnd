package com.wellsfargo.lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Item {
    @Id
    private String itemId;
    private String itemDescription;
    private String issueStatus;
    private String itemMake;
    private String itemCategory;
    private Integer itemValuation;
}
