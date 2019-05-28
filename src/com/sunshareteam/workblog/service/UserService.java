package com.sunshareteam.workblog.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;


import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;

import com.sunshareteam.workblog.entity.Permission;
import com.sunshareteam.workblog.entity.Role;
import com.sunshareteam.workblog.entity.User;

public interface UserService {
	User getAdmin(String name);
	List<Role> getRole(String name);
	List<Permission> getPromission(String name);
	void deploy(String deployName,InputStream zipInput);
	List<Deployment> queryDepoly(String key);
	List<ProcessDefinition> queryProcessDefinition(); 
	void startProcess(String key,Map<String,Object> variables);
	List<Task> queryTask(String assignee);
	void complete(String id,Map<String,Object> variables);
}
