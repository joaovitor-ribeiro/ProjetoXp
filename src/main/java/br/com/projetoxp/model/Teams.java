package br.com.projetoxp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Teams {
	
	private List<Bans> 	bans;
	private Objectives 	objectives;
	private Long 		teamId;
	private boolean 	win;
	
	public Teams() {
		super();
	}

	public Teams(List<Bans> bans, Objectives objectives, Long teamId, boolean win) {
		super();
		this.bans = bans;
		this.objectives = objectives;
		this.teamId = teamId;
		this.win = win;
	}
	
	public List<Bans> getBans() {
		return bans;
	}
	public Objectives getObjectives() {
		return objectives;
	}
	public Long getTeamId() {
		return teamId;
	}
	public boolean isWin() {
		return win;
	}
}
