package com.sunshareteam.workblog.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.dao.CommentTwoMapper;
import com.sunshareteam.workblog.entity.CommentTwo;
import com.sunshareteam.workblog.web.CommentTwoVO;

@Service("commenttwoService")
public class CommentTwoServiceImpl implements CommentTwoService {
	@Autowired
	private CommentTwoMapper commenttwoMapper;

	@Override
	public CommentTwo getById(Integer id) {
		// TODO Auto-generated method stub
		return commenttwoMapper.findById(id);
	}
	
	@Override
	public PageInfo<CommentTwoVO> getByCommentOneAndUser(int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentTwoVO> list=commenttwoMapper.findByCommentOneAndUser();
		return new PageInfo<CommentTwoVO>(list);
	}
	
	@Override
	@Transactional
	public void deleteCommentTwo(Integer id) {
		commenttwoMapper.deleteCommentTwo(id);	
	}

	@Override
	@Transactional
	public void insertCommentTwo(CommentTwo commenttwo) {
		// TODO Auto-generated method stub
		commenttwo.setCreatedate(new Date());
		commenttwoMapper.insertCommentTwo(commenttwo);
	}

	@Override
	public PageInfo<CommentTwo> getAll(int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentTwo> list=commenttwoMapper.findAll();
		return new PageInfo<CommentTwo>(list);
	}

	@Override
	public PageInfo<CommentTwo> getByKey(String key, int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentTwo> list=commenttwoMapper.findByKey("%"+key+"%");
		return new PageInfo<CommentTwo>(list);
	}

	@Override
	public PageInfo<CommentTwo> getByUser(Integer id,int start,int size) {
		PageHelper.startPage(start, size);
		List<CommentTwo> list=commenttwoMapper.findByUser(id);
		return new PageInfo<CommentTwo>(list);
	}

	@Override
	public PageInfo<CommentTwo> getByOneAll(Integer oneid, int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentTwo> list=commenttwoMapper.findByOneAll(oneid);
		return new PageInfo<CommentTwo>(list);
	}
}
