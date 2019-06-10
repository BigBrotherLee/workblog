package com.sunshareteam.workblog.service;

import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.CommentOne;
import com.sunshareteam.workblog.web.CommentOneVO;

public interface CommentOneService {
	CommentOne getById(Integer id);
	PageInfo<CommentOneVO> getByArticleAndUser(int start,int size);
	PageInfo<CommentOne> getAll(int start,int size);
	PageInfo<CommentOne> getByKey(String key,int start,int size);
	void insertCommentOne(CommentOne commentone);
	void delete(Integer id);
	PageInfo<CommentOne> getByUser(Integer userid, int start, int size);
	PageInfo<CommentOne> getByArticleAll(Integer articleid,int start,int size);
	PageInfo<CommentOne> getByUserAll(Integer userid, int start, int size);
}
