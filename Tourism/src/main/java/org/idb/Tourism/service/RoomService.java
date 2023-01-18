package org.idb.Tourism.service;

import org.idb.Tourism.entity.Room;
import org.idb.Tourism.repository.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    IRoomRepo iRoomRepo;
    public  void  saveRoom(Room r){
        iRoomRepo.save(r);
    }

    public void deleteRoomById(int rId){
        iRoomRepo.deleteById(rId);

    }

    public List<Room> getAllRoom(){

        return iRoomRepo.findAll();
    }

    public  Room findRoomById(int rId){
        return iRoomRepo.findById(rId).get();
    }


}
