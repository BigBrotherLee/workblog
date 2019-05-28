package com.sunshareteam.workblog.global;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.apache.shiro.SecurityUtils;


import com.sunshareteam.workblog.entity.admin;

public class ManagerTaskHandler implements TaskListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7156307068741662188L;

	@Override
	public void notify(DelegateTask delegateTask) {
		admin a=(admin)SecurityUtils.getSubject().getPrincipal();
		
		
	}

}
