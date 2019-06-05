package com.sunshareteam.workblog.service;

import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.ArticleTag;
import com.sunshareteam.workblog.entity.Tag;

public interface TagService {
	Tag getById(Integer id);
	void insertTag(Tag tag);
	void updateTag(Tag tag);
	void delete(Integer id);
	void insertArticleTag(ArticleTag articletag);
	PageInfo<Tag> getAll(int start,int size);
	PageInfo<Tag> getByKey(String key,int start,int size);
	PageInfo<Tag> getByArticle(Integer articleid,int start,int size);
}
