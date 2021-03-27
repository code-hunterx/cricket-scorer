package com.cricket.cricketscorer.service;

import com.cricket.cricketscorer.entity.Match;

public interface MatchService {
	
	public Match addMatch(Match match);
	
	public void deleteMatch(Long id);

}
