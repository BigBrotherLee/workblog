package com.sunshareteam.workblog.global;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.apache.shiro.SecurityUtils;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sunshareteam.workblog.entity.admin;

public class ManagerTaskHandler implements TaskListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7156307068741662188L;

	@Override
	public void notify(DelegateTask delegateTask) {
		admin a=(admin)SecurityUtils.getSubject().getPrincipal();
		if(a.getUsercode().equals("001")) {
			delegateTask.setAssignee("002");
		}else if(a.getUsercode().equals("002")) {
			delegateTask.setAssignee("003");
		}
		
	}

}
