package com.sunshareteam.workblog.dao;

import com.sunshareteam.workblog.entity.Link;

public interface LinkMapper {
	
	   Link findLinkId(int link); //根据ID查询
	   void addLink(Link link);
	   void updateLink(Link link);
	   void deleteLink(int id);
}
