package com.sunshareteam.workblog.global;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;


/**
 * 重写是为了验证码，使用get方式会直接登录失败
 * @author li
 * @createdate 2019年4月12日
 */
public class ExampleFormAuthenticationFilter extends FormAuthenticationFilter {
	
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest servletRequest=(HttpServletRequest)request;
		HttpSession session =servletRequest.getSession();
		System.out.println(session.getId());
//		String validateCode = (String) session.getAttribute("validateCode");
//		String randomcode = servletRequest.getParameter("randomcode");
//		if(randomcode!=null && validateCode!=null && !randomcode.equals(validateCode)){
//			servletRequest.setAttribute("shiroLoginFailure", "randomCodeError");
//			return true; 
//		}
		return super.onAccessDenied(request, response);
	}
}
