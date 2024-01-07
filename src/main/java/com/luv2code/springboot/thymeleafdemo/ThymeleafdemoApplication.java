package com.luv2code.springboot.thymeleafdemo;

import java.lang.reflect.Member;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.luv2code.springboot.thymeleafdemo.entity.Members;
import com.luv2code.springboot.thymeleafdemo.entity.Roles;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import com.luv2code.springboot.thymeleafdemo.service.MembersService;


@SpringBootApplication
public class ThymeleafdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafdemoApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner commandLine(MembersService membersService , 
			EmployeeService empService 	) {
		return runner ->  {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findingInstructorDetail(appDAO);
			//deleteInstructorDetailsById(appDAO);
			//createUsersAndRoles(membersService);

		};
	}

	private void createUsersAndRoles(MembersService membersService ) {
		
		//create Member
		
		Members mem = new Members("luka" , "luka");
					
		//create role
		Roles role = new Roles("ROLE_EMPLOYEE");
		Roles role1 = new Roles("ROLE_MANAGER");
		Roles role2 = new Roles("ROLE_ADMIN");


		//associate objects together using the one to one relashionship
		mem.add(role);
		mem.add(role1);
		mem.add(role2);


		//save instructor
		System.out.println("saving Member " +mem);
		
		//save member
		membersService.save(mem);
	}

}
