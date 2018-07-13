package vn.com.datasection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.datasection.model.Topic;

public interface TopicRepository  extends JpaRepository<Topic, Integer>{
	
}
