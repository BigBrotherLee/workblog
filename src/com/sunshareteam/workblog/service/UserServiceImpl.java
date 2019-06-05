package com.sunshareteam.workblog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.dao.UserMapper;
import com.sunshareteam.workblog.entity.Permission;
import com.sunshareteam.workblog.entity.Role;
import com.sunshareteam.workblog.entity.RolePermission;
import com.sunshareteam.workblog.entity.User;
import com.sunshareteam.workblog.entity.UserRole;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserById(Integer id) {
		return userMapper.findUserById(id);
	}

	@Override
	public List<Role> getRoleByUserId(Integer userId) {
		return userMapper.findRoleByUserId(userId);
	}

	@Override
	public List<Permission> getPermissionByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.findPromissionByUserId(userId);
	}

	@Override
	@Transactional
	public void addUser(User user) {
		user.setCreatedate(new Date());
		userMapper.addUser(user);
	}

	@Override
	@Transactional
	public void addRole(Role role) {
		role.setCreatedate(new Date());
		userMapper.addRole(role);
	}

	@Override
	@Transactional
	public void addPermission(Permission permission) {
		permission.setCreatedate(new Date());
		userMapper.addPermission(permission);
	}

	@Override
	@Transactional
	public void addRoleToUser(Integer roleid, Integer userid) {
		UserRole ur= new UserRole();
		ur.setRoleid(roleid);
		ur.setUserid(userid);
		userMapper.addRoleToUser(ur);
	}

	@Override
	@Transactional
	public void addPermissionToRole(Integer permissionid, Integer roleid) {
		RolePermission rp=new RolePermission();
		rp.setPermissionid(permissionid);
		rp.setRoleid(roleid);
		userMapper.addPermissionToRole(rp);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		user.setModifydate(new Date());
		userMapper.updateUser(user);
	}

	@Override
	@Transactional
	public void disableUser(Integer userid) {
		userMapper.deleteUser(userid);
	}

	@Override
	public PageInfo<User> getByKey(String key, int start, int size) {
		PageHelper.startPage(start, size);
		List<User> list=userMapper.findUserByKey("%"+key+"%");
		return new PageInfo<User>(list);
	}

	@Override
	public PageInfo<User> getAdmin(int start, int size,String key) {
		PageHelper.startPage(start, size);
		List<User> list=userMapper.findAdmin("%"+key+"%");
		return new PageInfo<User>(list);
	}

	@Override
	public User getByName(String name) {
		// TODO Auto-generated method stub
		return userMapper.findUserByName(name);
	}

	@Override
	public User getByEmail(String eamil) {
		// TODO Auto-generated method stub
		return userMapper.findUserByEmail(eamil);
	}
	
}
