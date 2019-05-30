package com.sunshareteam.workblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshareteam.workblog.dao.CategotyMapper;

@Service("categotyService")
public class CategotyServiceImpl implements CategotyService {
	@Autowired
	private CategotyMapper categotyMapper;
}
