package com.sunshareteam.workblog.manager;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleManager {
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private FormService formService;
	
	/**
	 * 部署一个流程
	 * @param deployName 部署名称
	 * @param zipInput zip文件的流
	 */
	public void deploy(String deployName,InputStream zipInput) {
		repositoryService.createDeployment().name(deployName).addZipInputStream(new ZipInputStream(zipInput)).deploy();
	}
	
	/**
	 * 查询已部署的流程
	 * @param key deploymentKey
	 * @return 返回部署对象
	 */
	public List<Deployment> queryDepoly(String key){
		return repositoryService.createDeploymentQuery().deploymentKeyLike(key).list();
	}
	
	/**
	 * 查询已部署的流程定义
	 * @param key deploymentKey
	 * @return 返回部署对象
	 */
	public List<ProcessDefinition> queryProcessDefinition(){
		return repositoryService.createProcessDefinitionQuery().list();
		
	};
	/**
	 * 启动一个流程
	 * @param key 你要启动的流程的key
	 * @param variables 你要设置的流程变量
	 */
	public void startProcess(String key,Map<String,Object> variables) {
		runtimeService.startProcessInstanceByKey(key, variables);
	}
	
	/**
	 * 查询指定代理人的活跃任务
	 * @param assignee 代理人
	 * @return 任务流列表
	 */
	public List<Task> queryTask(String assignee){
		List<Task>  tasks=taskService.createTaskQuery().taskAssignee(assignee).active().list();
		return tasks;
	}
	
	/**
	 * 完成任务
	 * @param id 你要完成的任务的id
	 * @param variables 你完成任务时添加的流程变量
	 */
	public void complete(String id,Map<String,Object> variables) {
		taskService.complete(id, variables);
	}	
	
}
