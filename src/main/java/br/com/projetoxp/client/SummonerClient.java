package br.com.projetoxp.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projetoxp.model.Match;
import br.com.projetoxp.model.Summoner;
import br.com.projetoxp.model.dto.SummonerDto;

@Service
public class SummonerClient {
	
	@Value("${fx.apikey}")
    private String key;
    @Value("${fx.url.summoner.byname}")
    private String byNameUrl;
    @Value("${fx.url.summoner.profile}")
    private String profileUrl;
    @Value("${fx.url.summoner.champion}")
    private String chamiponUrl;
    
    @Autowired
    private RestTemplate restTemplate;
	
	public Summoner getSummonerByName(String name) {
		
		try {
			
			HttpHeaders headers = new HttpHeaders();
	        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

	        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(byNameUrl)
	                .path(name.replaceAll(" ", ""))
	                .queryParam("api_key", key);

	        HttpEntity<?> entity = new HttpEntity<>(headers);

	        HttpEntity<Summoner> response = restTemplate.exchange(
	                builder.toUriString(),
	                HttpMethod.GET,
	                entity,
	                Summoner.class
	        );
	        
	        return response.getBody();
	        
		} catch (Exception e) {
			return null;
		}
    }

	public List<SummonerDto> listaSummerDto(Summoner summoner, List<Match> matchInfo, String name) {
		
		List<SummonerDto> summonerDto  = new ArrayList<SummonerDto>();
		UriComponentsBuilder builder;
		String gameDuration;
		
		builder = UriComponentsBuilder.fromHttpUrl(profileUrl)
                .path(String.valueOf(summoner.getProfileIconId())+".png");
		String profileIcon = builder.toUriString();
	
		for (int i = 0; i < matchInfo.size(); i++) {
			gameDuration = tempoDePartida(matchInfo.get(i).getinfo().getGameDuration());
			for (int j = 0; j < matchInfo.get(i).getinfo().getParticipants().size() ; j++) {
				if(name.equals(matchInfo.get(i).getinfo().getParticipants().get(j).getSummonerName())){
					builder = UriComponentsBuilder.fromHttpUrl(chamiponUrl)
			                .path(String.valueOf(matchInfo.get(i).getinfo().getParticipants().get(j).getChampionName()) + ".png");
					String urlChampion = builder.toUriString();
					summonerDto.add( new SummonerDto(
							matchInfo.get(i).getinfo().getParticipants().get(j).getSummonerName(),
							matchInfo.get(i).getinfo().getParticipants().get(j).getSummonerLevel(),
							matchInfo.get(i).getinfo().getParticipants().get(j).getKills(),
							matchInfo.get(i).getinfo().getParticipants().get(j).getAssists(),
							matchInfo.get(i).getinfo().getParticipants().get(j).getDeaths(),
							matchInfo.get(i).getinfo().getGameMode(),
							matchInfo.get(i).getinfo().getParticipants().get(j).isWin(),
							urlChampion,
							profileIcon,
							matchInfo.get(i).getmetadata().getMatchId(),
							gameDuration,
							matchInfo.get(i).getinfo().getParticipants().get(j).getTotalMinionsKilled()
							));
				}
			}
		}
		return summonerDto;
	}
	
	public String tempoDePartida(Long gameDuration) {  
		int segundos = Integer.parseInt(gameDuration+"");
		int horas = segundos / 3600;
		segundos %= 3600;
		int minutos = segundos / 60;
		segundos %= 60;
        
		if(horas != 0) {
        	return horas + "h " + minutos + "min " + segundos + "s";
        }else if(segundos != 0) {
			return  minutos + "min " + segundos + "s";
		}
		
		return  minutos + "min";
	}

}
