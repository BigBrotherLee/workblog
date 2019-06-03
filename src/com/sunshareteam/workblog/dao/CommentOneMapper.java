package com.sunshareteam.workblog.dao;

import java.util.List;

import com.sunshareteam.workblog.entity.CommentOne;

public interface CommentOneMapper {

	   CommentOne findCommentOneId(int commentone); //根据ID查询
	   List<CommentOne> fingAll();
	   List<CommentOne> fingPersonalAll();
	   void addCommentOne(CommentOne commentone);
	   void deleteCommentOne(int id);
}
