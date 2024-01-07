package com.luv2code.springboot.thymeleafdemo.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.dao.MembersRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Members;
import com.luv2code.springboot.thymeleafdemo.entity.Roles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class MembersServiceImpl implements MembersService{

	
	private MembersRepository membersRepo;
		
	private EntityManager entityManager;
	

	@Autowired
	public MembersServiceImpl(MembersRepository ThemembersRepo) {
		membersRepo = ThemembersRepo;
	}
	
	
	@Override
	@Transactional
	public void save(Members member) {
//        member.(passwosetPasswordrdEncoder.encode(userDto.getPassword()));
		membersRepo.save(member);
	}

	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Members theMember = membersRepo.findUserIdCustomQuery(username);
		//
		if(theMember==null) {
			throw new UsernameNotFoundException("invalid user name");
			
		}
		return new org.springframework.security.core.userdetails.User(theMember.getUser_id() 
				, theMember.getPw() , mapRolesToAuthorities(theMember.getRoles()));
		
		
	}
//	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<Roles> roles) {
		// TODO Auto-generated method stub
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).
		collect(Collectors.toList());	}

//	

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities
	(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).
		collect(Collectors.toList());
			}
	
}
