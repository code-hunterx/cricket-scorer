package com.cricket.cricketscorer.service;

import com.cricket.cricketscorer.entity.Team;

public interface TeamService {
	
	public Team addTeam(Team team);
	
	public void deleteTeam(Long id);

}
