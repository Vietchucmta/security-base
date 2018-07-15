package vn.com.datasection.service;

import java.util.List;

import vn.com.datasection.model.UserTopic;

public interface UserTopicService {
	
	public List<UserTopic> findAll();
	
	public void save(UserTopic userTopic);
	
}
