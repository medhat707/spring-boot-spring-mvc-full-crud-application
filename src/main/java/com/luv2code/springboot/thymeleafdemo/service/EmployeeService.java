package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.entity.Members;

public interface EmployeeService{

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
	
	
}
