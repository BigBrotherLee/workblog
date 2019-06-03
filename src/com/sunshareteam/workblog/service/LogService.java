package com.sunshareteam.workblog.service;

import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.Log;

public interface LogService {
	void addLog(Log log);
	Log getById(Integer id);
	PageInfo<Log> getAll(int start,int size);
}
