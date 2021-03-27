package com.cricket.cricketscorer.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.cricketscorer.entity.Team;
import com.cricket.cricketscorer.repository.TeamRepository;
import com.cricket.cricketscorer.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService{
	
	@Autowired
	TeamRepository teamRepo;

	@Override
	public Team addTeam(Team team) {
		return teamRepo.save(team);
	}

	@Override
	public void deleteTeam(Long id) {
		teamRepo.deleteById(id);
	}

}
