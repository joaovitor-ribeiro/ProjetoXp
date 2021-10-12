package br.com.projetoxp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bans {
	
	private int championId;
	private int pickTurn;
	
	public Bans() {
		super();
	}
	
	public Bans(int championId, int pickTurn) {
		super();
		this.championId = championId;
		this.pickTurn = pickTurn;
	}
	
	public int getChampionId() {
		return championId;
	}
	public int getPickTurn() {
		return pickTurn;
	}

}
