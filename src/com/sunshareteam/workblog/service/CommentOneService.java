package com.sunshareteam.workblog.service;

import java.util.List;
import com.sunshareteam.workblog.entity.CommentOne;

public interface CommentOneService {
	CommentOne getCommentOneById(Integer id);
	List<CommentOne> findAll();
	boolean addCommentOne(CommentOne commentone);
	boolean deleteCommentOne(int id);
}
