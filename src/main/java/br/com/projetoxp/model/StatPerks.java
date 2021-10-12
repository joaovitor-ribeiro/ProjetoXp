package br.com.projetoxp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatPerks {
	
	private Long defense;
	private Long flex;
	private Long offense;
	
	public StatPerks() {
		super();
	}
	
	public StatPerks(Long defense, Long flex, Long offense) {
		super();
		this.defense = defense;
		this.flex = flex;
		this.offense = offense;
	}
	
	public Long getDefense() {
		return defense;
	}
	public Long getFlex() {
		return flex;
	}
	public Long getOffense() {
		return offense;
	}

}
