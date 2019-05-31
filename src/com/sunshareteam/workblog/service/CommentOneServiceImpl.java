package com.sunshareteam.workblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshareteam.workblog.dao.CommentOneMapper;

@Service("commentoneService")
public class CommentOneServiceImpl implements CommentOneService{
	@Autowired
	private CommentOneMapper commentoneMapper;
	

}
