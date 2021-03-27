package com.cricket.cricketscorer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cricket.cricketscorer.entity.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
	
	@Query("Select s from Score s where s.currentTimeStamp = (Select max(s2.currentTimeStamp) from Score s2 where s2.matchId = :matchNum ) "
			+ "and s.matchId= :matchNum ")
	Optional<Score> findLatestScoreEntry( @Param("matchNum") Long matchId);

}
