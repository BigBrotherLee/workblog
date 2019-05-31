package com.sunshareteam.workblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshareteam.workblog.dao.CommentTwoMapper;

@Service("commenttwoService")
public class CommentTwoServiceImpl implements CommentTwoService {
	@Autowired
	private CommentTwoMapper commenttwoMapper;
}
