package com.sunshareteam.workblog.dao;

import com.sunshareteam.workblog.entity.Tag;

public interface TagMapper {
	
   Tag findTagId(int tag); //根据ID查询
   void addTag(Tag tag);
   void updateTag(Tag tag);
   void deleteTag(int id);
   
}
