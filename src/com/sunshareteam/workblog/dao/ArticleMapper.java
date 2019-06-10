package com.sunshareteam.workblog.dao;

import java.util.List;

import com.sunshareteam.workblog.entity.Article;
import com.sunshareteam.workblog.web.ArticleVO;

public interface ArticleMapper {
	Article findById(Integer id);
	
	void updateArticle(Article article);
	
	void insertArticle(Article article);
	
	void deleteArticle(Integer id);
	
	void deleteCommentOne(Integer articleid);
	
	void deleteCommentTwo(Integer articleid);
	
	void deleteTag(Integer articleid);
	
	List<ArticleVO> findByKey(String key);
	
	List<ArticleVO> findHot();
	
	List<ArticleVO> findNew();
	
	List<ArticleVO> findByCategoty(Integer categotyid);
	
	List<ArticleVO> findByTag(Integer tagid);
	
	List<ArticleVO> findByAuthor(Integer authorid);
	
	List<ArticleVO> findByKeyAll(String key);
	
	List<ArticleVO> findByAuthorAll(Integer authorid);
}
