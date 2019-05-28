package com.sunshareteam.workblog.web;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bigbrotherlee.utils.LeeException;
import com.bigbrotherlee.utils.VerificationCode;
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
