package com.cricket.cricketscorer.service;

import com.cricket.cricketscorer.entity.Player;

public interface PlayerService {
	
	public Player addPlayer(Player player);
	
	public void deletePlayer(Long id); 
	
}
