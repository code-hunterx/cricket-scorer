package com.cricket.cricketscorer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.cricketscorer.entity.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long>{

}
