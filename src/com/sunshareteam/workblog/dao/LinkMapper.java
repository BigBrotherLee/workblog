package com.sunshareteam.workblog.dao;

import java.util.List;

import com.sunshareteam.workblog.entity.Link;

public interface LinkMapper {
	
	   Link findLinkId(int link); //根据ID查询
	   List<Link> fingAll();
	   void addLink(Link link);
	   void updateLink(Link link);
	   void deleteLink(int id);
}
