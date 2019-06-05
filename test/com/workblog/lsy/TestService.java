package com.workblog.lsy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.Log;
import com.sunshareteam.workblog.service.LogService;
import com.sunshareteam.workblog.service.UserService;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc.xml",
"classpath:applicationContext-shiro.xml"})
public class TestService {
	@Autowired
	private UserService userService;
	@Autowired
	private LogService logService;
	
	@Test
	public void testaddLog() {
		Log log=new Log();
		log.setLogcontent("日志内容=====================");
		logService.addLog(log);
	}
	@Test
	public void testloggetById() {
		Log log=logService.getById(1);
		System.out.println(log);
	}
	@Test
	public void testloggetAll() {
		PageInfo<Log> info=logService.getAll(0, 4);
		System.out.println(info);
	}
//	--------------------------------user---------------------------------
}
