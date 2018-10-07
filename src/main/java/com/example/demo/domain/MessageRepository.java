package com.example.demo.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MessageRepository extends JpaRepository<Message, Long>{

	List<Message> findByReady();
	
}
