package com.sunshareteam.workblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshareteam.workblog.dao.CommentOneMapper;
import com.sunshareteam.workblog.entity.CommentOne;

@Service("commentoneService")
public class CommentOneServiceImpl implements CommentOneService{
	@Autowired
	private CommentOneMapper commentoneMapper;

	@Override
	public CommentOne getCommentOneById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentOne> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCommentOne(CommentOne commentone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCommentOne(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CommentOne> findPersonalAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
