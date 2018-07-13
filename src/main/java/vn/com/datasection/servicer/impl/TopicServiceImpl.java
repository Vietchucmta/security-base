package vn.com.datasection.servicer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.datasection.model.Topic;
import vn.com.datasection.repository.TopicRepository;
import vn.com.datasection.service.TopicService;

@Service("topicServicer")
@Transactional
public class TopicServiceImpl  implements TopicService{
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Override
	public Iterable<Topic> findAll() {
		return topicRepository.findAll();
	}

}
