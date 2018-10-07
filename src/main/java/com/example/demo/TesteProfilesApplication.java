package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Message;
import com.example.demo.domain.MessageRepository;

@RestController
@SpringBootApplication
public class TesteProfilesApplication {

	@Autowired
	private MessageRepository repo;
	
	@Autowired
	private ConfigurableEnvironment env;
	
	public static void main(String[] args) {
		SpringApplication.run(TesteProfilesApplication.class, args);
	}
	
	@GetMapping
	public List<Message> messages(){
		System.out.println("Fetching messages for profile: " + Arrays.asList(env.getActiveProfiles()));
		
		return repo.findByReady();
	}
}
