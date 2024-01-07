package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Members;
import com.luv2code.springboot.thymeleafdemo.entity.Roles;

public interface MembersRepository  {


	Members findUserIdCustomQuery(String username);
	
	public void save(Members member);


}
