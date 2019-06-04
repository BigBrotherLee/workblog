package com.sunshareteam.workblog.dao;

import java.util.List;

import com.sunshareteam.workblog.entity.CommentOne;

public interface CommentOneMapper {

	   CommentOne findById(Integer commentone); //根据ID查询
	   List<CommentOne> findAll();
	   List<CommentOne> findByKey(String key);
	   void insertCommentOne(CommentOne commentone);
	   void delete(Integer id);
	   void deleteCommentTwoByCommentOne(Integer comment_one_id);
	   CommentOne getCommentOneByUser(Integer userId);
	   List<CommentOne> findByArticle(Integer articleid);
}
