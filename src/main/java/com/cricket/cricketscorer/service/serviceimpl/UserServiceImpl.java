package com.cricket.cricketscorer.service.serviceimpl;

import java.util.Arrays;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cricket.cricketscorer.dto.UserDto;
import com.cricket.cricketscorer.entity.Role;
import com.cricket.cricketscorer.entity.User;
import com.cricket.cricketscorer.entity.UserRole;
import com.cricket.cricketscorer.repository.RoleRepository;
import com.cricket.cricketscorer.repository.UserRepository;
import com.cricket.cricketscorer.service.UserService;

@SuppressWarnings("deprecation")
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	@Transactional
	@Override
	public User registerNewUserAccount(UserDto userDto) {

		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		NoOpPasswordEncoder encoder =  (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();

		if (emailExist(userDto.getEmail())) {
			throw new UnsupportedOperationException(
					"There is an account with that email address: " + userDto.getEmail());
		}

		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(encoder.encode(userDto.getPassword()));
		user.setEmail(userDto.getEmail().toLowerCase());
		user.setFullName(userDto.getFullname());
		user.setActive(true);
		UserRole userRole = new UserRole();
		if (roleRepository.findByRoleName("ROLE_USER").isPresent()) {
			Role role = roleRepository.findByRoleName("ROLE_USER").get();
			userRole.setRole(role);
			userRole.setUser(user);
			user.setUserRoles(Arrays.asList(userRole));
		}
		return userRepo.save(user);
	}

	private boolean emailExist(String email) {
		return userRepo.findByEmail(email).isPresent();
	}

	@Override
	public boolean deleteAllUsers() {
		try {
			userRepo.deleteAll();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public User findUserByEmail(String email) {
		Optional<User> user = userRepo.findByEmail(email);
		return user.get();
	}

}
