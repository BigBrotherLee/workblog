package com.sunshareteam.workblog.service;

import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.Link;
public interface LinkService {
	Link getById(Integer id);
	PageInfo<Link> getAll(int start,int size);
	PageInfo<Link> getAllPag(int start,int size);
	PageInfo<Link> getByKey(String key,int start,int size);
	void insertLink(Link link);
	void updateLink(Link link);
	void deleteLink(Integer id);
}
