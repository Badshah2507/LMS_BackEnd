package com.wellsfargo.lms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @SequenceGenerator(name = "UUID", initialValue = 101, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "UUID")
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String password;
    private String role;

}
