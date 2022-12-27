package org.idb.TestSpringBoot;

import org.idb.TestSpringBoot.entity.Employee;
import org.idb.TestSpringBoot.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestSpringBootApplicationTests {

	@Autowired
	EmployeeService service;

	@Test
	void testEmpSave(){
		Employee e=new Employee();
		e.setEAddress("Dhaka");
		e.setEEmail("dhaka@gmail.com");
		e.setEGender("Male");
		e.setEName("Jahid");
		service.saveEmp(e);

	}

	@Test
	void TestDelEmp(){
		service.deleteEmp(1);
	}

	@Test
	void TestListEmp(){
	Employee e=service.findEmpById(2);
		e.setEName("pp");
		service.saveEmp(e);
		System.out.println(e);
	}

}
