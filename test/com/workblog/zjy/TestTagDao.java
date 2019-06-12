package com.workblog.zjy;

import java.util.Date;
import java.util.List;

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
import com.sunshareteam.workblog.entity.ArticleTag;
import com.sunshareteam.workblog.entity.Categoty;
import com.sunshareteam.workblog.entity.CommentOne;
import com.sunshareteam.workblog.entity.CommentTwo;
import com.sunshareteam.workblog.entity.Link;
import com.sunshareteam.workblog.entity.Tag;
import com.sunshareteam.workblog.web.CommentOneVO;
import com.sunshareteam.workblog.web.CommentTwoVO;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc.xml",
		"classpath:applicationContext-shiro.xml"})
public class TestTagDao {
	@Autowired
	private CommentOneMapper commentoneMapper;
	@Autowired
	private TagMapper tagMapper;
	@Autowired
	private CommentTwoMapper commenttwoMapper;
	@Autowired
	private LinkMapper linkMapper;
 
	@Test
	public void test7() {
	List<CommentTwoVO> list=commenttwoMapper.findByOneAll(3);
	System.out.println(list);
	}
//  测试标签
	 /*  @Test
	public void test1() {
       Tag tag= tagMapper.findById(9);
        System.out.println(tag);  
	} 
	  @Test
	public void test2() {
		List<Tag> list=tagMapper.findAll();
		System.out.println(list);  
	} 
	 @Test
	public void test3() {
		Tag tag=new Tag();
		tag.setTagtitle("小说");
		tag.setCreatedate(new Date());
		tag.setCreateuser(new Integer(10));
		tag.setModifydate(new Date());
        tag.setModifyuser(new Integer(10));
        tagMapper.insertTag(tag);
	}    
	 @Test
	public void test4() {
		ArticleTag articletag=new ArticleTag();
		articletag.setArticleid(1);
		articletag.setTagid(2);
        tagMapper.insertArticleTag(articletag);
        }
	@Test
	 	public void test5() {
		Tag tag=new Tag();
		tag.setTagid(9);
		tag.setTagtitle("2222");
		tagMapper.updateTag(tag);
	}
	@Test
	public void test6() {
	tagMapper.deleteTag(10);
}
	@Test
	public void test7() {
	tagMapper.deleteArticleTag(2);
}
	@Test
	public void test8() {		
	List<Tag> list=tagMapper.findByKey("%小%");
	System.out.println(list);  
}
	@Test
	public void test9() {		
	List<Tag> list=tagMapper.findByArticle(1);
	System.out.println(list);
}*/
	
	
	//测试一级评论
	
/*	 @Test
	public void test1() {
	CommentOne commentone=commentoneMapper.findById(1);
	System.out.println(commentone);  
	} 
    @Test
	public void test2() {
	List<CommentOne> list=commentoneMapper.findAll();
	System.out.println(list);  
	}
	@Test
	public void test3() {
	List<CommentOne> list=commentoneMapper.findByKey("%嘻%");
	System.out.println(list);  
	}
    @Test
    public void test4() {
	CommentOne commentone=new CommentOne();
	commentone.setAuthor(new Integer(10));
	commentone.setArticleid(new Integer(10));
	commentone.setContent("嘻嘻嘻嘻嘻");
	commentone.setCreatedate(new Date());
	commentone.setCreateuser(new Integer(11));
	commentone.setModifydate(new Date());
	commentone.setModifyuser(new Integer(10));
	commentoneMapper.insertCommentOne(commentone);
    }
	@Test
	public void test5() {
	commentoneMapper.delete(2);
	}
	@Test
	public void test6() {
	commentoneMapper.deleteCommentTwo(6);
	}	
	@Test
	public void test7() {
		List<CommentOne> list=commentoneMapper.findByUser(1);
		System.out.println(list);
	}	
	@Test
	public void test8() {
		List<CommentOne> list=commentoneMapper.findByArticleAll(1);
		System.out.println(list);
	}
	@Test
	public void test9() {
		List<CommentOne> list=commentoneMapper.findByUserAll(1);
		System.out.println(list);
	}
	  @Test
		public void test10() {
		List<CommentOneVO> list=commentoneMapper.findByArticleAndUser();
		System.out.println(list);  
		}
	*/
	
	
	//测试二级评论
/*	@Test
	public void test1() {
	CommentTwo commenttwo=commenttwoMapper.findById(2);
	System.out.println(commenttwo);  
	}
    @Test
	public void test2() {
	List<CommentTwo> list=commenttwoMapper.findAll();
	System.out.println(list);  
	}
	@Test
	public void test3() {
	List<CommentTwo> list=commenttwoMapper.findByKey("%1%");
	System.out.println(list);  
	}
	@Test
	public void test4() {
	CommentTwo commenttwo=new CommentTwo();
	commenttwo.setAuthor(new Integer(10));
	commenttwo.setContent("22");
	commenttwo.setCreatedate(new Date());
	commenttwo.setCreateuser(new Integer(10));
	commenttwo.setModifydate(new Date());
	commenttwo.setModifyuser(new Integer(10));
	commenttwo.setOneid(6);
	commenttwoMapper.insertCommentTwo(commenttwo);
	 }	
	@Test
	public void test5() {
	commenttwoMapper.deleteCommentTwo(2);
	}
	@Test
	public void test6() {
	List<CommentTwo> list=commenttwoMapper.findByUser(1);
	System.out.println(list);
	}
	@Test
	public void test7() {
	List<CommentTwo> list=commenttwoMapper.findByOneAll(6);
	System.out.println(list);
	}
		  @Test
			public void test8() {
			List<CommentTwoVO> list=commenttwoMapper.findByCommentOneAndUser();
			System.out.println(list);  
			}
	*/
//测试友链
	/*@Test
	public void test1() {
	Link link=linkMapper.findById(2);
	System.out.println(link);  
	}
	@Test
	public void test2() {
	List<Link> list=linkMapper.findAll();
	System.out.println(list);  
	}
	@Test
	public void test3() {
	List<Link> list=linkMapper.findByKey("%1%");
	System.out.println(list);  
	}
	 @Test
	 public void test4() {
	 Link link=new Link();
	 link.setLinkaddress("11");
	 link.setLinkimg("11");
	 link.setLinktitle("11");
	 link.setModifydate(new Date());
	 link.setModifyuser(new Integer(10));
	 linkMapper.insertLink(link);
	 }
     @Test
     public void test5() {
	 linkMapper.deleteLink(2);
     }
	 @Test
 	 public void test6() {
	 Link link=new Link();
	 link.setLinkid(3);
	 link.setLinkaddress("22");
	 linkMapper.updateLink(link);
     }*/
}