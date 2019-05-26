package com.bigbrotherlee.example.service;

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

import com.bigbrotherlee.example.entity.admin;
import com.bigbrotherlee.example.entity.promission;
import com.bigbrotherlee.example.entity.role;

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
