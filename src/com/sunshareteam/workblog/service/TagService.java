package com.sunshareteam.workblog.service;

import com.sunshareteam.workblog.entity.Tag;

public interface TagService {
	Tag getTagById(Integer id);
	boolean addTag(Tag tag);
	boolean updateTag(Tag tag);
	boolean deleteTag(int id);
}
