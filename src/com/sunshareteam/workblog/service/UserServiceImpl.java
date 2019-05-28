package com.sunshareteam.workblog.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.impl.persistence.entity.DeploymentEntityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshareteam.workblog.dao.UserMapper;
import com.sunshareteam.workblog.entity.admin;
import com.sunshareteam.workblog.entity.promission;
import com.sunshareteam.workblog.entity.role;
import com.sunshareteam.workblog.manager.ProcessManager;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper  exampleMapper;
	@Autowired
	private ProcessManager exampleManager;
	
	@Override
	public admin getAdmin(String name) {
		return exampleMapper.findAdmin(name);
	}

	@Override
	public List<role> getRole(String name) {
		return exampleMapper.findRole(name);
	}

	@Override
	public List<promission> getPromission(String name) {
		return exampleMapper.findPromission(name);
	}

	@Override
	public void deploy(String deployName, InputStream zipInput) {
		exampleManager.deploy(deployName, zipInput);
	}

	@Override
	public List<Deployment> queryDepoly(String key) {
		// TODO Auto-generated method stub
		return exampleManager.queryDepoly(key);
	}

	@Override
	public void startProcess(String key, Map<String, Object> variables) {
		exampleManager.startProcess(key, variables);
	}

	@Override
	public List<Task> queryTask(String assignee) {
		// TODO Auto-generated method stub
		return exampleManager.queryTask(assignee);
	}

	@Override
	public void complete(String id, Map<String, Object> variables) {
		exampleManager.complete(id, variables);
	}

	@Override
	public List<ProcessDefinition> queryProcessDefinition() {
		return exampleManager.queryProcessDefinition();
	}
	
	
}
