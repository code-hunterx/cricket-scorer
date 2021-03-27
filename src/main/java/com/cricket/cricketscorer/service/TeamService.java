package com.cricket.cricketscorer.service;

import java.util.Optional;

import com.cricket.cricketscorer.entity.Team;

public interface TeamService {
	
	public Optional<Team> addTeam(Team team);
	
	public Optional<Team> getTeam(Long id);
	
	public void deleteTeam(Long id);
	
}
