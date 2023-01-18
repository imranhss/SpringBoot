package org.idb.Tourism.service;


import org.idb.Tourism.entity.RoomFacilities;
import org.idb.Tourism.repository.IRoomFacilitiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomFacilitiesService {

    @Autowired
    IRoomFacilitiesRepo roomFacilitiesRepo;


    public  void  saveRoomFacilities(RoomFacilities roomFacilities){

        roomFacilitiesRepo.save(roomFacilities);
    }

    public void deleteRoomFacilitiesById(int id){
        roomFacilitiesRepo.deleteById(id);

    }

    public List<RoomFacilities> getAllRoomFacilities(){

        return roomFacilitiesRepo.findAll();
    }


    public RoomFacilities findRoomFacilitiesById(int id){
        return roomFacilitiesRepo.findById(id).get();
    }




}
