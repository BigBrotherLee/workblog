package com.sunshareteam.workblog.dao;

import java.util.List;

import com.sunshareteam.workblog.entity.CommentOne;

public interface CommentOneMapper {

	   CommentOne findById(Integer commentone); //根据ID查询
	   List<CommentOne> findAll();
	   List<CommentOne> findByKey(String key);
	   void insertCommentOne(CommentOne commentone);
	   void delete(Integer id);
	   void deleteCommentTwo(Integer commentoneid);
	   List<CommentOne> findByUser(Integer userid); //查用户信息
	   List<CommentOne> findByArticleAll(Integer articleid); //查同文章的评论
	   List<CommentOne> findByUserAll(Integer userid); //查同用户的评论
}
