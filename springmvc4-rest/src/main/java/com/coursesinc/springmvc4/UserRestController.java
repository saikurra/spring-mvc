package com.coursesinc.springmvc4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class will show how to create URI for a users resource and do CRUD
 * operations for them.
 * 
 * REST API or URI users/ -GET users/{id} -GET users/ -POST users/{id} -PUT
 * users/{id} -DELETE
 * 
 * @ResponseBody returns HTTP response instead of a view
 * @RestController = @Controller + @ResponseBody
 */
@RestController
public class UserRestController {

	List<User> users;

	int count;

	public UserRestController() {
		users = new ArrayList<User>();
		count = 0;
	}

	/**
	 * This method will return all the user objects that exists
	 * 
	 * @return list of all user objects
	 */
	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	public List<User> getAll() {
		return users;
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User getById(@PathVariable("id") String id) {
		for (User user : users) {
			if (user.getId() == Integer.valueOf(id))
				return user;
		}
		return null;
	}

	@RequestMapping(value = "/users/", method = RequestMethod.POST)
	public User newUser(@RequestBody User user) {
		count++;
		user.setId(count);
		users.add(user);
		return user;
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public void editUser(@PathVariable("id") String id, @ModelAttribute("user") User updatedUser) {
		for (User user : users) {
			if (user.getId() == Integer.valueOf(id))
				user = updatedUser;

		}
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") String id) {
		Iterator<User> userIterator = users.iterator();
		while (userIterator.hasNext())
			if (userIterator.next().getId() == Integer.valueOf(id)) {
				userIterator.remove();
				break;
			}
	}

}
