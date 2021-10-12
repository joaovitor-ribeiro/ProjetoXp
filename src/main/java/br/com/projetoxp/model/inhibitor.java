package br.com.projetoxp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class inhibitor {
	
	private boolean first;
	private int kills;
	
	public inhibitor() {
		super();
	}
	
	public inhibitor(boolean first, int kills) {
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
