package com.coursesinc.springmvc4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/string";
	}

	@RequestMapping(value = "/string", method = RequestMethod.GET)
	public @ResponseBody String simple() {
		return "HelloWorld! I am a HTTP response from spring mvc";
	}
	
	@RequestMapping(value = "/object", method = RequestMethod.GET)
	public @ResponseBody User demoObject() {
		return new User("1", "Sai", "2102418457");
	}
	
	@RequestMapping(value = "/object-list", method = RequestMethod.GET)
	public @ResponseBody List<User> demoObjectList() {
		List<User> userList = new ArrayList<User>();
		userList.add(new User("1", "Sai", "2102418457"));
		userList.add(new User("1", "Sai", "2102418457"));
		userList.add(new User("1", "Sai", "2102418457"));
		userList.add(new User("1", "Sai", "2102418457"));

		return userList;
	}

}
