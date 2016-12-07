package com.skyler.smarthome.server.data;

import java.util.List;

import com.skyler.smarthome.server.model.User;

public interface UserDao {

	public boolean createNewUser(User user);

	public List<User> getAllUserWithOutPassword();
	
	public List<User> getAllUser();

	public User getUserById(int id);
	
	public User getUserByIdWithOutPassword(int id);

	public boolean updateUser(int userId, String userField, String newParam);

	public boolean deleteUserById(int id);

}
