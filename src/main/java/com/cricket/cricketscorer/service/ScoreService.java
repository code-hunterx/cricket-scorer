package com.cricket.cricketscorer.service;

import java.util.List;
import java.util.Optional;

import com.cricket.cricketscorer.dto.ScoreDto;
import com.cricket.cricketscorer.entity.Score;

public interface ScoreService {
	
	public Optional<Score> score(ScoreDto scoreDto);
	
	public Optional<Score> addScore(Score score);
	
	public Optional<Score> getScore(Long id);
	
	public void deleteScore(Long id);
	
	public Optional<List<Score>> getAllScoreByMatch(Long matchId);

}
