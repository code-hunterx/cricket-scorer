package com.cricket.cricketscorer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.cricket.cricketscorer.dto"})
public class CricketScorerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricketScorerApplication.class, args);
	}

}
