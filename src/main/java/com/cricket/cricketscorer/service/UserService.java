package com.cricket.cricketscorer.service;

import com.cricket.cricketscorer.dto.UserDto;
import com.cricket.cricketscorer.entity.User;

public interface UserService {
	
	public User registerNewUserAccount(UserDto userDto) ;
	
	public boolean deleteAllUsers();
	
	public User findUserByEmail(String email);
	
}
