package org.idb.TestSpringBoot.controller;

import org.idb.TestSpringBoot.entity.Department;
import org.idb.TestSpringBoot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService service;
    @RequestMapping("/departments")
    public  String allDep(Model m){
//        List<Department> listDep=service.getAllDep();
        m.addAttribute("viewDep", service.getAllDep());// Show All Department as a Table
        m.addAttribute("dep", new Department()); // Show save form for Department
        return  "dep_list";
    }

    @RequestMapping(value = "/dep_save", method = RequestMethod.POST)
    public  String addDep(@ModelAttribute("dep") Department dep){
        service.saveDep(dep);
        return  "redirect:/departments";
    }

}
