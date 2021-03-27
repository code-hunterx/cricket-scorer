package com.cricket.cricketscorer.service;

import java.util.List;
import java.util.Optional;

import com.cricket.cricketscorer.entity.Role;

public interface RoleService {
	
	public Optional<Role> getRole(Long id);
	
	public Optional<List<Role>> getAllRoles();
}
