package com.sunshareteam.workblog.dao;

import java.util.List;

import com.sunshareteam.workblog.entity.Permission;
import com.sunshareteam.workblog.entity.Role;
import com.sunshareteam.workblog.entity.RolePermission;
import com.sunshareteam.workblog.entity.User;
import com.sunshareteam.workblog.entity.UserRole;

public interface UserMapper {
	
	User findUserById(int id);
	
	List<Permission> findPromission(int userId);
	
	List<Role> findRole(int userId);
	
	void addUser(User user); 
	
	void addRole(Role role);
	
	void addPermission(Permission permission);
	
	void addRoleToUser(UserRole ur);
	
	void addPermissionToRole(RolePermission rp);
	
	void updateUser(User user);
	
	void deleteUser(int id);
}
