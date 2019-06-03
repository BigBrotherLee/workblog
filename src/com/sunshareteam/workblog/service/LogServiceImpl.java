package com.sunshareteam.workblog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.dao.LogMapper;
import com.sunshareteam.workblog.entity.Log;

@Service("logService")
public class LogServiceImpl implements LogService {
	@Autowired
	private LogMapper logMapper;

	@Override
	@Transactional
	public void addLog(Log log) {
		log.setCreatedate(new Date());
		logMapper.insertLog(log);
	}

	@Override
	public Log getById(Integer id) {
		return logMapper.findLogById(id);
	}

	@Override
	public PageInfo<Log> getAll(int start, int size) {
		PageHelper.startPage(start, size);
		List<Log> list=logMapper.findLog();
		return new PageInfo<Log>(list);
	}
}
