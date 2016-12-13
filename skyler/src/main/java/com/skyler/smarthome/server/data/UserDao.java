package com.skyler.smarthome.server.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyler.smarthome.server.model.User;

@Repository
public interface UserDao {

	public boolean createNewUser(User user);

	public List<User> getAllUserWithOutSecureInfo();
	
	public List<User> getAllUser();

	public User getUserById(int id);
	
	public User getUserByIdWithOutSecureInfo(int id);

	public boolean updateUser(int userId, String userField, String newParam);

	public boolean deleteUserById(int id);

}
