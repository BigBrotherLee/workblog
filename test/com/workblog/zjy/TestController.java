package com.workblog.zjy;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration({
	"classpath:applicationContext.xml",
	"classpath:springmvc.xml",
	"classpath:applicationContext-shiro.xml"})
@WebAppConfiguration
public class TestController {

}
