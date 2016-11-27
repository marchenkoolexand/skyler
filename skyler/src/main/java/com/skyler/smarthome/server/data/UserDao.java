package com.skyler.smarthome.server.data;

import java.util.List;

import com.skyler.smarthome.server.model.User;

public interface UserDao {

	public void createNewUser(User user);

	public List<User> getAllUser();

	public User getUserById(int id);

	public void updateUser(User user);

	public void deleteUserById(int id);

}
