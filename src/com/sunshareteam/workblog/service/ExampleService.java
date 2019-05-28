package com.sunshareteam.workblog.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.impl.persistence.entity.DeploymentEntity;
import org.activiti.engine.impl.persistence.entity.DeploymentEntityImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;

import com.sunshareteam.workblog.entity.admin;
import com.sunshareteam.workblog.entity.promission;
import com.sunshareteam.workblog.entity.role;

public interface ExampleService {
	admin getAdmin(String name);
	List<role> getRole(String name);
	List<promission> getPromission(String name);
	void deploy(String deployName,InputStream zipInput);
	List<Deployment> queryDepoly(String key);
	List<ProcessDefinition> queryProcessDefinition(); 
	void startProcess(String key,Map<String,Object> variables);
	List<Task> queryTask(String assignee);
	void complete(String id,Map<String,Object> variables);
}
