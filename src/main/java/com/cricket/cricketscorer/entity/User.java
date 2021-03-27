package com.cricket.cricketscorer.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id ;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="firstname")
	private String firstName;
	
	@Column(name ="lastname")
	private String lastName;
	
	@Column(name ="fullname")
	private String fullName;

	@Column(name ="password")
	private String password;
	
	@Column(name = "is_active")
	private Boolean active;
	
	@JsonManagedReference
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval=true)
	@Fetch(value= FetchMode.SUBSELECT)
	private List<UserRole> userRoles;

}
