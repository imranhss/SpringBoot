package org.idb.Tourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rId;

    @Column(length = 50, nullable = false)
    private String rTitle;

    @Column(length = 255)
    private String rDescription;

    @Column(length = 15, nullable = false)
    private String rRoomAddress; //room number

    @Column(length = 50, nullable = false)
    private String rAvailableRoom;

    private String rGallery; //for photos

    @Column(length = 15, nullable = false)
    private double rRoomPrice;

    @Column(length = 15)
    private double rDiscount;

    @Column(length = 15)
    private int rAdultNumber;

    @Column(length = 15)
    private int rChildrenNumber;

    @Column(length = 15)
    private int rBedNumber;

    @Column(length = 25)
    private double rRoomSize;

    @Column(length = 25)
    private int rAvailability;

    @Column(length = 25)
    private String rDetails;

    @ManyToOne
    @JoinColumn(name = "hotelId")
    Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "roomtypeId")
    Roomtype roomtype;

    @ManyToOne
    @JoinColumn(name = "roomFacilitiesId")
    RoomFacilities roomFacilities;
}
