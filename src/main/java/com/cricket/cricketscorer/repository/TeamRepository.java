package com.cricket.cricketscorer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.cricketscorer.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

}
