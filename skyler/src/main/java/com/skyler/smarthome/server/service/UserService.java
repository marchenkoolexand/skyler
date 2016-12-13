package com.skyler.smarthome.server.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.skyler.smarthome.server.constants.UserFields;
import com.skyler.smarthome.server.model.User;

@Service
public class UserService {

	final static Logger logger = Logger.getLogger(UserService.class);
	
	public static User updateUserByField(User user, String userField, String newParam) {

		switch (userField.toLowerCase()) {
		case UserFields.FIRST_NAME:
			user.setFirstName(newParam);
			break;
		case UserFields.LAST_NAME:
			user.setLastName(newParam);
			break;
		case UserFields.EMAIL:
			user.setEmail(newParam);
			break;
		case UserFields.RECOVERY_EMAIL:
			user.setRecoveryEmail(newParam);
			break;
		case UserFields.PHONE_NUMBER:
			user.setPhoneNumber(newParam);
			break;
		}
		return user;
	}
}
