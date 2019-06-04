package com.workblog.lsy;

import java.util.Date;

import org.apache.commons.lang3.RandomUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bigbrotherlee.utils.LeeConstant;
import com.sunshareteam.workblog.dao.UserMapper;
import com.sunshareteam.workblog.entity.Permission;
import com.sunshareteam.workblog.entity.Role;
import com.sunshareteam.workblog.entity.User;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc.xml",
"classpath:applicationContext-shiro.xml"})
public class TestMapper {
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testMe() {
		System.out.println(LeeConstant.STATE_SUCCESS);
	}
	
	@Test
	public void testUserInsert() {
		User user=new User();
		user.setCreatedate(new Date()); 
		user.setAutograph("你好，世界人");
		user.setEmail("admin@admin.com");
		String salt=Integer.toString(RandomUtils.nextInt(1000, 9999));
		String pwd=new SimpleHash("Md5", "123456",ByteSource.Util.bytes(salt), 2).toString();
		user.setPassword(pwd);
		user.setPhone("1786132477");
		user.setPic("ghasdjhfg");
		user.setUsername("admin");
		user.setSalt(salt);
		userMapper.addUser(user);
	}
	@Test
	public void testfindRole() {
		Role r=userMapper.findRoleByUserId(5).get(0);
		System.out.println(r);
	}
	@Test
	public void testfindPromissionByUserId() {
		Permission p=userMapper.findPromissionByUserId(4).get(0);
		System.out.println(p);
	}
	
	@Test
	public void findUserById() {
		User user=userMapper.findUserById(4);
		System.out.println(user);
	}
	@Test
	public void testaddRole() {
		Role role=new Role();
		role.setCreatedate(new Date());
		role.setRolename("gust");
		role.setRoledetail("游客");
		userMapper.addRole(role);
	}

}
