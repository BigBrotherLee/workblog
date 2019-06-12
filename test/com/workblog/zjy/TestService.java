package com.workblog.zjy;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.ArticleTag;
import com.sunshareteam.workblog.entity.CommentOne;
import com.sunshareteam.workblog.entity.CommentTwo;
import com.sunshareteam.workblog.entity.Link;
import com.sunshareteam.workblog.entity.Tag;
import com.sunshareteam.workblog.service.CommentOneService;
import com.sunshareteam.workblog.service.CommentTwoService;
import com.sunshareteam.workblog.service.LinkService;
import com.sunshareteam.workblog.service.TagService;
import com.sunshareteam.workblog.web.CommentOneVO;
import com.sunshareteam.workblog.web.CommentTwoVO;
import com.sunshareteam.workblog.web.TagVO;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc.xml",
"classpath:applicationContext-shiro.xml"})
public class TestService {
	@Autowired
	private TagService tagService;
	@Autowired
	private CommentOneService commentoneService;
	@Autowired
	private CommentTwoService commenttwoService;
	@Autowired
	private LinkService linkService;
	//测试标签
	/*  @Test
	  public void test1() {
	  Tag tag= tagService.getById(11);
	  System.out.println(tag);  
	  }
	  @Test
	  public void test2() {
	  Tag tag=new Tag();
	  tag.setTagtitle("小说");
	  tag.setCreatedate(new Date());
	  tag.setCreateuser(new Integer(10));
	  tag.setModifydate(new Date());
	  tag.setModifyuser(new Integer(10));
	  tagService.insertTag(tag);
	  }    
		@Test
	 	public void test3() {
		Tag tag=new Tag();
		tag.setTagid(11);
		tag.setTagtitle("2222");
		tagService.updateTag(tag);
	}
	   @Test
	   public void test4() {
	   tagService.delete(11);
    }
	 @Test
		public void test5() {
		ArticleTag articletag=new ArticleTag();
		articletag.setArticleid(1);
		articletag.setTagid(2);
	    tagService.insertArticleTag(articletag);
	}
	 @Test
	    public void test6() {
		PageInfo<Tag> list=tagService.getAll(0, 1000);
		System.out.println(list);  
	}
	 @Test
	    public void test7() {		
		PageInfo<Tag> list=tagService.getByKey("%小%",0,1000);
	    System.out.println(list);  
    } 
	 @Test
        public void test8() {		
	    PageInfo<Tag> list=tagService.getByArticle(1, 0, 1000);
        System.out.println(list);  
    }*/
	//测试一评
	/* @Test
	     public void test1() {
	     CommentOne commentone= commentoneService.getById(4);
	     System.out.println(commentone);  
    }
       @Test
	    public void test2() {
		PageInfo<CommentOne> list=commentoneService.getAll(0, 1000);
		System.out.println(list);  
	}
	   @Test
	    public void test3() {		
		PageInfo<CommentOne> list=commentoneService.getByKey("%嘻%",0,1000);
	    System.out.println(list);  
    }     
	   @Test
	    public void test4() {
		CommentOne commentone=new CommentOne();
		commentone.setAuthor(new Integer(10));
		commentone.setArticleid(new Integer(10));
		commentone.setContent("嘻");
		commentone.setCreatedate(new Date());
		commentone.setCreateuser(new Integer(11));
		commentone.setModifydate(new Date());
		commentone.setModifyuser(new Integer(10));
		commentoneService.insertCommentOne(commentone);
	    }
	  @Test
	   public void test5() {
	   commentoneService.delete(6);
    }
	  @Test
	   public void test6() {
	   PageInfo<CommentOne> list=commentoneService.getByUser(1,0,1000);
	   System.out.println(list);
	}	
	@Test
	public void test7() {
		PageInfo<CommentOne> list=commentoneService.getByArticleAll(10,0,1000);
		System.out.println(list);
	}
	@Test
	public void test8() {
		PageInfo<CommentOne> list=commentoneService.getByUserAll(1,0,1000);
		System.out.println(list);
	}
	@Test
    public void test9() {
	PageInfo<CommentOneVO> list=commentoneService.getByArticleAndUser(0, 1000);
	System.out.println(list);  
}*/
	
	//测试二评
	/*@Test
    public void test1() {
    CommentTwo commenttwo= commenttwoService.getById(4);
    System.out.println(commenttwo);  
}
	@Test
    public void test2() {
	PageInfo<CommentTwo> list=commenttwoService.getAll(0, 1000);
	System.out.println(list);  
}
    @Test
    public void test3() {		
	PageInfo<CommentTwo> list=commenttwoService.getByKey("%嘻%",0,1000);
    System.out.println(list);  
}    
	@Test
	public void test4() {
	CommentTwo commenttwo=new CommentTwo();
	commenttwo.setAuthor(new Integer(10));
	commenttwo.setContent("嘻嘻嘻");
	commenttwo.setCreatedate(new Date());
	commenttwo.setCreateuser(new Integer(10));
	commenttwo.setModifydate(new Date());
	commenttwo.setModifyuser(new Integer(10));
	commenttwo.setOneid(6);
	commenttwoService.insertCommentTwo(commenttwo);
	}	
	@Test
	public void test5() {
	commenttwoService.deleteCommentTwo(4);
    }
	@Test
    public void test6() {
	PageInfo<CommentTwo> list=commenttwoService.getByUser(1,0,1000);
	System.out.println(list);
	}
	@Test
	public void test7() {
		PageInfo<CommentTwo> list=commenttwoService.getByOneAll(6,0,1000);
		System.out.println(list);
	}
	@Test
    public void test8() {
	PageInfo<CommentTwoVO> list=commenttwoService.getByCommentOneAndUser(0, 1000);
	System.out.println(list);  
}*/
	
	//测试友链
	/*@Test
    public void test1() {
    Link link= linkService.getById(3);
    System.out.println(link);  
    }	
	@Test
	public void test2() {
    PageInfo<Link> list=linkService.getAll(0, 1000);
	System.out.println(list);  
	}
	@Test
	public void test3() {
    PageInfo<Link> list=linkService.getAllPag(0, 1000);
	System.out.println(list);  
	}
	@Test
	public void test4() {		
    PageInfo<Link> list=linkService.getByKey("%嘻%",0,1000);
	System.out.println(list);  
	}  
	@Test
	public void test5() {
	Link link=new Link();
	link.setLinkaddress("11");
	link.setLinkimg("11");
	link.setLinktitle("嘻嘻嘻");
	link.setModifydate(new Date());
	link.setModifyuser(new Integer(10));
	linkService.insertLink(link);
	}
	@Test
    public void test5() {
	linkService.deleteLink(3);
    }
	@Test
    public void test6() {
	Link link=new Link();
	link.setLinkid(3);
	link.setLinkaddress("33");
	linkService.updateLink(link);
    }*/
}
