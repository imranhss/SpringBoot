package org.idb.TestSpringBoot.service;

import org.idb.TestSpringBoot.entity.Department;
import org.idb.TestSpringBoot.entity.Employee;
import org.idb.TestSpringBoot.repository.IDepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {


    @Autowired
    IDepartmentRepo repo;

    public void saveDep(Department d) {

        repo.save(d);
    }

    public void deleteDep(int did) {
        repo.deleteById(did);
    }

    public List<Department> getAllDep() {

        return repo.findAll();
    }

    public Department findDepById(int did) {

        return repo.findById(did).get();
    }

}
