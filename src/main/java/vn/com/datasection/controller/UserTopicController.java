package vn.com.datasection.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.datasection.service.UserTopicService;

@Controller
public class UserTopicController {
	
	@Autowired
	private UserTopicService userTopicService;
	
	@GetMapping(value="/usertopic", produces="application/json")
	@ResponseBody
	public int getListUserTopic(){
		return userTopicService.findAll().size();
	}
}

