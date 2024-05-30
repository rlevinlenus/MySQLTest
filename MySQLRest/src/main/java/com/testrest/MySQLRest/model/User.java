package com.testrest.MySQLRest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column (nullable = false)
    private String firstName;
    @Column (nullable = false)
    private String lastName;
    @Column (nullable = false, unique = true)
    private String eMail;

}
