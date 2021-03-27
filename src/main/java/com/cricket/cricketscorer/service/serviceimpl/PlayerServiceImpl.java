package com.cricket.cricketscorer.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.cricketscorer.entity.Player;
import com.cricket.cricketscorer.repository.PlayerRepository;
import com.cricket.cricketscorer.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired
	PlayerRepository playerRepo;
	
	@Override
	public Player addPlayer(Player player) {
		return playerRepo.save(player);
	}

	@Override
	public void deletePlayer(Long id) {
		playerRepo.deleteById(id);
	}

}
