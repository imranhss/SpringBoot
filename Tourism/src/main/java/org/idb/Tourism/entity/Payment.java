package org.idb.Tourism.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int pid;

    @Column(length = 60, nullable = false)
    private String pType;

    @Column(length = 60, nullable = false)
    private String acDetails;

    @Column(length = 60, nullable = false)
    private String pAmount;

    @Column(length = 60, nullable = false)
    private String pDate;



    @ManyToOne
    @JoinColumn(name = "bId")
    Booking booking;

    @ManyToOne
    @JoinColumn(name = "uId")
    User user;


}
