package com.cricket.cricketscorer.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.cricketscorer.entity.Match;
import com.cricket.cricketscorer.repository.MatchRepository;
import com.cricket.cricketscorer.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService{
	
	@Autowired
	MatchRepository matchRepo;
	
	@Override
	public Match addMatch(Match match) {
		return matchRepo.save(match);
	}

	@Override
	public void deleteMatch(Long id) {
		matchRepo.deleteById(id);
	}

}
