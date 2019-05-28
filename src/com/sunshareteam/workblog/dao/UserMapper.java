package com.sunshareteam.workblog.dao;

import java.util.List;

import com.sunshareteam.workblog.entity.Permission;
import com.sunshareteam.workblog.entity.Role;
import com.sunshareteam.workblog.entity.User;

public interface UserMapper {
	
	User findAdmin(int id);
	
	List<Permission> findPromission(int userId);
	
	List<Role> findRole(int userId);
	
	void addUser(User user); 
	
	void addRole(Role role);
	
	void addPermission(Permission permission);
	
	void addRoleToUser(int userid,int roleid);
	
	void addPermissionToRole(int promissionId,int roleId);
}
