package com.sunshareteam.workblog.dao;

import com.sunshareteam.workblog.entity.CommentOne;

public interface CommentOneMapper {

	   CommentOne findCommentOneId(int commentone); //根据ID查询
	   void addCommentOne(CommentOne commentone);
	   void deleteCommentOne(int id);
}
