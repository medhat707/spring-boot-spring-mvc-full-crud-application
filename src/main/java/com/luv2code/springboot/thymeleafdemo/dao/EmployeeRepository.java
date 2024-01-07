package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.entity.Members;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {

	// that's it ... no need to write any code LOL!
	
	// EXTRA! adding method for sorting list of employees by last name
	// add implementation for it inside service implementation code	
	List<Employee> findAllByOrderByLastNameAsc();
	

}
