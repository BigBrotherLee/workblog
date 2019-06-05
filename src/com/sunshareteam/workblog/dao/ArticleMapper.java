package com.sunshareteam.workblog.dao;

import java.util.List;

import com.sunshareteam.workblog.entity.Article;

public interface ArticleMapper {
	Article findById(Integer id);
	
	void updateArticle(Article article);
	
	void insertArticle(Article article);
	
	void deleteArticle(Integer id);
	
	void deleteCommentOne(Integer articleid);
	
	void deleteCommentTwo(Integer articleid);
	
	void deleteTag(Integer articleid);
	
	List<Article> findByKey(String key);
	
	List<Article> findHot();
	
	List<Article> findNew();
	
	List<Article> findByCategoty(Integer categotyid);
	
	List<Article> findByTag(Integer tagid);
	
	List<Article> findByAuthor(Integer authorid);
	
	List<Article> findByKeyAll(String key);
	
	List<Article> findByAuthorAll(Integer authorid);
}
