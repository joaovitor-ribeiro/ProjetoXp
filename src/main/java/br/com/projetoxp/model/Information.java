package br.com.projetoxp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Information {
	
	private Long 	gameCreation;
	private Long	gameDuration;
	private Long 	gameId;
	private String 	gameMode;
	private String  gameName;
	private Long    gameStartTimestamp;
	private String  gameType;
	private String  gameVersion;
	private Long     mapId;
	private List<Participants> participants;
	private String 	platformId;
	private Long    queueId;
	private List<Teams> teams;
	private String tournamentCode;
	
	public Information() {
		super();
	}

	public Information(Long gameCreation, Long gameDuration, Long gameId, String gameMode, String gameName,
			Long gameStartTimestamp, String gameType, String gameVersion, Long mapId, List<Participants> participants,
			String platformId, Long queueId, List<Teams> teams, String tournamentCode) {
		super();
		this.gameCreation = gameCreation;
		this.gameDuration = gameDuration;
		this.gameId = gameId;
		this.gameMode = gameMode;
		this.gameName = gameName;
		this.gameStartTimestamp = gameStartTimestamp;
		this.gameType = gameType;
		this.gameVersion = gameVersion;
		this.mapId = mapId;
		this.participants = participants;
		this.platformId = platformId;
		this.queueId = queueId;
		this.teams = teams;
		this.tournamentCode = tournamentCode;
	}
	
	public Long getGameCreation() {
		return gameCreation;
	}
	public Long getGameDuration() {
		return gameDuration;
	}
	public Long getGameId() {
		return gameId;
	}
	public String getGameMode() {
		return gameMode;
	}
	public String getGameName() {
		return gameName;
	}
	public Long getGameStartTimestamp() {
		return gameStartTimestamp;
	}
	public String getGameType() {
		return gameType;
	}
	public String getGameVersion() {
		return gameVersion;
	}
	public Long getMapId() {
		return mapId;
	}
	public List<Participants> getParticipants() {
		return participants;
	}
	public String getPlatformId() {
		return platformId;
	}
	public Long getQueueId() {
		return queueId;
	}
	public List<Teams> getTeams() {
		return teams;
	}
	public String getTournamentCode() {
		return tournamentCode;
	}
	
}
