package br.com.brandao.helloworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AutowiredBeans {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
