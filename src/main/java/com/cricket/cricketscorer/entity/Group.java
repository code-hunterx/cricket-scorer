package com.cricket.cricketscorer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "group")
@Getter
@Setter
public class Group {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id ;
	
    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "tournament_id", nullable = false)
	private Tournament tournament;
	
    @JsonManagedReference
	@OneToMany(mappedBy="group",cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval=true)
	@Fetch(value= FetchMode.SUBSELECT)
	private List<TeamGroup> teamGroup;

}
