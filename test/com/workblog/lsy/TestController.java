package com.workblog.lsy;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ContextConfiguration({
	"classpath:applicationContext.xml",
	"classpath:springmvc.xml",
	"classpath:applicationContext-shiro.xml"})
@WebAppConfiguration
public class TestController {
	@Autowired
	private WebApplicationContext webApplicationContext; 
	private MockMvc mockMvc;
	public void setWebApplicationContext(WebApplicationContext webApplicationContext) {
		this.webApplicationContext = webApplicationContext;
	}
	@Before
	public void init() {
		mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
}
