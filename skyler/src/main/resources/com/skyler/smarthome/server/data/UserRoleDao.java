package com.skyler.smarthome.server.data;

import com.skyler.smarthome.server.model.UserRole;

import java.util.Set;

public interface UserRoleDao {

    Set<UserRole> getAllRoles();

    UserRole getRoleById(int id);

}
