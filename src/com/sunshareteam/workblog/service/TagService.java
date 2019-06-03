package com.sunshareteam.workblog.service;

import java.util.List;

import com.sunshareteam.workblog.entity.Tag;

public interface TagService {
	Tag getTagById(Integer id);
	List<Tag> findAll();
	boolean addTag(Tag tag);
	boolean updateTag(Tag tag);
	boolean deleteTag(int id);
}
