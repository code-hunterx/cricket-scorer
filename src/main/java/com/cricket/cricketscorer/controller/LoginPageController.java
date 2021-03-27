package com.cricket.cricketscorer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.cricketscorer.dto.AuthenticationRequest;
import com.cricket.cricketscorer.dto.AuthenticationResponse;
import com.cricket.cricketscorer.dto.UserDto;
import com.cricket.cricketscorer.entity.User;
import com.cricket.cricketscorer.service.UserService;
import com.cricket.cricketscorer.service.serviceimpl.UserDetailsServiceImpl;
import com.cricket.cricketscorer.util.JwtUtil;

@CrossOrigin(origins= "*")
@RestController
public class LoginPageController {
	

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "/authenticate",method = RequestMethod.POST)
	public ResponseEntity<Object> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
			authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}catch(BadCredentialsException e) {
			throw new Exception("Incorrect Userame or Password",e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		final User user = userService.findUserByEmail(authenticationRequest.getUsername());
		return new ResponseEntity<Object>(new AuthenticationResponse(user,jwt), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users",method = RequestMethod.GET)
	public  ResponseEntity<Object> getAdminContent(){
		System.out.println("\n\n ********* inside /users API");
		return new ResponseEntity<Object>(new String("Hello...this is nirav"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	public String addUsers(){
		return "<h1>Hello World</h1>";
	}
	
	@RequestMapping(value = "/registration",method = RequestMethod.POST)
	public ResponseEntity<?> registerUserAccount(@RequestBody @Valid UserDto userDto) {
		User registered = new User();
		try {
	    	 registered = userService.registerNewUserAccount(userDto);
	    }catch(UnsupportedOperationException e) {
	    }
	    return new ResponseEntity<Object>(registered, HttpStatus.OK); 
	}

//	@RequestMapping(value = "/deleteAllUsers",method = RequestMethod.GET)
//	public ResponseEntity<?> deleteAllUsers() {
//		return new ResponseEntity<Object>(userService.deleteAllUsers(), HttpStatus.OK); 
//	}

}
