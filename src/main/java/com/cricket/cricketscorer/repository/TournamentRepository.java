package com.cricket.cricketscorer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.cricketscorer.entity.Tournament;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {

}
