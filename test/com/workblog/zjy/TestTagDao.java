package com.workblog.zjy;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sunshareteam.workblog.dao.CategotyMapper;
import com.sunshareteam.workblog.dao.CommentOneMapper;
import com.sunshareteam.workblog.dao.CommentTwoMapper;
import com.sunshareteam.workblog.dao.LinkMapper;
import com.sunshareteam.workblog.dao.TagMapper;
import com.sunshareteam.workblog.entity.Categoty;
import com.sunshareteam.workblog.entity.CommentOne;
import com.sunshareteam.workblog.entity.CommentTwo;
import com.sunshareteam.workblog.entity.Link;
import com.sunshareteam.workblog.entity.Tag;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc.xml",
		"classpath:applicationContext-shiro.xml"})
public class TestTagDao {
	@Autowired
	private TagMapper tagMapper;
	private CommentOneMapper commentoneMapper;
	private CommentTwoMapper commenttwoMapper;
	private LinkMapper linkmapper;
	
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
	}    */
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
	//测试一级评论
	/*    @Test
 public void test1() {
	CommentOne commentone=new CommentOne();
	commentone.setAuthor(new Integer(10));
	commentone.setArticleid(new Integer(10));
	commentone.setContent("11");
	commentone.setCreatedate(new Date());
	commentone.setCreateuser(new Integer(10));
	commentone.setModifydate(new Date());
	commentone.setModifyuser(new Integer(10));
	commentoneMapper.addCommentOne(commentone);
    }*/
/*		@Test
	public void test2() {
		commentoneMapper.deleteCommentOne(1);
	}*/
	//测试二级评论
	/*	    @Test
	 public void test1() {
		CommentTwo commenttwo=new CommentTwo();
		commenttwo.setAuthor(new Integer(10));
		commenttwo.setContent("11");
		commenttwo.setCreatedate(new Date());
		commenttwo.setCreateuser(new Integer(10));
		commenttwo.setModifydate(new Date());
		commenttwo.setModifyuser(new Integer(10));
		commenttwo.setOneid(1);
		commenttwoMapper.addCommentTwo(commenttwo);
	    }*/
	/*		@Test
		public void test2() {
			commenttwoMapper.deleteCommentTwo(1);
		}*/
//测试友链
/*	  @Test
	  public void test1() {
	    	Link link=new Link();
	    	link.setLinkaddress("");
	    	link.setLinkimg("");
	    	link.setLinktitle("");
	    	link.setModifydate(new Date());
	    	link.setModifyuser(new Integer(10));
	    	linkmapper.addLink(link);
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
}