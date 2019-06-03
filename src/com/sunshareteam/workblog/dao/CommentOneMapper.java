package com.sunshareteam.workblog.dao;

import java.util.List;

import com.sunshareteam.workblog.entity.CommentOne;

public interface CommentOneMapper {

	   CommentOne findById(Integer commentone); //根据ID查询
	   List<CommentOne> findAll();
	   void insertCommentOne(CommentOne commentone);
	   void deleteCommentOne(Integer id);
	   void deleteCommentTwo(Integer articleid);
}
