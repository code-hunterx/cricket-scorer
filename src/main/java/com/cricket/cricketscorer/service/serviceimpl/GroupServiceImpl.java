package com.cricket.cricketscorer.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.cricketscorer.entity.Group;
import com.cricket.cricketscorer.repository.GroupRepository;
import com.cricket.cricketscorer.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService{
	
	@Autowired
	GroupRepository groupRepo;
	
	@Override
	public Optional<Group> getGroup(Long id) {
		return groupRepo.findById(id);
	}

	@Override
	public Optional<List<Group>> getAllGroupsForTournament(Long tournamentId) {
		return Optional.ofNullable(groupRepo.findByTournament(null));
	}

}
