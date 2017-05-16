package com.coursesinc.springmvc4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class will show how to create URI for a users resource and do CRUD operations for them. 
 * 
 * users/		-GET
 * users/{id}	-GET
 * users/		-POST
 * users/{id}	-PUT
 * users/{id}	-DELETE
 */
@RestController
public class UsersController {

	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	public List<User> getAll() {
		return new ArrayList<User>();
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User getById(@RequestParam("id") String id) {
		return new User();
	}

	@RequestMapping(value = "/users/", method = RequestMethod.POST)
	public void newUser(@ModelAttribute("user") User user) {
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public void editUser(@ModelAttribute("user") User user) {

	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public void deleteUser() {
	}

}
