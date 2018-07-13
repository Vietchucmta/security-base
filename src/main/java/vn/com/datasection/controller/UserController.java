package vn.com.datasection.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.datasection.model.User;
import vn.com.datasection.service.UserService;

@Controller
@RequestMapping(value = "/account")
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@GetMapping(value = "/create")
	public String create(Model model) {
		model.addAttribute("user", new User());
		return "form";
	}

	@PostMapping(value = "/save")
	public String save(@Valid User user, BindingResult result, RedirectAttributes redirect) {
		try {
			// if(result.hasErrors()) {
			// return "form";
			// }
			Date date = new Date();
			User userSave = new User();
			userSave.setName(user.getName());
			userSave.setEmail(user.getEmail());
			userSave.setPassword(user.getPassword());
			userSave.setPhone(user.getPhone());
			userSave.setBrithday(user.getBrithday());
			userSave.setAddress(user.getAddress());

			userSave.setExpireTime(date);

			userSave.setEnable(true);
			userService.save(userSave);

			// redirect.addFlashAttribute("sucess", "Saved employee successfully!");
			return "redirect:/login";
		} catch (RuntimeException e) {
			System.out.println(e);
			return "form";
		}
	}
}
