package com.cricket.cricketscorer.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cricket.cricketscorer.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse implements Serializable {

	private static final long serialVersionUID = -94103800740737871L;
	private final String type = "Bearer";
	private final Long id;
	private final String email;
	private final String fname;
	private final String lname;

	private final String fullname;
	private final List<String> roles = new ArrayList<>();

	private final String token;
	
	public AuthenticationResponse(User user,String token) {
		this.id = user.getId();
		this.email=user.getEmail();
		this.fname = user.getFirstName();
		this.lname = user.getLastName();
		this.fullname = user.getFullName();
		user.getUserRoles().forEach(x->roles.add(x.getRole().getRoleName()));
		this.token = token;
	}


}
