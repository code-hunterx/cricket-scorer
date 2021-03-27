package com.cricket.cricketscorer.service;

import java.util.Optional;

import com.cricket.cricketscorer.entity.Player;

public interface PlayerService {
	
	public Optional<Player> addPlayer(Player player);
	
	public Optional<Player> getPlayer(Long id);
	
	public void deletePlayer(Long id); 
	
}
