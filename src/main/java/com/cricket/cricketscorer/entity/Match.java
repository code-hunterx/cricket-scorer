package com.cricket.cricketscorer.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "match")
@Getter
@Setter
public class Match {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Team teamOne;
    
    private Team teamTwo;
    
    private Team batFirst;
    
    private Team bowlFirst;
    
    private Team tossWinner;
    
    private Team matchWinner;
    
    private Tournament tournament;
    
    private Boolean isDraw;
    
    private List<Player> playingTeamOne;
    
    private List<Player> playingTeamTwo;
    
    private String matchType ; 
    
    private Date startDate;
    
    private Date endDate;
    
}
