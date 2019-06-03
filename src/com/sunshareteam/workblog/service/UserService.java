package com.sunshareteam.workblog.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.Permission;
import com.sunshareteam.workblog.entity.Role;
import com.sunshareteam.workblog.entity.User;

public interface UserService {
	User getUserById(Integer id);
	List<Role> getRoleByUserId(Integer userId);
	List<Permission> getPermissionByUserId(Integer userId);
	void addUser(User user);
	void addRole(Role role);
	void addPermission(Permission permission);
	void addRoleToUser(Integer roleid,Integer userid);
	void addPermissionToRole(Integer permissionid,Integer roleid);
	void updateUser(User user);
	void disableUser(Integer userid);
	PageInfo<User> getByKey(String key,int start,int size);
	PageInfo<User> getAdmin(int start,int size,String key);
	User getByName(String name);
	User getByEmail(String eamil);
}
