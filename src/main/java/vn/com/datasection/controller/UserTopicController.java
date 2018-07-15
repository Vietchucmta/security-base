package vn.com.datasection.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.datasection.model.UserTopic;
import vn.com.datasection.service.TopicService;
import vn.com.datasection.service.UserService;
import vn.com.datasection.service.UserTopicService;

@Controller
public class UserTopicController {

	@Autowired
	private UserTopicService userTopicService;

	@Autowired
	private UserService userService;

	@Autowired
	private TopicService topicService;
	
	@GetMapping(value = "/user-topic", produces = "application/json")
	@ResponseBody
	public int getListUserTopic() {
		return userTopicService.findAll().size();
	}

	@GetMapping(value = "/user-topic/create")
	public String viewCreateUserTopic(Model model) {
		model.addAttribute("usertopic", new UserTopic());
		return "create-user-topic";
	}

	@PostMapping(value = "/user-topic/save")
	public String saveCreateUserTopic(@Valid UserTopic usertopic) {
		UserTopic userTopic= new UserTopic();
		try {
			userTopic.setPermission(true);
			userTopic.setUser(userService.findUserById(usertopic.getUser().getId()));
			userTopic.setTopic(topicService.findTopicById(usertopic.getTopic().getId()));
			userTopicService.save(userTopic);
			return "redirect:/home";
		} catch (Exception e) {
			return "create-user-topic";
		}
	}
}
