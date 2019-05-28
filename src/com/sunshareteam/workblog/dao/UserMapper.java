package com.sunshareteam.workblog.dao;

import java.util.List;

import com.sunshareteam.workblog.entity.Permission;
import com.sunshareteam.workblog.entity.Role;
import com.sunshareteam.workblog.entity.User;

public interface UserMapper {
	
	public User findAdmin(String adminid);
	
	public List<Permission> findPromission(String adminid);
	
	public List<Role> findRole(String adminid);
	
}
