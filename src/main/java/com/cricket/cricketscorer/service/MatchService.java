package com.cricket.cricketscorer.service;

import java.util.Optional;

import com.cricket.cricketscorer.entity.Match;

public interface MatchService {
	
	public Match addMatch(Match match);
	
	public Optional<Match> getMatch(Long id);
	
	public void deleteMatch(Long id);

}
