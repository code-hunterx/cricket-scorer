package com.cricket.cricketscorer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.cricketscorer.entity.Group;
@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{
	
	List<Group> findByTournament(Long id);

}
