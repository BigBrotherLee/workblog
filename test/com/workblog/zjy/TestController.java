package com.workblog.zjy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ContextConfiguration({
	"classpath:applicationContext.xml",
	"classpath:springmvc.xml",
	"classpath:applicationContext-shiro.xml"})
@WebAppConfiguration
public class TestController {
	 private MockMvc mvc;
	 @Autowired
	 private WebApplicationContext webApplicationContext;;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(webApplicationContext).build();
    }
    
    @Test
    public void test1() throws Exception {
    	MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/comment" );

    	mockHttpServletRequestBuilder.param("itemId", "1" ); //要传入的参数

    	ResultActions resultActions = mvc.perform( mockHttpServletRequestBuilder );
    	
    }

}
