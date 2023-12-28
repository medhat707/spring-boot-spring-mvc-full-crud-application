package com.luv2code.springboot.thymeleafdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* -------- PREVIOUS LESSON ----------
 * ********** OLD CONTENT -> FROM LESSON 6 **********
 * adding a delete button
 * the same code as for the update button
 * STEPS:
 * 1. in the html for add the delete button
 * 	<a th:href="@{/employees/delete(employeeId=${tempEmployee.id})}"
 * adding support for prompt window using javascript code
 * onclick="if (!(confirm('Are you sure you want to delete this employee'))) return false">
 * -------- CURRENT LESSON ----------
 * ADDING SUPPORT FOR AOP FOR MVC CRUD APPLICATION
 * STEPS:
 * 1. ADDING AOP DEPENDECY
 * 2. Create an aspect package and a DemoLoggingAspect class
 * 3. setup pointcut declarations to match on controller, service and dao packages
 * 	and another pointcut for all of the packages
 * 4. add the @Before advice and add some code for displaying method arguments
 * 5. now open our server and press the update buttpn
 *
 * OUTCOME: 
 * 1.a   	calling methodEmployeeServiceImpl.findAll()
 * 1.b	    calling methodEmployeeRepository.findAllByOrderByLastNameAsc()
 * 1.c		calling methodEmployeeController.showTheNewForm(..) 
 * =======> arguement6
 * MEANING the button update tracks the method showTheNewForm
 * 
 * 6. add new information and press save button
 * 2.a	@Before: calling methodCrudRepository.save(..)
 * 2.b  calling methodEmployeeController.listEmployees(..) =======> argument{}
 * 2.c @Before: calling methodEmployeeServiceImpl.findAll()
 * 2.d @Before: calling methodEmployeeRepository.findAllByOrderByLastNameAsc()
 * 
 * MEANING: when saving controller goes over to service and service goes to dao layer
 * 7. add @AfterReturning
 * @Before: calling methodEmployeeServiceImpl.findAll()
@Before: calling methodEmployeeRepository.findAllByOrderByLastNameAsc()
@AfterReturning: from methodEmployeeRepository.findAllByOrderByLastNameAsc()
@AfterReturning: from methodEmployeeServiceImpl.findAll()
@AfterReturning: from methodEmployeeController.listEmployees(..)
 ===========> the result is: employees/list-employees
 MEANING: after all methods load .. the last method that has been finished is in the dao layer
 then in the service then in controller
 
 */
@SpringBootApplication
public class ThymeleafdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafdemoApplication.class, args);
	}

}
