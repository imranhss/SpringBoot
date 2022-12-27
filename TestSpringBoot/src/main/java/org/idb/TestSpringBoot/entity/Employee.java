package org.idb.TestSpringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int eid;

    @Column(length = 30, nullable = false)
    private  String eName;
    @Column(length = 45, nullable = false)
    private  String eEmail;
    @Column(length = 255, nullable = false)
    private  String eAddress;
    @Column(length = 12, nullable = false)
    private  String eGender;

    @ManyToOne
    @JoinColumn(name = "did_fk")
    Department department;

}
