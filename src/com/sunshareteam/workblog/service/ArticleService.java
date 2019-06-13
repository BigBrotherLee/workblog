package com.sunshareteam.workblog.service;

import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.Article;
import com.sunshareteam.workblog.web.ArticleVO;

public interface ArticleService {
	Article getById(Integer id);
	void updateArticle(Article article);
	void delete(Integer id);
	void insertArticle(Article article);
	void addTags(Integer articleid,String[] tags);
	void removeTag(Integer articleid, Integer tagid);
	PageInfo<ArticleVO> getByKey(String key,int start,int size);
	PageInfo<ArticleVO> getHot(int start,int size);
	PageInfo<ArticleVO> getNew(int start,int size);
	PageInfo<ArticleVO> getByCategoty(Integer categotyid,int start,int size);
	PageInfo<ArticleVO> getByAuthor(Integer userid,int start,int size);
	PageInfo<ArticleVO> getByTag(Integer tagid,int start,int size);
	PageInfo<ArticleVO> getByKeyAll(String key,int start,int size);
	PageInfo<ArticleVO> getByAuthorAll(Integer userid,int start,int size);	
}
