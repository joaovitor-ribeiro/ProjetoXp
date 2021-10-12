package br.com.projetoxp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class tower {
	
	private boolean first;
	private int kills;
	
	public tower() {
		super();
	}
	
	public tower(boolean first, int kills) {
		super();
		this.first = first;
		this.kills = kills;
	}
	
	public boolean isFirst() {
		return first;
	}
	public int getKills() {
		return kills;
	}

}
