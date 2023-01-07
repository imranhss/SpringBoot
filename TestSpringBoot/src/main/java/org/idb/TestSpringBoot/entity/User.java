package org.idb.TestSpringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // create Table in DB
@Data // getter and Setter
@NoArgsConstructor // Default Constructor
@AllArgsConstructor // perameterised Constructor
@Table(name = "users")  // define table name in db
public class User {
    @Id   // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_increment
    private int id;
    @Column(length = 45, nullable = false, unique = true)
    private String email;
    @Column(length = 64, nullable = false) // Encrypted mode with 64 charecter
    private String password;
    @Column(length = 30, nullable = false)
    private String firstName;
    @Column(length = 30, nullable = false)
    private String lastName;

    private boolean isEnabled=false;


}
