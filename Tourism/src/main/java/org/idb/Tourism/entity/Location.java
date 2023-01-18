package org.idb.Tourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int lid;

    @Column(length = 60, nullable = false)
    String lname;

    @Column(length = 60, nullable = false)
    String lzipcode;

    @Column(length = 60, nullable = false)
    String llat;

    @Column(length = 60, nullable = false)
    String llong;

    @Column(length = 60, nullable = false)
    String lcountry;

    @Column(length = 60, nullable = false)
    String ldescription;

    @Column(length = 60, nullable = false)
    String lphoto;


}
