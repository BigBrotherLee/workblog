package com.sunshareteam.workblog.service;

import java.util.List;
import com.sunshareteam.workblog.entity.Permission;
import com.sunshareteam.workblog.entity.Role;
import com.sunshareteam.workblog.entity.User;

public interface UserService {
	User getUserById(Integer id);
	List<Role> getRoleByUserId(Integer userId);
	List<Permission> getPermissionByUserId(Integer userId);
}
