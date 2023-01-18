package org.idb.Tourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int bid;

    @Column(length = 60, nullable = false)
    private String bTitle;

    @Column(length = 60, nullable = false)
    private String bAvailableRoom;

    @Column(length = 60, nullable = false)
    private String bType;

    @Column(length = 60, nullable = false)
    private String bDate;

    @Column(length = 60, nullable = false)
    private String bookedroom;

    @Column(length = 60, nullable = false)
    private String bComment;

    @Column(length = 60, nullable = false)
    private String trakingNumber;

    @ManyToOne
    @JoinColumn(name = "rId")
    Room room;

    @ManyToOne
    @JoinColumn(name = "lid")
    Location location;

    @ManyToOne
    @JoinColumn(name = "iid")
    Inventory inventory;

//    @ManyToOne
//    @JoinColumn(name = "uId")
//    User user;

}
