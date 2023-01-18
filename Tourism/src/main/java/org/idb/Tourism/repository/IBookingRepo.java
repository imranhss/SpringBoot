package org.idb.Tourism.repository;

import org.idb.Tourism.entity.Booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingRepo extends JpaRepository<Booking, Integer> {

}
