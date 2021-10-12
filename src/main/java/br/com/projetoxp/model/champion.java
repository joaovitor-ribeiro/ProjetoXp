package br.com.projetoxp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class champion {
	
	private boolean first;
	private int kills;
	
	public champion() {
		super();
	}
	
	public champion(boolean first, int kills) {
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
