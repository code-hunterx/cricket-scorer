package com.cricket.cricketscorer.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cricket.cricketscorer.entity.User;
import com.cricket.cricketscorer.entity.UserRole;


@SuppressWarnings("serial")
public class UserDetailsImpl implements UserDetails{
	
	private Long id;
	
	private String email;
	private String password;
	private Boolean active;
	private List<SimpleGrantedAuthority> authorities;
	
	public UserDetailsImpl(){
		
	}
	
	public UserDetailsImpl(User user){
		this.email=user.getEmail();
		this.password=user.getPassword();
		this.active =user.getActive();
		this.authorities = generateAuthorities(user.getUserRoles());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}
	
	public List<SimpleGrantedAuthority> generateAuthorities(List<UserRole> roles) {
		 List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		 roles.forEach((role)->authorities.add(new SimpleGrantedAuthority(role.getRole().getRoleName())));
		 return authorities;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(List<SimpleGrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	
}