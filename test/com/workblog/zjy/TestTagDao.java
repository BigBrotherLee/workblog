package com.workblog.zjy;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.sunshareteam.workblog.dao.TagMapper;
import com.sunshareteam.workblog.entity.Tag;

@RunWith(SpringRunner.class)
public class TestTagDao {
	@Autowired
	private TagMapper tagMapper;
	
	@Test
	public void test1() {
		Tag tag=new Tag();
		tag.setTagtitle("1111");
		tag.setCreatedate(new Date());
		tag.setCreateuser(new Integer(1));
		tag.setModifydate(new Date());
        tag.setModifyuser(new Integer(1));
		tagMapper.addTag(tag);
	}
}
