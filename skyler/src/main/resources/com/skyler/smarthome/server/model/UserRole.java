package com.skyler.smarthome.server.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "s_user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",unique = true, nullable = false)
    private int roleId;
    @Column(name = "s_role", length = 45)
    private String role;

    public UserRole() {
    }
    public UserRole( String role) {

        this.role = role;
    }
    public Integer getUserRoleId() {
        return this.roleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.roleId = userRoleId;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        if (roleId != userRole.roleId) return false;
        return role != null ? role.equals(userRole.role) : userRole.role == null;

    }
    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "roleId=" + roleId +
                ", role='" + role + '\'' +
                '}';
    }
}
