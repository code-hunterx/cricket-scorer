package com.cricket.cricketscorer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricket.cricketscorer.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>{
	
}
