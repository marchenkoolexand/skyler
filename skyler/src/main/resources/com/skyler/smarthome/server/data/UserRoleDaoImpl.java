package com.skyler.smarthome.server.data;

import com.skyler.smarthome.server.model.UserRole;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UserRoleDaoImpl implements UserRoleDao {

    final static Logger logger = Logger.getLogger(UserRoleDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Set<UserRole> getAllRoles() {
        Session session = sessionFactory.getCurrentSession();
        List<UserRole> userRoles = session.createQuery("from UserRole").list();
        Set<UserRole> userRoleSet = new TreeSet<>();
        userRoleSet.addAll(userRoles);
        return userRoleSet;
    }

    @Override
    public UserRole getRoleById(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserRole userRole = (UserRole) session.get(UserRole.class, id);
        return userRole;
    }
}
