package com.sunshareteam.workblog.service;

import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.CommentOne;

public interface CommentOneService {
	CommentOne getById(Integer id);
	PageInfo<CommentOne> getAll(int start,int size);
	void insertCommentOne(CommentOne commentone);
	void delete(Integer id);
}
