package org.idb.Tourism.service;

import org.idb.Tourism.entity.Booking;
import org.idb.Tourism.repository.IBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    IBookingRepo iBookingRepo;
    public  void saveBook(Booking b){
        iBookingRepo.save(b);
    }

    public  void deleteBooking(int bId){
        iBookingRepo.deleteById(bId);
    }

    public List<Booking> getAllBooking(){
        return  iBookingRepo.findAll();

    }

    public Booking findBookingById(int bId){
        return iBookingRepo.findById(bId).get();
    }


//    this is for new booking

//    public List<> getAllTableData(){
//               sql="select * from tourism.hotel h join tourism.location l on(h.location_id=l.lid) where l.lcountry='India' and h.hname='Hotel Zahid'" ;
//
//    }





}
