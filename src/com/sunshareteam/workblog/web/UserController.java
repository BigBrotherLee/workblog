package com.sunshareteam.workblog.web;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigbrotherlee.utils.LeeConstant;
import com.bigbrotherlee.utils.LeeException;
import com.bigbrotherlee.utils.ResponseResult;
import com.bigbrotherlee.utils.VerificationCode;
import com.sunshareteam.workblog.service.UserService;

@RestController("/user")
public class UserController {
	
	//注意：responseresult属性分别有：state：状态码，message：消息，data：数据
	
	@Autowired
	private UserService userService;
	/**
	 * 得到图片验证码，将图片流返回到response，验证码有效期为15分钟
	 * @param session
	 * @param response
	 */
	@GetMapping("/verify")
	public void getVerifyCode(HttpSession session,HttpServletResponse response) {
		Integer verify=null;
		try {
			verify=VerificationCode.calculateToOutputstream(response.getOutputStream());
		} catch (IOException e) {
			throw new LeeException("获取验证码出错");
		}
		VerifyCode code=new VerifyCode();
		code.setCode(verify.toString());
		code.setExdate(15*60);
		session.setAttribute("validateCode", code);
	}
	
	/**
	 * 得到邮箱验证码，验证码有效期为15分钟
	 * @param session
	 * @return 成功则返回 ResponseResult的json，state为200，message发送成功，data为空
	 */
	@GetMapping("/getemailcode")
	public ResponseResult<String> getEmailCode(HttpSession session){
		ResponseResult<String> result=new ResponseResult<String>();
		
		
		return result;
	}
	
	/**
	 * 发送短信验证码，验证码有效期为15分钟
	 * @param session
	 * @return 成功则返回 ResponseResult的json，state为200，message发送成功，data为空
	 */
	@GetMapping("/getsmscode")
	public ResponseResult<String> getSmsCode(HttpSession session){
		ResponseResult<String> result=new ResponseResult<String>();
		
		
		return result;
	}
	
	/**
	 * 验证验证码是否正确，验证码有效期为15分钟
	 * @param code 用户提交的验证码
	 * @param session
	 * @return 成功则返回ResponseResult的json，state属性为200，失败则抛出异常LeeException
	 */
	@GetMapping("/validate/{code}")
	public ResponseResult<String> validate(@PathVariable String code,HttpSession session){
		ResponseResult<String> result=new ResponseResult<String>();
		VerifyCode realcode=(VerifyCode) session.getAttribute("validateCode");
		if(realcode==null) {
			throw new LeeException("验证码不存在");
		}
		boolean isPast=LocalDateTime.now().isAfter(realcode.getExdate());
		if(isPast) {
			session.removeAttribute("validateCode");
			throw new LeeException("验证码过期");
		}
		boolean notEquel=ObjectUtils.nullSafeEquals(realcode.getCode(), code);
		if(!notEquel) {
			session.removeAttribute("validateCode");
			throw new LeeException("验证码错误，请重新获取");
		}
		result.setState(LeeConstant.STATE_SUCCESS);
		result.setMessage("验证成功");
		return result;
	}
	
	/**
	 * 登录接口，参数为用户名和密码
	 * @param request
	 * @return 登录成功则继续访问，登录失败则抛出异常
	 */
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
