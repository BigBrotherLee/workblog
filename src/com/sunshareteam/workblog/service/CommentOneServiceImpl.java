package com.sunshareteam.workblog.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.dao.CommentOneMapper;
import com.sunshareteam.workblog.entity.CommentOne;

@Service("commentoneService")
public class CommentOneServiceImpl implements CommentOneService{
	@Autowired
	private CommentOneMapper commentoneMapper;

	@Override
	public CommentOne getById(Integer id) {
		return commentoneMapper.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		commentoneMapper.deleteCommentOne(id);
		commentoneMapper.deleteCommentTwo(id);	//删除一级评论下的二级评论
	}

	@Override
	@Transactional
	public void insertCommentOne(CommentOne commentone) {
		commentone.setCreatedate(new Date());
		commentone.setModifydate(new Date());
		commentoneMapper.insertCommentOne(commentone);	
	}
	
	@Override
	public PageInfo<CommentOne> getAll(int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}
}
