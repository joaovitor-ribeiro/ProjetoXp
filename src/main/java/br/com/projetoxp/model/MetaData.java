package br.com.projetoxp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaData {
	
	private String dataVersion;
	private String matchId;
	private List<String> participants;
	
	public MetaData() {
		super();
	}
	
	public MetaData(String dataVersion, String matchId, List<String> participants) {
		super();
		this.dataVersion = dataVersion;
		this.matchId = matchId;
		this.participants = participants;
	}
	
	public String getDataVersion() {
		return dataVersion;
	}
	public String getMatchId() {
		return matchId;
	}
	public List<String> getParticipants() {
		return participants;
	}
	
}
