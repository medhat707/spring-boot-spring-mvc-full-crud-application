package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")

public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq")
	@SequenceGenerator(name = "roles_seq", sequenceName = "roles_seq", allocationSize = 1)
	@Column(name="id")
	private Integer id;

	@Column(name="role")
	private String role = "ROLE_EMPLOYEE" ;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id") // This establishes the FK relationship
    private Members member;

	//constructors
	public Roles() {}
	

	public Roles(String role) {
		super();
		this.role = role;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public Members getMember() {
		return member;
	}


	public void setMember(Members member) {
		this.member = member;
	}



	

	

}
