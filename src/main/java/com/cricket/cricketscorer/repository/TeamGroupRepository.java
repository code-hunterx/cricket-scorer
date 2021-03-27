package com.cricket.cricketscorer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.cricketscorer.entity.TeamGroup;

@Repository
public interface TeamGroupRepository extends JpaRepository<TeamGroup, Long>{

}
