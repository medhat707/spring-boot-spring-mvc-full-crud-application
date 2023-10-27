package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		//get all employees from database
		// findAll() returns all employees -> storing result in a list
		List<Employee> theEmployees = employeeService.findAll();
	
		// add the list to the model 
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}
	
	@GetMapping("/showForm")
	public String showTheForm(Model theModel) {
		
		// create an employee entity object
		Employee employee = new Employee();
		
		//add the Employee to the Model
		theModel.addAttribute("employee" , employee);
		
		return "employees/employee-from";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		// saving theEmployee
		employeeService.save(employee);
		
		//debug
		System.out.println("print the employee " + employee);
		//redirect to the home page
	    return "redirect:/employees/list";
	}
	
	
	//this method takes the data entered through @RequestParam
	@GetMapping("/showFormForUpdate")
	public String showTheNewForm(@RequestParam("employeeId") int id , Model theModel) {
		// find the employee - get from service
		Employee theEmp = employeeService.findById(id);
		
		//put it in the model and sent it over to the form
		theModel.addAttribute("employee" , theEmp);
		
		return "employees/employee-from";

	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		//delete the employee
		employeeService.deleteById(theId);
		
		//redirect to the employees/list
	    return "redirect:/employees/list";

	}


}









