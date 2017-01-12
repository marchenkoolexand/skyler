package com.skyler.smarthome.server.data;

import com.skyler.smarthome.server.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

	public boolean createNewUser(User user);

	public List<User> getAllUserWithOutSecureInfo();
	
	public List<User> getAllUser();

	public User getUserById(int id);
	
	public User getUserByIdWithOutSecureInfo(int id);

	public boolean updateUser(int userId, String userField, String newParam);

	public boolean deleteUserById(int id);

	public User getUserByEmail(String username);
}
