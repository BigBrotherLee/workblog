package com.sunshareteam.workblog.service;

import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.CommentTwo;

public interface CommentTwoService {
	CommentTwo getById(Integer id);
	PageInfo<CommentTwo> getAll(int start,int size);
	void insertCommentTwo(CommentTwo commenttwo);
	void deleteCommentTwo(Integer id);
}
