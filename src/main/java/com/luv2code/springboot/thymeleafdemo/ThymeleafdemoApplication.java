package com.luv2code.springboot.thymeleafdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* -------- PREVIOUS LESSON ----------
 * in this code i will add update buttons for each employee 
 * STEPS:
 * 1. open html form and add the button in a new column in list-employees.html
 * add the reference for the new form for updating 	
 * <a th:href="@{/employees/showFormForUpdate(employeeId=${tempEmployee.id})"
 * that means after clicking on the button the request is sent to employeeId=XXX
 * 2. in controller add the new GetMapping showFormForUpdate
 * the new form takes the employeeId=XXX from the form and puts it in the model
 * 3. adding hidden form field to handle the update
 * NOW we had field that bind to firstName, lastName, ...etc
 * BUT we want to have a hidden field for handling updates as well
 * HERE comes the hidden input field - through it, thymeleaf tells the app 
 * which employee to update
 * -------- CURRENT LESSON ----------
 * adding a delete button
 * the same code as for the update button
 * STEPS:
 * 1. in the html for add the delete button
 * 	<a th:href="@{/employees/delete(employeeId=${tempEmployee.id})}"
 * adding support for prompt window using javascript code
 * onclick="if (!(confirm('Are you sure you want to delete this employee'))) return false">

 */
@SpringBootApplication
public class ThymeleafdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafdemoApplication.class, args);
	}

}
