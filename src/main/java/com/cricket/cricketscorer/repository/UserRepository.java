package com.cricket.cricketscorer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.cricketscorer.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	//Optional<User> findByUserName(String userName);

	Optional<User> findByEmail(String email);

}
