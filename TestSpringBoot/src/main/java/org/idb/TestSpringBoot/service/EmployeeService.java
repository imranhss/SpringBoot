package org.idb.TestSpringBoot.service;

import org.idb.TestSpringBoot.entity.Employee;
import org.idb.TestSpringBoot.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepo repo;

    public void saveEmp(Employee e){

        repo.save(e);
    }

    public  void deleteEmp(int eid){
        repo.deleteById(eid);
    }

    public List<Employee> getAllEmp(){

        return repo.findAll();
    }

    public Employee findEmpById(int eid){

        return  repo.findById(eid).get();
    }


}
