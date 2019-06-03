package com.sunshareteam.workblog.service;

import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.Article;

public interface ArticleService {
	Article getById(Integer id);
	void updateArticle(Article article);
	void delete(Integer id);
	void insertArticle(Article article);
	PageInfo<Article> getByKey(String key,int start,int size);
	PageInfo<Article> getHot(int start,int size);
	PageInfo<Article> getNew(int start,int size);
	PageInfo<Article> getByCategoty(Integer categotyid,int start,int size);
	PageInfo<Article> getByAuthor(Integer userid,int start,int size);
	PageInfo<Article> getByTag(Integer tagid,int start,int size);
	PageInfo<Article> getByKeyAll(String key,int start,int size);
	PageInfo<Article> getByAuthorAll(Integer userid,int start,int size);
}
