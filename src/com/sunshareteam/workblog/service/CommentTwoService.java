package com.sunshareteam.workblog.service;

import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.CommentTwo;
import com.sunshareteam.workblog.web.CommentTwoVO;

public interface CommentTwoService {
	CommentTwo getById(Integer id);
	PageInfo<CommentTwoVO> getByCommentOneAndUser(Integer userid,int start,int size);
	PageInfo<CommentTwo> getAll(int start,int size);
	PageInfo<CommentTwo> getByKey(String key,int start,int size);
	void insertCommentTwo(CommentTwo commenttwo);
	void deleteCommentTwo(Integer id);
	PageInfo<CommentTwo> getByUser(Integer id,int start,int size);
	PageInfo<CommentTwoVO> getByOneAll(Integer oneid,int start, int size);
}
