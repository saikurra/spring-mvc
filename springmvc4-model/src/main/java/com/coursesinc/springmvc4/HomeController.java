package com.coursesinc.springmvc4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String demoModel() {
		return "redirect:/demo";
	}

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public String demoModel(Model model) {
		String message = "Message: I am a message sent by Spring MVC model demo";
		model.addAttribute("message", message);

		List<String> names = new ArrayList<String>();
		names.add("Java");
		names.add("Servlets");
		names.add("Spring MVC");
		model.addAttribute("nameList", names);

		User user = new User("12345", "CoursesInc", "1234567890");
		model.addAttribute("userDetails", user);

		List<User> userList = new ArrayList<User>();
		userList.add(new User("1", "Don", "1111100000"));
		userList.add(new User("2", "John", "9999999999"));
		userList.add(new User("3", "Steve", "1234567890"));
		model.addAttribute("users", userList);

		return "index";
	}

}
