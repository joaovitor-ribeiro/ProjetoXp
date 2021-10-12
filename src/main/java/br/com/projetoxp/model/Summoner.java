package br.com.projetoxp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Summoner {
	
	private String accountId;    
	private int    profileIconId;
	private Long   revisionDate; 
	private String name;         
	private String id;           
	private String puuid;        
	private Long   summonerLevel;
	
	public Summoner() {
		super();
	}

	public Summoner(String accountId, int profileIconId, Long revisionDate, String name, String id, String puuid,
			Long summonerLevel) {
		super();
		this.accountId = accountId;
		this.profileIconId = profileIconId;
		this.revisionDate = revisionDate;
		this.name = name;
		this.id = id;
		this.puuid = puuid;
		this.summonerLevel = summonerLevel;
	}

	public String getAccountId() {
		return accountId;
	}

	public int getProfileIconId() {
		return profileIconId;
	}

	public Long getRevisionDate() {
		return revisionDate;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPuuid() {
		return puuid;
	}

	public Long getSummonerLevel() {
		return summonerLevel;
	}

}
