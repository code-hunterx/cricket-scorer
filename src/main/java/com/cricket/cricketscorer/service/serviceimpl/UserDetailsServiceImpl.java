package com.cricket.cricketscorer.service.serviceimpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cricket.cricketscorer.dto.UserDetailsImpl;
import com.cricket.cricketscorer.entity.User;
import com.cricket.cricketscorer.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(email);
		
		user.orElseThrow(()-> new UsernameNotFoundException("No matching username"));
		
		return user.map(UserDetailsImpl::new).get();
	}
		
}	
