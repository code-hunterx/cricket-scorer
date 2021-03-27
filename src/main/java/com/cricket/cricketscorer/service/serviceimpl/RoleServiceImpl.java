package com.cricket.cricketscorer.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.cricketscorer.entity.Role;
import com.cricket.cricketscorer.repository.RoleRepository;
import com.cricket.cricketscorer.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepo;

	@Override
	public Optional<Role> getRole(Long id) {
		return roleRepo.findById(id);
	}
	
	@Override
	public Optional<List<Role>> getAllRoles() {
		return Optional.ofNullable(roleRepo.findAll());
	}
}
