package com.sunshareteam.workblog.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bigbrotherlee.utils.LeeConstant;
import com.bigbrotherlee.utils.LeeException;
import com.bigbrotherlee.utils.ResponseResult;
import com.bigbrotherlee.utils.VerificationCode;
import com.sunshareteam.workblog.entity.ProcessDTO;
import com.sunshareteam.workblog.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/validate")
	public void validate(HttpSession session,HttpServletResponse response) {
		Integer verify=null;
		try {
			verify=VerificationCode.calculateToOutputstream(response.getOutputStream());
		} catch (IOException e) {
			throw new LeeException("获取验证码出错");
		}
		session.setAttribute("validateCode", verify);
	}
	
	@RequiresRoles({"组长","经理"})
	@PostMapping("/uploadprocess")
	public void uploadProcess(String name,MultipartFile file) throws Exception {
		userService.deploy(name,file.getInputStream());
	}
	
	@RequiresPermissions("process:query:*")
	@GetMapping("/querydeploy")
	public ResponseResult<ProcessDTO> queryDeploy(String key) {
		ProcessDTO dto=new ProcessDTO();
		List<ProcessDefinition> definitions=userService.queryProcessDefinition();
		dto.setProcessDefinitions(null);
		ResponseResult<ProcessDTO> result=new ResponseResult<>();
		result.setData(dto);
		result.setState(LeeConstant.STATE_SUCCESS);
		result.setMessage(definitions.get(0).getKey());
		return result;
	}
	
	@RequiresPermissions("process:update:*")
	@GetMapping("/start")
	public ResponseResult<String> start(String user,String process){
		ResponseResult<String> result=new ResponseResult<String>();
		Map<String,Object> variables=new HashMap<>();
		variables.put("inputuser", user);
		userService.startProcess(process, variables);
		result.setData("启动成功");
		return result;
	}
	
	@GetMapping("/queryProcess")
	@RequiresPermissions("process:query:*")
	public  ResponseResult<List<Task>>  queryProcess(String assignee){
		ResponseResult<List<Task>> result=new ResponseResult<>();
		result.setMessage("SUCCESS");
		result.setState(LeeConstant.STATE_SUCCESS);
		List<Task> tasks=userService.queryTask(assignee);
		System.out.println(tasks.get(0).getId()+"---------------------queryProcess------------------"+tasks.get(0).getAssignee());
		result.setData(tasks);
		return result;
	}
	
	@RequiresPermissions("process:update:*")
	@GetMapping("/grouppass")
	public ResponseResult<String> groupPass(String id,String key,String value){
		ResponseResult<String> result=new ResponseResult<String>();
		result.setState(LeeConstant.STATE_SUCCESS);
		result.setMessage("SUCCESS");
		Map<String,Object> variables=new HashMap<>();
		variables.put(key, value);
		userService.complete(id, variables);
		return result;
	}
	
	@RequiresPermissions("process:update:*")
	@GetMapping("/adminpass")
	public ResponseResult<String> adminPass(String id,String key,String value){
		ResponseResult<String> result=new ResponseResult<String>();
		result.setState(LeeConstant.STATE_SUCCESS);
		result.setMessage("SUCCESS");
		Map<String,Object> variables=new HashMap<>();
		variables.put(key, value);
		userService.complete(id, variables);
		return result;
	}
	
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		//如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
				String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
				//根据shiro返回的异常类路径判断，抛出指定异常信息
				if(exceptionClassName!=null){
					if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
						//最终会抛给异常处理器
						throw new LeeException("账号不存在");
					} else if (IncorrectCredentialsException.class.getName().equals(
							exceptionClassName)) {
						throw new LeeException("用户名/密码错误");
					} else if("randomCodeError".equals(exceptionClassName)){
						throw new LeeException("验证码错误 ");
					}else {
						throw new LeeException("未知错误");//最终在异常处理器生成未知错误
					}
				}
				return "login";
	}
}
