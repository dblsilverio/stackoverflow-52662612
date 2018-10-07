package com.example.demo.domain;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mysql")
public interface MessageMySQLRepository extends MessageRepository {

	@Query(value = "select m.* from Message m where m.ready = true", nativeQuery = true)
	List<Message> findByReady();

}
