package com.sunshareteam.workblog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
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
	public void deleteCommentOne(Integer id) {
		commentoneMapper.delete(id);
		commentoneMapper.deleteCommentTwoByCommentOne(id);	//删除一级评论下的二级评论
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

	@Override
	public PageInfo<CommentOne> getByKey(String key, int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentOne> list=commentoneMapper.findByKey("%"+key+"%");
		return new PageInfo<CommentOne>(list);
	}

	@Override
	public CommentOne getByUser(Integer userid) {
		// TODO Auto-generated method stub
		return commentoneMapper.getCommentOneByUser(userid);
	}
}
