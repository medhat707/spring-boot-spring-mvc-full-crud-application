package com.luv2code.springboot.thymeleafdemo.entity;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="members")
public class Members {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "members_seq")
	@SequenceGenerator(name = "members_seq", sequenceName = "members_seq", allocationSize = 1)
	@Column(name="id")
	private Integer id;
	
	@Id
	@Column(name="user_id")
	private String user_id;
	
	@Column(name="pw")
	private String pw;
	
	@Column(name="active")
	private int active=1;
	
	@OneToMany(mappedBy = "member" , cascade = CascadeType.ALL 
			, fetch = FetchType.EAGER)
    private List<Roles> roles;

	
	public Members() {}
	

	public Members(String user_id, String pw) {
		super();
		this.pw = pw;
		this.user_id = user_id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}


	public List<Roles> getRoles() {
		return roles;
	}


	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}


	//adding convenience method for bi-directional relationship
	public void add(Roles tempRole) {
		if (roles == null) {
			roles = new ArrayList<>();
		}
		
		roles.add(tempRole);
		tempRole.setMember(this);
		
	}

	
	
}

