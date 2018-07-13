package vn.com.datasection.servicer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.datasection.model.UserTopic;
import vn.com.datasection.repository.UserTopicRepository;
import vn.com.datasection.service.UserTopicService;

@Service("userTopicService")
public class UserTopicServiceImpl implements UserTopicService{

	@Autowired
	private UserTopicRepository userTopicRepository;

	@Override
	public List<UserTopic> findAll() {
		return userTopicRepository.findAll();
	}
	
	
}
