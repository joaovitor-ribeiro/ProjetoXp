package br.com.projetoxp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Participants {
	
	private Long 	assists;
	private Long	baronKills;
	private Long 	bountyLevel;
	private Long 	champExperience;
	private Long 	champLevel;
	private Long 	championId;
	private String  championName;
	private Long 	championTransform;
	private Long	consumablesPurchased;
	private Long 	damageDealtToBuildings;
	private Long 	damageDealtToObjectives;
	private Long 	damageDealtToTurrets;
	private Long 	damageSelfMitigated;
	private Long 	deaths;
	private Long 	detectorWardsPlaced;
	private Long 	doubleKills;
	private Long 	dragonKills;
	private boolean firstBloodAssist;
	private boolean firstBloodKill;
	private boolean firstTowerAssist;
	private boolean firstTowerKill;
	private boolean gameEndedInEarlySurrender;
	private boolean gameEndedInSurrender;
	private Long 	goldEarned;
	private Long 	goldSpent;
	private String  individualPosition;
	private Long 	inhibitorKills;
	private Long 	inhibitorTakedowns;
	private Long 	inhibitorsLost;
	private Long   	item0;
	private Long   	item1;
	private Long   	item2;
	private Long   	item3;
	private Long   	item4;
	private Long   	item5;
	private Long   	item6;
	private Long   	itemsPurchased;
	private Long   	killingSprees;
	private Long   	kills;
	private String  lane;
	private Long   	largestCriticalStrike;
	private Long   	largestKillingSpree;
	private Long   	largestMultiKill;
	private Long   	longestTimeSpentLiving;
	private Long   	magicDamageDealt;
	private Long   	magicDamageDealtToChampions;
	private Long   	magicDamageTaken;
	private Long   	neutralMinionsKilled;
	private Long   	nexusKills;
	private Long   	nexusLost;
	private Long   	nexusTakedowns;
	private Long   	objectivesStolen;
	private Long   	participantId;
	private Long   	pentaKills;
	private Perks   perks;
	private Long	physicalDamageDealt;
	private Long    physicalDamageDealtToChampions;
	private Long    physicalDamageTaken;
	private Long    profileIcon;
	private String  puuid;
	private Long    quadraKills;
	private String  riotIdName;
	private String  riotIdTagline;
	private String  role;
	private Long    sightWardsBoughtInGame;
	private Long    spell1Casts;
	private Long    spell2Casts;
	private Long    spell3Casts;
	private Long    spell4Casts;
	private Long    summoner1Casts;
	private Long    summoner1Id;
	private Long    summoner2Casts;
	private Long    summoner2Id;
	private String  summonerId;
	private Long    summonerLevel;
	private String  summonerName;
	private boolean teamEarlySurrendered;
	private Long 	teamId;
	private String 	teamPosition;
	private Long 	timeCCingOthers;
	private Long 	timePlayed;
	private Long 	totalDamageDealt;
	private Long 	totalDamageDealtToChampions;
	private Long 	totalDamageShieldedOnTeammates;
	private Long 	totalDamageTaken;
	private Long 	totalHeal;
	private Long 	totalHealsOnTeammates;
	private Long 	totalMinionsKilled;
	private Long 	totalTimeCCDealt;
	private Long 	totalTimeSpentDead;
	private Long 	totalUnitsHealed;
	private Long 	tripleKills;
	private Long 	trueDamageDealt;
	private Long 	trueDamageDealtToChampions;
	private Long 	trueDamageTaken;
	private Long 	turretKills;
	private Long 	turretTakedowns;
	private Long 	turretsLost;
	private Long 	unrealKills;
	private Long 	visionScore;
	private Long 	visionWardsBoughtInGame;
	private Long 	wardsKilled;
	private Long 	wardsPlaced;
	private boolean win;
	
	public Participants() {
		super();
	}

	public Participants(Long assists, Long baronKills, Long bountyLevel, Long champExperience, Long champLevel,
			Long championId, String championName, Long championTransform, Long consumablesPurchased,
			Long damageDealtToBuildings, Long damageDealtToObjectives, Long damageDealtToTurrets, Long damageSelfMitigated,
			Long deaths, Long detectorWardsPlaced, Long doubleKills, Long dragonKills, boolean firstBloodAssist,
			boolean firstBloodKill, boolean firstTowerAssist, boolean firstTowerKill, boolean gameEndedInEarlySurrender,
			boolean gameEndedInSurrender, Long goldEarned, Long goldSpent, String individualPosition, Long inhibitorKills,
			Long inhibitorTakedowns, Long inhibitorsLost, Long item0, Long item1, Long item2, Long item3, Long item4,
			Long item5, Long item6, Long itemsPurchased, Long killingSprees, Long kills, String lane,
			Long largestCriticalStrike, Long largestKillingSpree, Long largestMultiKill, Long longestTimeSpentLiving,
			Long magicDamageDealt, Long magicDamageDealtToChampions, Long magicDamageTaken, Long neutralMinionsKilled,
			Long nexusKills, Long nexusLost, Long nexusTakedowns, Long objectivesStolen, Long participantId, Long pentaKills,
			Perks perks, Long physicalDamageDealt, Long physicalDamageDealtToChampions, Long physicalDamageTaken,
			Long profileIcon, String puuid, Long quadraKills, String riotIdName, String riotIdTagline, String role,
			Long sightWardsBoughtInGame, Long spell1Casts, Long spell2Casts, Long spell3Casts, Long spell4Casts,
			Long summoner1Casts, Long summoner1Id, Long summoner2Casts, Long summoner2Id, String summonerId,
			Long summonerLevel, String summonerName, boolean teamEarlySurrendered, Long teamId, String teamPosition,
			Long timeCCingOthers, Long timePlayed, Long totalDamageDealt, Long totalDamageDealtToChampions,
			Long totalDamageShieldedOnTeammates, Long totalDamageTaken, Long totalHeal, Long totalHealsOnTeammates,
			Long totalMinionsKilled, Long totalTimeCCDealt, Long totalTimeSpentDead, Long totalUnitsHealed,
			Long tripleKills, Long trueDamageDealt, Long trueDamageDealtToChampions, Long trueDamageTaken, Long turretKills,
			Long turretTakedowns, Long turretsLost, Long unrealKills, Long visionScore, Long visionWardsBoughtInGame,
			Long wardsKilled, Long wardsPlaced, boolean win) {
		super();
		this.assists = assists;
		this.baronKills = baronKills;
		this.bountyLevel = bountyLevel;
		this.champExperience = champExperience;
		this.champLevel = champLevel;
		this.championId = championId;
		this.championName = championName;
		this.championTransform = championTransform;
		this.consumablesPurchased = consumablesPurchased;
		this.damageDealtToBuildings = damageDealtToBuildings;
		this.damageDealtToObjectives = damageDealtToObjectives;
		this.damageDealtToTurrets = damageDealtToTurrets;
		this.damageSelfMitigated = damageSelfMitigated;
		this.deaths = deaths;
		this.detectorWardsPlaced = detectorWardsPlaced;
		this.doubleKills = doubleKills;
		this.dragonKills = dragonKills;
		this.firstBloodAssist = firstBloodAssist;
		this.firstBloodKill = firstBloodKill;
		this.firstTowerAssist = firstTowerAssist;
		this.firstTowerKill = firstTowerKill;
		this.gameEndedInEarlySurrender = gameEndedInEarlySurrender;
		this.gameEndedInSurrender = gameEndedInSurrender;
		this.goldEarned = goldEarned;
		this.goldSpent = goldSpent;
		this.individualPosition = individualPosition;
		this.inhibitorKills = inhibitorKills;
		this.inhibitorTakedowns = inhibitorTakedowns;
		this.inhibitorsLost = inhibitorsLost;
		this.item0 = item0;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.item4 = item4;
		this.item5 = item5;
		this.item6 = item6;
		this.itemsPurchased = itemsPurchased;
		this.killingSprees = killingSprees;
		this.kills = kills;
		this.lane = lane;
		this.largestCriticalStrike = largestCriticalStrike;
		this.largestKillingSpree = largestKillingSpree;
		this.largestMultiKill = largestMultiKill;
		this.longestTimeSpentLiving = longestTimeSpentLiving;
		this.magicDamageDealt = magicDamageDealt;
		this.magicDamageDealtToChampions = magicDamageDealtToChampions;
		this.magicDamageTaken = magicDamageTaken;
		this.neutralMinionsKilled = neutralMinionsKilled;
		this.nexusKills = nexusKills;
		this.nexusLost = nexusLost;
		this.nexusTakedowns = nexusTakedowns;
		this.objectivesStolen = objectivesStolen;
		this.participantId = participantId;
		this.pentaKills = pentaKills;
		this.perks = perks;
		this.physicalDamageDealt = physicalDamageDealt;
		this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
		this.physicalDamageTaken = physicalDamageTaken;
		this.profileIcon = profileIcon;
		this.puuid = puuid;
		this.quadraKills = quadraKills;
		this.riotIdName = riotIdName;
		this.riotIdTagline = riotIdTagline;
		this.role = role;
		this.sightWardsBoughtInGame = sightWardsBoughtInGame;
		this.spell1Casts = spell1Casts;
		this.spell2Casts = spell2Casts;
		this.spell3Casts = spell3Casts;
		this.spell4Casts = spell4Casts;
		this.summoner1Casts = summoner1Casts;
		this.summoner1Id = summoner1Id;
		this.summoner2Casts = summoner2Casts;
		this.summoner2Id = summoner2Id;
		this.summonerId = summonerId;
		this.summonerLevel = summonerLevel;
		this.summonerName = summonerName;
		this.teamEarlySurrendered = teamEarlySurrendered;
		this.teamId = teamId;
		this.teamPosition = teamPosition;
		this.timeCCingOthers = timeCCingOthers;
		this.timePlayed = timePlayed;
		this.totalDamageDealt = totalDamageDealt;
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
		this.totalDamageShieldedOnTeammates = totalDamageShieldedOnTeammates;
		this.totalDamageTaken = totalDamageTaken;
		this.totalHeal = totalHeal;
		this.totalHealsOnTeammates = totalHealsOnTeammates;
		this.totalMinionsKilled = totalMinionsKilled;
		this.totalTimeCCDealt = totalTimeCCDealt;
		this.totalTimeSpentDead = totalTimeSpentDead;
		this.totalUnitsHealed = totalUnitsHealed;
		this.tripleKills = tripleKills;
		this.trueDamageDealt = trueDamageDealt;
		this.trueDamageDealtToChampions = trueDamageDealtToChampions;
		this.trueDamageTaken = trueDamageTaken;
		this.turretKills = turretKills;
		this.turretTakedowns = turretTakedowns;
		this.turretsLost = turretsLost;
		this.unrealKills = unrealKills;
		this.visionScore = visionScore;
		this.visionWardsBoughtInGame = visionWardsBoughtInGame;
		this.wardsKilled = wardsKilled;
		this.wardsPlaced = wardsPlaced;
		this.win = win;
	}
	
	public Long getAssists() {
		return assists;
	}
	public Long getBaronKills() {
		return baronKills;
	}
	public Long getBountyLevel() {
		return bountyLevel;
	}
	public Long getChampExperience() {
		return champExperience;
	}
	public Long getChampLevel() {
		return champLevel;
	}
	public Long getChampionId() {
		return championId;
	}
	public String getChampionName() {
		return championName;
	}
	public Long getChampionTransform() {
		return championTransform;
	}
	public Long getConsumablesPurchased() {
		return consumablesPurchased;
	}
	public Long getDamageDealtToBuildings() {
		return damageDealtToBuildings;
	}
	public Long getDamageDealtToObjectives() {
		return damageDealtToObjectives;
	}
	public Long getDamageDealtToTurrets() {
		return damageDealtToTurrets;
	}
	public Long getDamageSelfMitigated() {
		return damageSelfMitigated;
	}
	public Long getDeaths() {
		return deaths;
	}
	public Long getDetectorWardsPlaced() {
		return detectorWardsPlaced;
	}
	public Long getDoubleKills() {
		return doubleKills;
	}
	public Long getDragonKills() {
		return dragonKills;
	}
	public boolean isFirstBloodAssist() {
		return firstBloodAssist;
	}
	public boolean isFirstBloodKill() {
		return firstBloodKill;
	}
	public boolean isFirstTowerAssist() {
		return firstTowerAssist;
	}
	public boolean isFirstTowerKill() {
		return firstTowerKill;
	}
	public boolean isGameEndedInEarlySurrender() {
		return gameEndedInEarlySurrender;
	}
	public boolean isGameEndedInSurrender() {
		return gameEndedInSurrender;
	}
	public Long getGoldEarned() {
		return goldEarned;
	}
	public Long getGoldSpent() {
		return goldSpent;
	}
	public String getIndividualPosition() {
		return individualPosition;
	}
	public Long getInhibitorKills() {
		return inhibitorKills;
	}
	public Long getInhibitorTakedowns() {
		return inhibitorTakedowns;
	}
	public Long getInhibitorsLost() {
		return inhibitorsLost;
	}
	public Long getItem0() {
		return item0;
	}
	public Long getItem1() {
		return item1;
	}
	public Long getItem2() {
		return item2;
	}
	public Long getItem3() {
		return item3;
	}
	public Long getItem4() {
		return item4;
	}
	public Long getItem5() {
		return item5;
	}
	public Long getItem6() {
		return item6;
	}
	public Long getItemsPurchased() {
		return itemsPurchased;
	}
	public Long getKillingSprees() {
		return killingSprees;
	}
	public Long getKills() {
		return kills;
	}
	public String getLane() {
		return lane;
	}
	public Long getLargestCriticalStrike() {
		return largestCriticalStrike;
	}
	public Long getLargestKillingSpree() {
		return largestKillingSpree;
	}
	public Long getLargestMultiKill() {
		return largestMultiKill;
	}
	public Long getLongestTimeSpentLiving() {
		return longestTimeSpentLiving;
	}
	public Long getMagicDamageDealt() {
		return magicDamageDealt;
	}
	public Long getMagicDamageDealtToChampions() {
		return magicDamageDealtToChampions;
	}
	public Long getMagicDamageTaken() {
		return magicDamageTaken;
	}
	public Long getNeutralMinionsKilled() {
		return neutralMinionsKilled;
	}
	public Long getNexusKills() {
		return nexusKills;
	}
	public Long getNexusLost() {
		return nexusLost;
	}
	public Long getNexusTakedowns() {
		return nexusTakedowns;
	}
	public Long getObjectivesStolen() {
		return objectivesStolen;
	}
	public Long getParticipantId() {
		return participantId;
	}
	public Long getPentaKills() {
		return pentaKills;
	}
	public Perks getPerks() {
		return perks;
	}
	public Long getPhysicalDamageDealt() {
		return physicalDamageDealt;
	}
	public Long getPhysicalDamageDealtToChampions() {
		return physicalDamageDealtToChampions;
	}
	public Long getPhysicalDamageTaken() {
		return physicalDamageTaken;
	}
	public Long getProfileIcon() {
		return profileIcon;
	}
	public String getPuuid() {
		return puuid;
	}
	public Long getQuadraKills() {
		return quadraKills;
	}
	public String getRiotIdName() {
		return riotIdName;
	}
	public String getRiotIdTagline() {
		return riotIdTagline;
	}
	public String getRole() {
		return role;
	}
	public Long getSightWardsBoughtInGame() {
		return sightWardsBoughtInGame;
	}
	public Long getSpell1Casts() {
		return spell1Casts;
	}
	public Long getSpell2Casts() {
		return spell2Casts;
	}
	public Long getSpell3Casts() {
		return spell3Casts;
	}
	public Long getSpell4Casts() {
		return spell4Casts;
	}
	public Long getSummoner1Casts() {
		return summoner1Casts;
	}
	public Long getSummoner1Id() {
		return summoner1Id;
	}
	public Long getSummoner2Casts() {
		return summoner2Casts;
	}
	public Long getSummoner2Id() {
		return summoner2Id;
	}
	public String getSummonerId() {
		return summonerId;
	}
	public Long getSummonerLevel() {
		return summonerLevel;
	}
	public String getSummonerName() {
		return summonerName;
	}
	public boolean isTeamEarlySurrendered() {
		return teamEarlySurrendered;
	}
	public Long getTeamId() {
		return teamId;
	}
	public String getTeamPosition() {
		return teamPosition;
	}
	public Long getTimeCCingOthers() {
		return timeCCingOthers;
	}
	public Long getTimePlayed() {
		return timePlayed;
	}
	public Long getTotalDamageDealt() {
		return totalDamageDealt;
	}
	public Long getTotalDamageDealtToChampions() {
		return totalDamageDealtToChampions;
	}
	public Long getTotalDamageShieldedOnTeammates() {
		return totalDamageShieldedOnTeammates;
	}
	public Long getTotalDamageTaken() {
		return totalDamageTaken;
	}
	public Long getTotalHeal() {
		return totalHeal;
	}
	public Long getTotalHealsOnTeammates() {
		return totalHealsOnTeammates;
	}
	public Long getTotalMinionsKilled() {
		return totalMinionsKilled;
	}
	public Long getTotalTimeCCDealt() {
		return totalTimeCCDealt;
	}
	public Long getTotalTimeSpentDead() {
		return totalTimeSpentDead;
	}
	public Long getTotalUnitsHealed() {
		return totalUnitsHealed;
	}
	public Long getTripleKills() {
		return tripleKills;
	}
	public Long getTrueDamageDealt() {
		return trueDamageDealt;
	}
	public Long getTrueDamageDealtToChampions() {
		return trueDamageDealtToChampions;
	}
	public Long getTrueDamageTaken() {
		return trueDamageTaken;
	}
	public Long getTurretKills() {
		return turretKills;
	}
	public Long getTurretTakedowns() {
		return turretTakedowns;
	}
	public Long getTurretsLost() {
		return turretsLost;
	}
	public Long getUnrealKills() {
		return unrealKills;
	}
	public Long getVisionScore() {
		return visionScore;
	}
	public Long getVisionWardsBoughtInGame() {
		return visionWardsBoughtInGame;
	}
	public Long getWardsKilled() {
		return wardsKilled;
	}
	public Long getWardsPlaced() {
		return wardsPlaced;
	}
	public boolean isWin() {
		return win;
	}
	
}
