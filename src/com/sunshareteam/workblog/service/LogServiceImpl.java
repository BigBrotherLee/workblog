package com.sunshareteam.workblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshareteam.workblog.dao.LogMapper;

@Service("logService")
public class LogServiceImpl implements LogService {
	@Autowired
	private LogMapper logMapper;
}
