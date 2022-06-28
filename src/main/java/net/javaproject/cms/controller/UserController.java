package net.javaproject.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaproject.cms.entity.Users;
import net.javaproject.cms.service.UserService;

@Controller
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/login")
	public String login(Model model) {
		Users users = new Users();
		model.addAttribute("user", users);
		return "users";
	}

	@PostMapping("/user/verify")
	public String verifyUser(Model model, Users users) {
		String email = users.getEmail();
		String password = users.getPassword();
		System.out.println(email + " ------ " + password);
		model.addAttribute("user", userService.verifyLogin(email, password));
		if (userService.verifyLogin(email, password) != null
				&& userService.verifyLogin(email, password).getEmail().length() > 0) {
			return "redirect:/appointments";
		} else {
			return "redirect:/invalid-login";
		}
		// System.out.println(userService.verifyLogin(email,
		// password).getEmail().length() > 0);
	}

	@GetMapping("/invalid-login")
	public String invalidLogin(Model model) {
		return "loginUnsuccessful";
	}

	@GetMapping("/logout")
	public String logout(Model model) {
		Users users = new Users();
		model.addAttribute("user", users);
		return "redirect:/login";
	}
}
