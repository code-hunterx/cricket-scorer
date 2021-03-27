package com.cricket.cricketscorer.dto;

import lombok.Data;

@Data
public class ScoreDto {
	
	Long matchId;
	Integer runs;
	Boolean isOut;

}
