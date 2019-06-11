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
import com.sunshareteam.workblog.web.CommentOneVO;

@Service("commentoneService")
public class CommentOneServiceImpl implements CommentOneService{
	@Autowired
	private CommentOneMapper commentoneMapper;

	@Override
	public CommentOne getById(Integer id) {
		return commentoneMapper.findById(id);
	}
	
	@Override
	public PageInfo<CommentOneVO> getByArticleAndUser(Integer userid,int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentOneVO> list=commentoneMapper.findByArticleAndUser(userid);
		return new PageInfo<CommentOneVO>(list);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		commentoneMapper.delete(id);
		commentoneMapper.deleteCommentTwo(id);	//删除一级评论下的二级评论
	}

	@Override
	@Transactional
	public void insertCommentOne(CommentOne commentone) {
		commentone.setCreatedate(new Date());
		commentoneMapper.insertCommentOne(commentone);	
	}
	
	@Override
	public PageInfo<CommentOne> getAll(int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentOne> list=commentoneMapper.findAll();
		return new PageInfo<CommentOne>(list);
	}

	@Override
	public PageInfo<CommentOne> getByKey(String key, int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentOne> list=commentoneMapper.findByKey("%"+key+"%");
		return new PageInfo<CommentOne>(list);
	}

	@Override
	public PageInfo<CommentOne> getByUser(Integer id, int start, int size){
		PageHelper.startPage(start, size);
		List<CommentOne> list=commentoneMapper.findByUser(id);
		return new PageInfo<CommentOne>(list);
	}

	@Override
	public PageInfo<CommentOne> getByArticleAll(Integer articleid, int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentOne> list=commentoneMapper.findByArticleAll(articleid);
		return new PageInfo<CommentOne>(list);
	}

	@Override
	public PageInfo<CommentOne> getByUserAll(Integer userid, int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentOne> list=commentoneMapper.findByUserAll(userid);
		return new PageInfo<CommentOne>(list);
	}
}
