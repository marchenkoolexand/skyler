package com.skyler.smarthome.server.controller.uicontroller;

import com.skyler.smarthome.server.data.UserDao;
import com.skyler.smarthome.server.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UiUserController {

	final static Logger logger = Logger.getLogger(UiUserController.class);

	@Autowired(required=true)
	UserDao userDao;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> getAllUsers() {
		List<User> users = userDao.getAllUserWithOutSecureInfo();
		if (logger.isDebugEnabled()) {
			logger.debug("/user/ - Return:" + users);
		}
		return users;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public void createUser(@RequestBody User user) {
		if (user != null) {
			boolean result = userDao.createNewUser(user);
		}
	};

	@RequestMapping(value = "/{userid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  User getUserById(@PathVariable int userid) {
		if (userid > 0) {
			User user = userDao.getUserById(userid);
			if (logger.isDebugEnabled()) {
				logger.debug("/user/" + userid +" - Return:" + user);
			}
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
