package com.sunshareteam.workblog.service;

import java.util.List;
import com.sunshareteam.workblog.entity.Link;
public interface LinkService {
	Link getLinkById(Integer id);
	List<Link> findAll();
	boolean addLink(Link link);
	boolean updateLink(Link link);
	boolean deleteLink(int id);
}
