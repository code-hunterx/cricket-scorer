package com.cricket.cricketscorer.service.serviceimpl;

import java.util.List;
import java.util.Optional;

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
	public Optional<Match> addMatch(Match match) {
		return Optional.ofNullable(matchRepo.save(match));
	}

	@Override
	public void deleteMatch(Long id) {
		matchRepo.deleteById(id);
	}

	@Override
	public Optional<Match> getMatch(Long id){
		return  matchRepo.findById(id);
	}

	@Override
	public Optional<List<Match>> getAllMatchByTournament(Long tournamentId) {
		return Optional.ofNullable(matchRepo.findByTournament(tournamentId));
	}

}
