package br.com.projetoxp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Objectives {
	
	private Baron 		baron;
	private champion 	champion;
	private dragon 		dragon;
	private inhibitor 	inhibitor;
	private riftHerald 	riftHerald;
	private tower 		tower;
	
	public Objectives() {
		super();
	}

	public Objectives(Baron baron, champion champion,
			dragon dragon, inhibitor inhibitor,
			riftHerald riftHerald, tower tower) {
		super();
		this.baron = baron;
		this.champion = champion;
		this.dragon = dragon;
		this.inhibitor = inhibitor;
		this.riftHerald = riftHerald;
		this.tower = tower;
	}
	
	public Baron getBaron() {
		return baron;
	}
	public champion getChampion() {
		return champion;
	}
	public dragon getDragon() {
		return dragon;
	}
	public inhibitor getInhibitor() {
		return inhibitor;
	}
	public riftHerald getRiftHerald() {
		return riftHerald;
	}
	public tower getTower() {
		return tower;
	}
	
}
