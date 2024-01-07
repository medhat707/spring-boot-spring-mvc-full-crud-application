package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.entity.Members;

@Controller
public class DemoController {

	// create a mapping for "/hello"
	
	@GetMapping("/hello")
	public String sayHello(Model theModel) {
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		return "helloworld";
	}
	
	@GetMapping("/TheSystems")
	public String showSystems(Model theModel, @ModelAttribute("employee") Employee employee
			, @ModelAttribute("theMember") Members member) {
			
			//modified version of model
       // 	employee.setFirstName(employee.getFirstName() + " (Modified)");
		//	theModel.addAttribute("modifiedEmployee", employee);
			return "systems";
		}
	

	@GetMapping("/login")
	public String showLoginForm(Model theModel) {
		
		//create object from member
		//Members theMember = new Members();
		//add the Member to the Model
		//theModel.addAttribute("member" , theMember);
		
		return "fancy-login";
	}


    @PostMapping("/login")
    public String authenticate(@ModelAttribute("member") Members theMember) {
        // Perform authentication logic here
    	
    	String username = theMember.getUser_id();
    	String password = theMember.getPw();
//    	
//    	if ("admin".equals(username) && "admin".equals(password)) {
//    		return "redirect:/employees/list"; // Redirect to the home page after successful login
//    		}	
		return "plain-login"; // Redirect to the home page after successful login
}
    
	@GetMapping("/register")
	public String registeration(Model theModel) {
		
		// create an employee entity object
		Employee employee = new Employee();
		
		//create object from member
		Members theMember = new Members();
		
		//add the Employee to the Model
		theModel.addAttribute("employee" , employee);
		//add the Member to the Model
		theModel.addAttribute("member" , theMember);
		
		return "employees/employee-from";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDeniedPage() {
		
		return "access-denied";
	}

}









