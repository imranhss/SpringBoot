package org.idb.Tourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uId;

    @Column(length = 50, nullable = false)
    private String uName;

    @Column(length = 255, nullable = false)
    private String uAddress;

    @Column(length = 30, nullable = false)
    private String uCell;

    @Column(length = 45, nullable = false, unique = true)
    private String uEmail;

    @Column(length = 64, nullable = false)
    private String uPassword;

}
