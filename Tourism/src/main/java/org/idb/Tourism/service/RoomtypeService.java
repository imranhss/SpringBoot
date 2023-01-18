package org.idb.Tourism.service;

import org.idb.Tourism.entity.Roomtype;
import org.idb.Tourism.repository.IRoomtypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomtypeService {

    @Autowired
    IRoomtypeRepo roomtype;

    public void  saveRoomtype(Roomtype rt){
        roomtype.save(rt);
    }

    public  void  deleteRoomtype(int rtid){
        roomtype.deleteById(rtid);
    }

    public List<Roomtype> getAllRoomtype(){
      return roomtype.findAll();
    }

    public Roomtype findByIdRoomType(int rtid){
        return roomtype.findById(rtid).get();
    }


}
