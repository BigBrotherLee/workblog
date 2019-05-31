package com.sunshareteam.workblog.dao;

import java.util.List;

import com.sunshareteam.workblog.entity.Log;

public interface LogMapper {
	void insertLog();
	
	Log findLogById(Integer logid);
	
	List<Log> findLog();
}
