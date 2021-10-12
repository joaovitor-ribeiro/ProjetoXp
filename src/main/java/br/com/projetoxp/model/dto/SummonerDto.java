package br.com.projetoxp.model.dto;

public class SummonerDto {
	
	private String  name;
	private Long    level;
	private Long    kills;
	private Long    assists;
	private Long    deaths;
	private String 	gameMode;
	private boolean win;
	private String  champion;
	private String  profile;
	private String  match;
	private String  gameDuration;
	private Long  totalMinionKilled;
	
	public SummonerDto(String name, Long level, Long kills, Long assists, Long deaths, String gameMode, boolean win,
			String champion, String profile, String match, String gameDuration, Long totalMinionKilled) {
		super();
		this.name = name;
		this.level = level;
		this.kills = kills;
		this.assists = assists;
		this.deaths = deaths;
		this.gameMode = gameMode;
		this.win = win;
		this.champion = champion;
		this.profile = profile;
		this.match = match;
		this.gameDuration = gameDuration;
		this.totalMinionKilled = totalMinionKilled;
	}

	public String getName() {
		return name;
	}

	public Long getLevel() {
		return level;
	}

	public Long getKills() {
		return kills;
	}

	public Long getAssistis() {
		return assists;
	}

	public Long getDeath() {
		return deaths;
	}

	public String getGameMode() {
		return gameMode;
	}

	public boolean isWin() {
		return win;
	}

	public String getChampion() {
		return champion;
	}

	public String getProfile() {
		return profile;
	}

	public String getMatch() {
		return match;
	}

	public String getGameDuration() {
		return gameDuration;
	}

	public Long getTotalMinionKilled() {
		return totalMinionKilled;
	}
	
}
