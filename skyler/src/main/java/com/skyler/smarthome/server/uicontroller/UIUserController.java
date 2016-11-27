package com.skyler.smarthome.server.uicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skyler.smarthome.server.data.UserDao;
import com.skyler.smarthome.server.model.User;

@Controller
@RequestMapping("/user")
public class UIUserController {

	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")

	public List<User> getAllUsers() {

		List<User> users = userDao.getAllUser();

		return users;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public void createUser(User user) {

		userDao.createNewUser(user);

	};

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public User getUserById(@PathVariable int id) {

		User user = userDao.getUserById(id);

		return user;

	};

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateUser(User user) {
		
		userDao.updateUser(user);

	};

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public void deleteUserById(@PathVariable int id) {
		
		userDao.deleteUserById(id);

	};

}
