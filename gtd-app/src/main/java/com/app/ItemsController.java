package com.app;

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
	
	@Autowired
	ItemServiceImpl itemServiceImpl;
	
	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/dashboard";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(Model model) {
		model.addAttribute("items", itemServiceImpl.getAllItems());
		return "dashboard";
	}

	@RequestMapping(value = "/new-item")
	public ModelAndView newItemForm() {
		return new ModelAndView("new-item-form","command", new Item());
	}
	
	@RequestMapping(value = "/new-item", method = RequestMethod.POST)
	public String newItem(@ModelAttribute Item item, Model model) {
		itemServiceImpl.addItem(item);
		model.addAttribute("items", itemServiceImpl.getAllItems());
		return "dashboard";
	}
	
	@RequestMapping(value = "/{id}/edit-item")
	public ModelAndView editItemForm(@PathVariable int id) {
		return new ModelAndView("edit-item-form","command", itemServiceImpl.getItem(Integer.valueOf(id)));
	}
	
	@RequestMapping(value = "/edit-item", method = RequestMethod.POST)
	public String editItem(@ModelAttribute Item item, Model model) {
		itemServiceImpl.updateItem(item);
		model.addAttribute("items", itemServiceImpl.getAllItems());
		return "dashboard";
	}
}
