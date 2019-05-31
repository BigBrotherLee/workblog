package com.sunshareteam.workblog.dao;

import java.util.List;

import com.sunshareteam.workblog.entity.Tag;

public interface TagMapper {
	
   Tag findTagId(int id); //根据ID查询
   List<Tag> fingAll();
   void addTag(Tag tag);
   void updateTag(Tag tag);
   void deleteTag(int id);
   
}
