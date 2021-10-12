package br.com.projetoxp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Perks {
	
	private StatPerks statPerks;
	private List<Styles> styles;

	public Perks() {
		super();
	}

	public Perks(StatPerks statPerks, List<Styles> styles) {
		super();
		this.statPerks = statPerks;
		this.styles = styles;
	}
	
	public StatPerks getStatPerks() {
		return statPerks;
	}

	public List<Styles> getStyles() {
		return styles;
	}
	
}
