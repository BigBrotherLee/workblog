package com.sunshareteam.workblog.dao;

import java.util.List;
import com.sunshareteam.workblog.entity.CommentTwo;

public interface CommentTwoMapper {

	   CommentTwo findCommentTwoId(int commenttwo); //根据ID查询
	   List<CommentTwo> fingAll();
	   void addCommentTwo(CommentTwo commenttwo);
	   void deleteCommentTwo(int id);
	   
}
