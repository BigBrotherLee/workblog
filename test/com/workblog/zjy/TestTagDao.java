package com.workblog.zjy;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sunshareteam.workblog.dao.TagMapper;
import com.sunshareteam.workblog.entity.Tag;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc.xml",
		"classpath:applicationContext-shiro.xml","classpath:shiro-ehcache.xml"})
public class TestTagDao {
	@Autowired
	private TagMapper tagMapper;
	
	@Test
	public void test1() {
		Tag tag=new Tag();
		tag.setTagtitle("1111");
		tag.setCreatedate(new Date());
		tag.setCreateuser(new Integer(10));
		tag.setModifydate(new Date());
        tag.setModifyuser(new Integer(10));
		tagMapper.addTag(tag);
	}
}
