package com.cricket.cricketscorer.service;

import java.util.List;
import java.util.Optional;

import com.cricket.cricketscorer.entity.Match;

public interface MatchService {
	
	public Optional<Match> addMatch(Match match);
	
	public Optional<Match> getMatch(Long id);
	
	public Optional<List<Match>> getAllMatchByTournament(Long tournamentId);
	
	public void deleteMatch(Long id);

}
