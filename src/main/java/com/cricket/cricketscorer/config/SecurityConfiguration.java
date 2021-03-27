package com.cricket.cricketscorer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.Transactional;

import com.cricket.cricketscorer.filter.CorsFilter;
import com.cricket.cricketscorer.filter.JwtRequestFilter;
import com.cricket.cricketscorer.service.serviceimpl.UserDetailsServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@Transactional
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	CorsFilter corsFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable().authorizeRequests()
		.antMatchers("/authenticate").permitAll()
		.antMatchers("/registration").permitAll()
		//.antMatchers("/deleteAllUsers").permitAll()
		.antMatchers("/users").permitAll()//.hasRole("USER")
		.antMatchers("/admin**").hasRole("ADMIN")
		.antMatchers("/tournamentAdmin**").hasRole("TOURNAMENTADMIN")
		.antMatchers("/scorer**").hasRole("SCORER")
		.anyRequest().authenticated()
		.and().formLogin()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);
		http.addFilterBefore(corsFilter,JwtRequestFilter.class);
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Bean
	 public PasswordEncoder passwordEncoder() {
		//return new BCryptPasswordEncoder();
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
