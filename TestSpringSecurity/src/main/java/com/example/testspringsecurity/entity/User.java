package com.example.testspringsecurity.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
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
    @Column(length = 64)
    private String photo;
    private boolean isEnabled=false;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_is")
    )
    private Set<Role> roles=new HashSet<>();


    public User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void  assRole(Role role){
        this.roles.add(role);
    }
}
