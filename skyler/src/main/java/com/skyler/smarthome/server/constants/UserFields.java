package com.skyler.smarthome.server.constants;

import com.skyler.smarthome.server.model.Gateway;

/**
 * The <code>UserFields</code> interface contains constants which is equal to
 * User fields, this constants used in UserService class, for updating
 * User properties.
 * 
 * @see Gateway
 * @see GatewayService
 * 
 * @author Oleksandr Marchenko
 * @version %I%, %G%
 */
public interface UserFields {
	
	public static final String FIRST_NAME = "firstname";
	public static final String LAST_NAME = "lastname";
	public static final String EMAIL = "email";
	public static final String RECOVERY_EMAIL = "recoveryemail";
	public static final String PHONE_NUMBER = "phonenumber";
	public static final String PASSWORD = "password" ;
}
