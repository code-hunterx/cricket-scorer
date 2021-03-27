package com.cricket.cricketscorer.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cricket.cricketscorer.annotation.PasswordMatches;
import com.cricket.cricketscorer.annotation.ValidEmail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@PasswordMatches
public class UserDto { 
	@NotNull
    @NotEmpty
    private String firstName;
    
    @NotNull
    @NotEmpty
    private String lastName;
    
    @NotNull
    @NotEmpty
    private String password;
    
    private String matchingPassword;
    
    @NotNull
    @NotEmpty
	@ValidEmail
    private String email;
    
    private String fullname;
    
    private String roles;
	
}
