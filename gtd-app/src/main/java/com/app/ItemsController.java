package com.app;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemsController {

	private static final String ACTION_URL = "actionUrl";

	private static final String FORM_TITLE = "formTitle";

	@Autowired
	ItemServiceImpl itemServiceImpl;

	@Autowired
	ServletContext context;

	@ModelAttribute(name="typeList")
	public Map<String, String> typeList(){
		Map<String,String> typeList = new LinkedHashMap<String,String>();
		typeList.put("INBOX", "Inbox");
		typeList.put("WAITING", "Waiting");
		typeList.put("SCHEDULED", "Scheduled");
		typeList.put("SOMEDAY", "Someday");
		return typeList;
	}

	@ModelAttribute(name="timeList")
	public Map<String, String> timeList(){
		Map<String,String> timeList = new LinkedHashMap<String,String>();
		timeList.put("NONE", "");
		timeList.put("30", "30 minutes");
		timeList.put("45", "45 minutes");
		timeList.put("1", "1 hour");
		timeList.put("2", "2 hours");
		timeList.put("3", "3 hours");
		timeList.put("24", "1 day");
		timeList.put("48", "2 days");
		return timeList;
	}
	
	@ModelAttribute(name="energyList")
	public Map<String, String> energyList(){
		Map<String,String> energyList = new LinkedHashMap<String,String>();
		energyList.put("NONE", "");
		energyList.put("HIGH", "High");
		energyList.put("MEDIUM", "Medium");
		energyList.put("LOW", "Low");
		return energyList;
	}
		
	@RequestMapping(value = "/")
	public String home() {
		return "redirect:dashboard";
	}

	@RequestMapping(value = "/dashboard")
	public ModelAndView dashboard(ModelAndView mv) {
		mv.addObject("items", itemServiceImpl.getAllItems());
		mv.addObject(ACTION_URL, context.getContextPath() + "/items/new");
		mv.setViewName("dashboard");
		return mv;
	}

	@RequestMapping(value = "/items/new")
	public ModelAndView newItemForm() {
		ModelAndView mv = new ModelAndView("item-form", "command", new Item());
		mv.addObject(ACTION_URL, context.getContextPath() + "/items/new");
		mv.addObject(FORM_TITLE, "New Action");
		mv.addObject("isEdit", false);
		return mv;
	}

	@RequestMapping(value = "/items/new", method = RequestMethod.POST)
	public String newItem(@ModelAttribute Item item, Model model) {
		itemServiceImpl.addItem(item);
		// model.addAttribute("items", itemServiceImpl.getAllItems());
		return "redirect:/dashboard";
	}

	@RequestMapping(value = "/items/{id}/edit")
	public ModelAndView editItemForm(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("item-form", "command", itemServiceImpl.getItem(Integer.valueOf(id)));
		mv.addObject(ACTION_URL, context.getContextPath() + "/items/" + id + "/edit");
		mv.addObject(FORM_TITLE, "Edit Action");
		mv.addObject("isEdit", true);
		return mv;
	}

	@RequestMapping(value = "/items/{id}/edit", method = RequestMethod.POST)
	public String editItem(@PathVariable String id, @ModelAttribute Item item, Model model) {
		itemServiceImpl.updateItem(item);
		// model.addAttribute("items", itemServiceImpl.getAllItems());
		return "redirect:/dashboard";
	}
	
}
