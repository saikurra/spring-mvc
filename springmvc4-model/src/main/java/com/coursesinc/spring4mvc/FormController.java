package com.coursesinc.spring4mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	
	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String displayForm() {
		return "formPage";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public ModelAndView submitForm(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("phone") String phone) {
		ModelAndView modelAndView = new ModelAndView("resultPage");
		modelAndView.addObject("userid", id);
		modelAndView.addObject("username", name);
		modelAndView.addObject("userphone", phone);
		return modelAndView;
	}
}
