package com.luv2code.springboot.thymeleafdemo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.luv2code.springboot.thymeleafdemo.entity.Members;

public interface MembersService extends UserDetailsService{

	void save(Members member);



}
