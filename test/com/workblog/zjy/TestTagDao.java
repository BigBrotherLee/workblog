package com.workblog.zjy;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sunshareteam.workblog.dao.CategotyMapper;
import com.sunshareteam.workblog.dao.LinkMapper;
import com.sunshareteam.workblog.dao.TagMapper;
import com.sunshareteam.workblog.entity.Categoty;
import com.sunshareteam.workblog.entity.Link;
import com.sunshareteam.workblog.entity.Tag;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc.xml",
		"classpath:applicationContext-shiro.xml","classpath:shiro-ehcache.xml"})
public class TestTagDao {
	@Autowired
	private TagMapper tagMapper;
	
//   测试标签
 /*  @Test
	public void test1() {
		Tag tag=new Tag();
		tag.setTagtitle("1111");
		tag.setCreatedate(new Date());
		tag.setCreateuser(new Integer(10));
		tag.setModifydate(new Date());
        tag.setModifyuser(new Integer(10));
		tagMapper.addTag(tag);
	}*/
//	@Test
//	public void test2() {
//		tagMapper.deleteTag(6);
//	}
/*		@Test
	 	public void test3() {
		Tag tag=new Tag();
		tag.setTagid(6);
		tag.setTagtitle("2222");
		tagMapper.updateTag(tag);
	}*/
	//测试友链
/*    @Test
public void test1() {
	Link link=new Link();
    link.setLinktitle("11");
    link.setLinkimg("11");
    link.setLinkaddress("11");
    link.setModifydate(new Date());
    link.setModifyuser(new Integer(10));
    linkMapper.addLink(link);
    }*/
/*@Test
public void test2() {
	linkMapper.deleteLink(1);
}*/
/*		@Test
 	public void test3() {
	Link link=new Link();
	link.setLinkid(1);
	link.setLinkaddress("22");
	linkMapper.updateLink(link);
}*/
	//测试分类
	/*	    @Test
	  public void test1() {
	    	Categoty categoty=new Categoty();
	    	categoty.setCategotydetail("11");
	    	categoty.setCategotytitle("11");
	    	categoty.setCreatedate(new Date());
	    	categoty.setImg("11");
	    	categoty.setModifydate(new Date());
	    	categoty.setModifyuser(new Integer(10));
	    	categotyMapper.addCategoty(categoty);
	    }*/
	/*	@Test
	public void test2() {
		categotyMapper.deleteCategoty(1);
	}*/
	/*			@Test
	 	public void test3() {
		Categoty categoty=new Categoty();
		categoty.setCategotyid(1);
		categoty.setImg("22");
		categotyMapper.updateCategoty(categoty);
		
	}*/
}