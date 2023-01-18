package org.idb.Tourism.service;

import org.idb.Tourism.entity.Inventory;
import org.idb.Tourism.repository.IInventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    IInventoryRepo inventoryRepo;


    public  void  saveinventory(Inventory inventory){

        inventoryRepo.save(inventory);
    }

    public void deleteinventoryById(int id){
       inventoryRepo.deleteById(id);

    }

    public List<Inventory> getAllinventory(){

        return inventoryRepo.findAll();
    }


    public Inventory findHotelById(int id){
        return inventoryRepo.findById(id).get();
    }



}
