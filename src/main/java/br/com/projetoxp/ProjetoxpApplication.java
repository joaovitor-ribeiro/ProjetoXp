package br.com.projetoxp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ProjetoxpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoxpApplication.class, args);
	}
	
	@Bean
	public PasswordEncoder getPassWordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		return encoder;
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
