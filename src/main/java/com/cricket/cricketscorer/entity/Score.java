package com.cricket.cricketscorer.entity;


import java.sql.Timestamp;
import java.util.Date;

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
public class Score {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id ;
	
	private Match match;
	
	private Team battingTeam;
	
	private Team bowlingTeam;
	
	private Integer inning;
	
	private Integer totalRuns;
	
	private Integer currentBallRun;
	
	private Integer wicket;
	
	private Integer totalBalls;
	
	private Integer currentOverBall;
	
	private Integer over;
	
	private Timestamp currentTimeStamp ;
	
}
