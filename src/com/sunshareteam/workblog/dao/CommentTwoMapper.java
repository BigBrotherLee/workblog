package com.sunshareteam.workblog.dao;

import java.util.List;
import com.sunshareteam.workblog.entity.CommentTwo;
import com.sunshareteam.workblog.web.CommentTwoVO;

public interface CommentTwoMapper {

	   CommentTwo findById(Integer commenttwo); //根据ID查询
	   List<CommentTwoVO> findByCommentOneAndUser(Integer userid); //查一二评用户名和内容
	   List<CommentTwo> findAll();
	   List<CommentTwo> findByKey(String key);
	   void insertCommentTwo(CommentTwo commenttwo);
	   void deleteCommentTwo(Integer id);
	   List<CommentTwo> findByUser(Integer id);
	   List<CommentTwo> findByOneAll(Integer oneid);
}
