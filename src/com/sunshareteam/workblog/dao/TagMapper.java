package com.sunshareteam.workblog.dao;

import java.util.List;

import com.sunshareteam.workblog.entity.Tag;

public interface TagMapper {
	
   Tag findById(Integer id); //根据ID查询
   List<Tag> findAll();
   void insertTag(Tag tag);
   void insertArticleTag(Integer articleid,Integer tagid);
   void updateTag(Tag tag);
   void deleteTag(Integer id);
   List<Tag> findByKey(String key);//关键字查询
   Tag getTagByArticle(Integer articleId);
   
}
