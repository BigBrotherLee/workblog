package com.sunshareteam.workblog.dao;

import java.util.List;

import com.sunshareteam.workblog.entity.Link;

public interface LinkMapper {
	
	   Link findById(Integer link); //根据ID查询
	   List<Link> findAll();
	   List<Link> findByKey(String key);
	   void insertLink(Link link);
	   void updateLink(Link link);
	   void deleteLink(Integer id);
}
