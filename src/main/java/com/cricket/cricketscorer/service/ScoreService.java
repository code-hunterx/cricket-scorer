package com.cricket.cricketscorer.service;

import com.cricket.cricketscorer.dto.ScoreDto;
import com.cricket.cricketscorer.entity.Score;

public interface ScoreService {
	
	public Score score(ScoreDto scoreDto);
	
	public Score addScore(Score score);
	
	public void deleteScore(Long id);

}
