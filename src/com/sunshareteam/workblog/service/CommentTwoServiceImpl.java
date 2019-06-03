package com.sunshareteam.workblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshareteam.workblog.dao.CommentTwoMapper;
import com.sunshareteam.workblog.entity.CommentTwo;

@Service("commenttwoService")
public class CommentTwoServiceImpl implements CommentTwoService {
	@Autowired
	private CommentTwoMapper commenttwoMapper;

	@Override
	public CommentTwo getCommentTwoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentTwo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCommentTwo(CommentTwo commenttwo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCommentTwo(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
