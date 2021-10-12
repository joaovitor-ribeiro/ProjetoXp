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
import br.com.projetoxp.model.Participants;
import br.com.projetoxp.model.dto.MatchDto;

@Service
public class MatchInformationClient {

	@Value("${fx.apikey}")
    private String key;
    @Value("${fx.url.summoner.match.id}")
    private String byMatchInformationUrl;
    @Value("${fx.url.match.item}")
    private String itemUrl;
    @Value("${fx.url.summoner.profile}")
    private String profileUrl;
    @Value("${fx.url.summoner.champion}")
    private String chamiponUrl;
    
	@Autowired
	RestTemplate restTemplate;
	
	public Match getMatchInformation(String matchs) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(byMatchInformationUrl)
				.path(String.valueOf(matchs))
				.queryParam("api_key", key);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<Match> response = restTemplate.exchange(
				builder.toUriString(),
				HttpMethod.GET,
				entity,
				Match.class
				);
		return response.getBody();
	}
	
	public void litaMatchInformation(List<Match> matchInfo, List<String> matchs) {
		for (int i = 0; i < matchs.size(); i++) {
	        matchInfo.add(getMatchInformation(matchs.get(i)));
		}
    }
	
	public List<MatchDto> listaMatchDto(String name, Match match) {
		List<MatchDto> matchDto = new ArrayList<MatchDto>();
		
		for (int i = 0; i < match.getinfo().getParticipants().size(); i++) {
			
			String       urlChampion   = championUrl(match.getinfo().getParticipants().get(i));
			List<String> urlItem       = listaUrlItem(match, i);
			String       gameDuration  = achandoTempoDePartida(match.getinfo().getGameDuration());
			String       venceu        = venceu(name, match);
			
			matchDto.add(new MatchDto(match, i, urlChampion, gameDuration, urlItem, venceu));
		}
		return matchDto;
	}
	
	private String championUrl(Participants participants) {
		if(!participants.getChampionName().equals("FiddleSticks")) {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(chamiponUrl)
	                .path(String.valueOf(participants.getChampionName()) + ".png");
			return builder.toUriString();
		}
		return "../../assets/Fiddlesticks.png";
	}
	
	public List<String> listaUrlItem(Match match, int i) {
		List<String> listaItem = new ArrayList<String>();
		
		listaItem.add(urlItem(match.getinfo().getParticipants().get(i).getItem0()));
		listaItem.add(urlItem(match.getinfo().getParticipants().get(i).getItem1()));
		listaItem.add(urlItem(match.getinfo().getParticipants().get(i).getItem2()));
		listaItem.add(urlItem(match.getinfo().getParticipants().get(i).getItem3()));
		listaItem.add(urlItem(match.getinfo().getParticipants().get(i).getItem4()));
		listaItem.add(urlItem(match.getinfo().getParticipants().get(i).getItem5()));
		listaItem.add(urlItem(match.getinfo().getParticipants().get(i).getItem6()));
		
		return listaItem;	
	}
	
	public String urlItem(Long item) {
		if(item != 0) {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(itemUrl)
	                .path(String.valueOf(item) + ".png");
			return builder.toUriString();
		}else {
			return "0";
		}
	}
	
	public String achandoTempoDePartida(Long gameDuration) {
		int horas 			  = (int) (gameDuration / 3600000);
        int minutos           = (int) (gameDuration - (horas * 3600)) / 60000;
        float segundos        = (float) (gameDuration - (minutos * 3600)) / 60;
        String segundosString = segundos + "";
        
        segundosString = segundosString.substring(0,2);
        
        if(horas != 0) {
        	return horas + "h " + minutos + "min " + segundosString + "s";
        }
        
        return  minutos + "min " + segundosString + "s";
	}
	
	private String venceu(String name, Match match) {
		for (int i = 0; i < match.getinfo().getParticipants().size(); i++) {
			if(match.getinfo().getParticipants().get(i).getSummonerName().toLowerCase().replace(" ", "").equals(name)) {
				if(match.getinfo().getParticipants().get(i).isWin()) {
					return  "Vitória";
				}
				return "Derrota";
			}
		}
		return "";
	}
	
	public List<MatchDto> ordenando(List<MatchDto> matchDto){
		
		for (int i = 0; i < matchDto.size()-1; i++) {
			for (int j = i+1; j < matchDto.size(); j++) {
				if(matchDto.get(i).isWin()) {
					break;
				}else if(matchDto.get(j).isWin()){
					ordena(matchDto, i, j);
					break;
				}
			}
		}
		
		for (int i = 0; i < matchDto.size()-1; i++) {
			for (int j = i+1; j < matchDto.size(); j++) {
				if(matchDto.get(i).isWin() == matchDto.get(j).isWin()) {
					String kill1  = matchDto.get(i).getKills() + "";
					String death1 = matchDto.get(i).getDeath() + "";
					String kill2  = matchDto.get(j).getKills() + "";
					String death2 = matchDto.get(j).getDeath() + "";
					
					double kd1 = Double.parseDouble(kill1) / Double.parseDouble(death1);
					double kd2 = Double.parseDouble(kill2) / Double.parseDouble(death2);
					
					if(kd1 < kd2) {
						ordena(matchDto, i, j);
					}
				}
			}
		}
		return matchDto;
	}
	
	public void ordena(List<MatchDto> matchDto, int i, int j) {
		List<MatchDto> matchDtoAux = new ArrayList<>();
		matchDtoAux.add(matchDto.get(i));
		matchDto.set(i, matchDto.get(j));
		matchDto.set(j, matchDtoAux.get(0));
		matchDtoAux.clear();
	}
	
}
