package br.com.brandao.helloworld.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {
	
	@Autowired 
	private RestTemplate restTemplate;
	
	@GetMapping
	public String getHelloWorldMessage(@RequestParam("name") String name) {
		
		String welcomeTerm = restTemplate.getForObject("http://microservice-welcome/welcome", String.class); //String welcomeTerm = restTemplate.getForObject("http://localhost:8280/welcome", String.class);
		
		StringBuilder sb = new StringBuilder();
		sb.append("\"microservice-helloworld\" recebeu o nome ");
		sb.append("\"" + name + "\"");
		sb.append(", chamou  \"microservice-welcome\" para recuperar termo de boas vindas ");
		sb.append("\"" + welcomeTerm + "\"");
		sb.append(" e retornou para o cliente a mensagem \"");
		sb.append(welcomeTerm);
		sb.append(" ");
		sb.append(name);
		sb.append(", ");
		sb.append("boas vindas do microservice-helloworld\"");
		
		return sb.toString();
	}
}
