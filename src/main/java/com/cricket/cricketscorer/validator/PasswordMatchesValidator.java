package com.cricket.cricketscorer.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cricket.cricketscorer.annotation.PasswordMatches;
import com.cricket.cricketscorer.dto.UserDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object>{
	
	  @Override
	    public void initialize(PasswordMatches constraintAnnotation) {       
	    }
	  
	    @Override
	    public boolean isValid(Object obj, ConstraintValidatorContext context){   
	        UserDto user = (UserDto) obj;
	        return user.getPassword().equals(user.getMatchingPassword());    
	    }     

}
