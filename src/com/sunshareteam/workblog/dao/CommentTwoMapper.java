package com.sunshareteam.workblog.dao;

import java.util.List;
import com.sunshareteam.workblog.entity.CommentTwo;

public interface CommentTwoMapper {

	   CommentTwo findById(Integer commenttwo); //根据ID查询
	   List<CommentTwo> fingAll();
	   List<CommentTwo> findByKey(String key);
	   void insertCommentTwo(CommentTwo commenttwo);
	   void deleteCommentTwo(Integer id);
	   CommentTwo getCommentTwoByUser(Integer userId);
	   List<CommentTwo> findByOneAll(Integer oneid);
}
