package com.coursesinc.springmvc4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	
	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView displayForm() {
		return new ModelAndView("formPage","command", new User());
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public ModelAndView submitForm(@ModelAttribute("user") User user) {
		ModelAndView modelAndView = new ModelAndView("resultPage");
		modelAndView.addObject("userid", user.getId());
		modelAndView.addObject("username", user.getName());
		modelAndView.addObject("userphone", user.getPhone());
		return modelAndView;
	}
}
