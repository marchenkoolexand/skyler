package com.skyler.smarthome.server.controller.uicontroller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyler.smarthome.server.data.UserDao;
import com.skyler.smarthome.server.model.User;

@Controller
@RequestMapping("/user")
public class UIUserController {

	final static Logger logger = Logger.getLogger(UIUserController.class);

	@Autowired(required=true)
	UserDao userDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<User> getAllUsers() {
		List<User> users = userDao.getAllUserWithOutSecureInfo();
		return users;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public void createUser(@RequestBody User user) {
		if (user != null) {
			boolean result = userDao.createNewUser(user);
		}
	};

	@RequestMapping(value = "/{userid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody User getUserById(@PathVariable int userid) {
		if (userid > 0) {
			User user = userDao.getUserById(userid);
			return user;
		} else {
			return null;
		}
	};

	@RequestMapping(value = "/update/{userid}", method = RequestMethod.POST)
	public void updateUser(@PathVariable int userid, @RequestParam String userField, @RequestParam String newParam) {
		if (userid > 0 && userField != null && newParam != null) {
			boolean result = userDao.updateUser(userid, userField, newParam);
		}
	};

	@RequestMapping(value = "/delete/{userid}", method = RequestMethod.POST)
	public void deleteUserById(@PathVariable int userid) {
		if (userid > 0) {
			boolean result = userDao.deleteUserById(userid);
		}
	};

}
