package com.sunshareteam.workblog.entity;

import java.io.Serializable;
import java.util.List;

import org.activiti.engine.impl.persistence.entity.DeploymentEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

import lombok.Data;

@Data
public class ProcessDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4658364865639494267L;
	
	private List<Deployment> deployments;
	private List<ProcessDefinition> processDefinitions;	
}
