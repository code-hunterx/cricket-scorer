package com.cricket.cricketscorer.service;

import java.util.Optional;

import com.cricket.cricketscorer.entity.Tournament;

public interface TournamentService {
	
	public Optional<Tournament> addTournament(Tournament tournament);
	
	public Optional<Tournament> getTournament(Long id);
}
