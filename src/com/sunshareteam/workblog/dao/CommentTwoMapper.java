package com.sunshareteam.workblog.dao;

import java.util.List;
import com.sunshareteam.workblog.entity.CommentTwo;

public interface CommentTwoMapper {

	   CommentTwo findById(Integer commenttwo); //根据ID查询
	   List<CommentTwo> findAll();
	   List<CommentTwo> findByKey(String key);
	   void insertCommentTwo(CommentTwo commenttwo);
	   void deleteCommentTwo(Integer id);
	   List<CommentTwo> findByUser(Integer userid);
	   List<CommentTwo> findByOneAll(Integer oneid);
}
