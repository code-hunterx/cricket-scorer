package com.cricket.cricketscorer.service;

import java.util.List;
import java.util.Optional;

import com.cricket.cricketscorer.entity.Group;

public interface GroupService {
	
	public Optional<Group> getGroup(Long id);
	
	public Optional<List<Group>> getAllGroupsForTournament(Long tournamentId);

}
