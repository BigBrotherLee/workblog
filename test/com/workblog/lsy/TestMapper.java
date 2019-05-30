package com.workblog.lsy;

import java.util.Date;

import org.apache.commons.lang3.RandomUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bigbrotherlee.utils.LeeConstant;
import com.sunshareteam.workblog.dao.UserMapper;
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
		user.setEmail("123@qq.com");
		String salt=new String(RandomUtils.nextBytes(16));
		String pwd=new SimpleHash("Md5", "123456",salt, 2).toBase64();
		user.setPassword(pwd);
		user.setPhone("1786132477");
		user.setPic("ghasdjhfg");
		user.setUsername("name");
		user.setSalt(salt);
		userMapper.addUser(user);
	}

}
