package com.sunshareteam.workblog.dao;

import java.util.List;

import com.sunshareteam.workblog.entity.ArticleTag;
import com.sunshareteam.workblog.entity.Tag;

public interface TagMapper {
	
   Tag findById(Integer id); //根据ID查询
   List<Tag> findAll();
   void insertTag(Tag tag);
   void insertArticleTag(ArticleTag articletag);
   void updateTag(Tag tag);
   void deleteTag(Integer id);
   void deleteArticleTag(Integer tagid);  
   List<Tag> findByKey(String key);//关键字查询
   List<Tag> fingTagByArticle(Integer articleId);
   
}
