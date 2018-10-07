package com.example.demo.config;

import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Message;
import com.example.demo.domain.MessageRepository;

@Component
public class Boot implements ApplicationContextAware {

	@Autowired
	private MessageRepository repo;
	
	@Override
	@Transactional
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("Inserting data...");
		
		IntStream.range(1, 11).forEach(i -> {
			System.out.println("Inserting row #1");
			Message message = new Message("User " + i, i % 2 == 0);
			repo.save(message);
			System.out.println(message);
		});
		
		System.out.println("Done.");
	}

}
