package com.sunshareteam.workblog.service;

import java.util.List;

import com.sunshareteam.workblog.entity.CommentTwo;

public interface CommentTwoService {
	CommentTwo getCommentTwoById(Integer id);
	List<CommentTwo> findAll();
	boolean addCommentTwo(CommentTwo commenttwo);
	boolean deleteCommentTwo(int id);
}
