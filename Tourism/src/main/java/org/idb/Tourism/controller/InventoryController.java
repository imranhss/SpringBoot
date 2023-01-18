package org.idb.Tourism.controller;


import org.idb.Tourism.entity.Inventory;
import org.idb.Tourism.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InventoryController {

    @Autowired
    InventoryService service;

    //this is for index/home page
    @RequestMapping("/inventory")
    public String home(){
        return "inventory";
    }



    @RequestMapping("/inventory_form")
    public String allinventory(Model m){
        m.addAttribute("invList",new Inventory());
        m.addAttribute("allinvList",service.getAllinventory());

        return "inventory-form";


    }

    @RequestMapping("/in_reg")
    public String inventorylist(Model m){
        m.addAttribute("inventory",service.getAllinventory());
        m.addAttribute("invList",new Inventory());

        return "inventorylist";
    }

    @RequestMapping(value = "/add_inventory", method = RequestMethod.POST)
    public String addNewinventory(@ModelAttribute("invList") Inventory i, Model m ){
        service.saveinventory(i);
        return "redirect:/inventory_form";
    }

    @RequestMapping("/delete_inventory/{iid}")
    public String deleteinventory(@PathVariable("iid") Integer iid){
        service.deleteinventoryById(iid);
        return "redirect:/in_reg";
    }

    @RequestMapping("/edit_inventory/{iid}")
    public String inventoryUpdateForm(@PathVariable("iid") Integer iid, Model m){
        Inventory i = service.findHotelById(iid);
        m.addAttribute("invList", i);
        return "inventory-form";
    }


}
