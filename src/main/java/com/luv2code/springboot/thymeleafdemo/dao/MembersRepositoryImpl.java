package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.thymeleafdemo.entity.Members;
import com.luv2code.springboot.thymeleafdemo.entity.Roles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class MembersRepositoryImpl implements MembersRepository{
	
	private EntityManager entityManager;
	private PasswordEncoder passwordEnocder;
	
	@Autowired
	public MembersRepositoryImpl(EntityManager entityManager ,
			PasswordEncoder passwordEnocder) {
		this.entityManager =entityManager;
		this.passwordEnocder = passwordEnocder;

	}
	
	public Members findUserIdCustomQuery(String user_id) {
		// TODO Auto-generated method stub
		
		//create query
		TypedQuery<Members> theQuery=
				entityManager.createQuery("SELECT m FROM Members m WHERE m.user_id = :userId" 
						, Members.class);
		
		theQuery.setParameter("userId", user_id);
		
        return theQuery.getSingleResult();

	}


	
	@Override
	public void save(Members member) {
		// TODO Auto-generated method stub
	    member.setPw("{bcrypt}" + passwordEnocder.encode(member.getPw()));
		
	    
		entityManager.persist(member);
		
	}

	
		
//	
//	@Transactional
//	public void saveMember(Members member) {
//		entityManager.persist(member);
//	}

	 
}

