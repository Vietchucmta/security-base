package vn.com.datasection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.com.datasection.service.TopicService;

@Controller
public class HomeController {

	@Autowired
	private TopicService topicService;

	@GetMapping(value = { "/", "/home" })
	@Qualifier("topicService")
	public String index(Model model) {
		model.addAttribute("topics", topicService.findAll());
		return "index";
	}
	
	@GetMapping(value="/login")
	public String login() {
		return "login";
	}
}
