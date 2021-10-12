package br.com.projetoxp.model.dto;

import java.util.List;

import br.com.projetoxp.model.Match;

public class MatchDto {
	
	private String summonerName;
	private Long kills;
	private Long assists;
	private Long death;
	private Long totalMinionsKilled;
	private String gameDuration;
	private boolean win;
	private String urlChampion;
	private String item0;
	private String item1;
	private String item2;
	private String item3;
	private String item4;
	private String item5;
	private String item6;
	private String venceu;
	

	public MatchDto(Match match, int i, String urlChampion, String gameDuration, 
			List<String> urlItem, String venceu) {
		this.summonerName = match.getinfo().getParticipants().get(i).getSummonerName();
		this.kills 		  = match.getinfo().getParticipants().get(i).getKills();
		this.assists	  = match.getinfo().getParticipants().get(i).getAssists();
		this.death	  	  = match.getinfo().getParticipants().get(i).getDeaths();
		this.totalMinionsKilled = match.getinfo().getParticipants().get(i).getTotalMinionsKilled();
		this.gameDuration = gameDuration;
		this.win 		  = match.getinfo().getParticipants().get(i).isWin();
		this.urlChampion  = urlChampion;
		this.item0 	      = urlItem.get(0);
		this.item1 	      = urlItem.get(1);
		this.item2 	      = urlItem.get(2);
		this.item3 	      = urlItem.get(3);
		this.item4	      = urlItem.get(4);
		this.item5 	      = urlItem.get(5);
		this.item6 	      = urlItem.get(6);
		this.venceu       = venceu;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public Long getKills() {
		return kills;
	}

	public void setKills(Long kills) {
		this.kills = kills;
	}

	public Long getAssists() {
		return assists;
	}

	public void setAssists(Long assists) {
		this.assists = assists;
	}

	public Long getDeath() {
		return death;
	}

	public void setDeath(Long death) {
		this.death = death;
	}

	public Long getTotalMinionsKilled() {
		return totalMinionsKilled;
	}

	public void setTotalMinionsKilled(Long totalMinionsKilled) {
		this.totalMinionsKilled = totalMinionsKilled;
	}

	public String getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(String gameDuration) {
		this.gameDuration = gameDuration;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public String getUrlChampion() {
		return urlChampion;
	}

	public void setUrlChampion(String urlChampion) {
		this.urlChampion = urlChampion;
	}

	public String getItem0() {
		return item0;
	}

	public void setItem0(String item0) {
		this.item0 = item0;
	}

	public String getItem1() {
		return item1;
	}

	public void setItem1(String item1) {
		this.item1 = item1;
	}

	public String getItem2() {
		return item2;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public String getItem3() {
		return item3;
	}

	public void setItem3(String item3) {
		this.item3 = item3;
	}

	public String getItem4() {
		return item4;
	}

	public void setItem4(String item4) {
		this.item4 = item4;
	}

	public String getItem5() {
		return item5;
	}

	public void setItem5(String item5) {
		this.item5 = item5;
	}

	public String getItem6() {
		return item6;
	}

	public void setItem6(String item6) {
		this.item6 = item6;
	}

	public String getVenceu() {
		return venceu;
	}

}
