package com.cricket.cricketscorer.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tournament")
@Getter
@Setter
public class Tournament {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id ;
	
	private String name;
	
	private Date startDate;
	
	private Date endDate;
	
	private Integer totalMatches;
	
	@JsonManagedReference
	@OneToMany(mappedBy="tournament",cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval=true)
	@Fetch(value= FetchMode.SUBSELECT)
	private List<Group> allTeams;
	
}
