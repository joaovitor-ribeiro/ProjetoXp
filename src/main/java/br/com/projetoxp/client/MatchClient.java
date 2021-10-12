package br.com.projetoxp.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MatchClient {
	
	@Value("${fx.apikey}")
    private String key;
    @Value("${fx.url.summoner.match}")
    private String byMatchUrl;
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<String> getMatchByName(String puuid) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(byMatchUrl)
                .path(String.valueOf(puuid))
                .path("/ids")
                .queryParam("start", "0")
                .queryParam("count", "10")
                .queryParam("api_key", key);

        HttpEntity<?> entity = new HttpEntity<>(headers);
        
        HttpEntity<List<String>> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<String>>() {}
        );
        
        return response.getBody();
    }
}
