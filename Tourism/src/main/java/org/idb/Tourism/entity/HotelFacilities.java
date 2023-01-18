package org.idb.Tourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelFacilities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int hfacid;

    @Column(length = 60,nullable = false)
    private String hfacname;

    @Column(length = 60,nullable = false)
    private String hfacdiscription;

    @Column(length = 60,nullable = false)
    private String hfackeyword;

}
