package com.cricket.cricketscorer.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.cricketscorer.entity.Tournament;
import com.cricket.cricketscorer.repository.TournamentRepository;
import com.cricket.cricketscorer.service.TournamentService;

@Service
public class TournamentServiceImpl implements TournamentService{
	
	@Autowired
	TournamentRepository tournamentRepo;

	@Override
	public Optional<Tournament> addTournament(Tournament tournament) {
		return Optional.ofNullable(tournamentRepo.save(null));
	}

	@Override
	public Optional<Tournament> getTournament(Long id) {
		return tournamentRepo.findById(id);
	}

}
