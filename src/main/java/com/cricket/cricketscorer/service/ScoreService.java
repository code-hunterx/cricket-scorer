package com.cricket.cricketscorer.service;

import java.util.Optional;

import com.cricket.cricketscorer.dto.ScoreDto;
import com.cricket.cricketscorer.entity.Score;

public interface ScoreService {
	
	public Score score(ScoreDto scoreDto);
	
	public Score addScore(Score score);
	
	public Optional<Score> getScore(Long id);
	
	public void deleteScore(Long id);

}
