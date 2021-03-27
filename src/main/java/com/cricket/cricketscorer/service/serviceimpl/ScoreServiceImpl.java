package com.cricket.cricketscorer.service.serviceimpl;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.cricketscorer.dto.ScoreDto;
import com.cricket.cricketscorer.entity.Match;
import com.cricket.cricketscorer.entity.Score;
import com.cricket.cricketscorer.repository.MatchRepository;
import com.cricket.cricketscorer.repository.ScoreRepository;
import com.cricket.cricketscorer.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	ScoreRepository scoreRepo;
	
	@Autowired
	MatchRepository matchRepo;
	
	@Override
	public Score addScore(Score score) {
		return scoreRepo.save(score);
	}

	@Override
	public void deleteScore(Long id) {
		 scoreRepo.deleteById(id);
	}

	@Override
	public Score score(ScoreDto scoreDto) {
		Optional<Score> optScore = scoreRepo.findLatestScoreEntry(scoreDto.getMatchId());
		Score newScore = new Score();
		if(!optScore.isPresent()) {
			//if no score entry is there means this is the first ball 
			newScore=createFirstScoreFromMatch(scoreDto);
		}else {
			//score entry is there means match has already started
			Score lastScore = optScore.get();
			newScore.setMatch(lastScore.getMatch());
			//balls and over 
			if(lastScore.getCurrentOverBall()!=6 ) {
				//same over, only ball increment
				newScore.setCurrentOverBall(lastScore.getCurrentOverBall()+1);
			}else {
				//over change
				newScore.setCurrentOverBall(0);
				newScore.setOver(lastScore.getOver()+1);
			}
			newScore.setTotalBalls(lastScore.getTotalBalls()+1);
			
			//wicket and run 
			if(scoreDto.getIsOut()) {
				newScore.setWicket(lastScore.getWicket()+1);
				newScore.setCurrentBallRun(0);
				newScore.setTotalRuns(lastScore.getTotalRuns());
			}else {
				newScore.setCurrentBallRun(scoreDto.getRuns());
				newScore.setTotalRuns(lastScore.getTotalRuns()+scoreDto.getRuns());
			}
			
			//can implement time based on match timezone here
			newScore.setCurrentTimeStamp(new Timestamp(System.currentTimeMillis()));
			
			if(newScore.getWicket()==10 || ( newScore.getOver() == 50 && newScore.getCurrentOverBall()==0) ) {
				//innings over ;
				if(lastScore.getInning()==1) {
					newScore.setInning(lastScore.getInning()+1);
					newScore = changeInnings(newScore);
				}else {
					newScore.setInning(lastScore.getInning()+1);
					newScore = matchEnd(newScore) ;
				}
			}
			newScore = scoreRepo.save(newScore);
				
					
		}
		return newScore;
	}
	
	
	private Score changeInnings (Score score) { 
		//change innings logic here
		return score;
	}
	
	private Score matchEnd (Score score) { 
		if(score.getMatch().getMatchType().equals("Test") && score.getInning()!=4) {
			//if match type is test then just change innings
			return changeInnings(score);
		}else {
			//match end logic 
		}
		return score;
	}
	
	private Score createFirstScoreFromMatch(ScoreDto scoreDto) {
		Optional<Match> optMatch = matchRepo.findById(scoreDto.getMatchId());
		Score score = new Score();
		if(optMatch.isPresent()) {
			Match match = optMatch.get();
			score.setBattingTeam(match.getBatFirst());
			score.setBowlingTeam(match.getBowlFirst());
			score.setCurrentOverBall(1);
			score.setCurrentBallRun(scoreDto.getRuns());
			score.setInning(1);
			score.setMatch(match);
			score.setOver(0);
			score.setTotalBalls(1);
			score.setTotalRuns(scoreDto.getRuns());
			score.setWicket(scoreDto.getIsOut()?1:0);
		}
		return score;
	}

	@Override
	public Optional<Score> getScore(Long id) {
		return scoreRepo.findById(id);
	}
	
	

}
