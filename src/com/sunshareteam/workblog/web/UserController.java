package com.sunshareteam.workblog.web;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigbrotherlee.utils.LeeConstant;
import com.bigbrotherlee.utils.LeeException;
import com.bigbrotherlee.utils.ResponseResult;
import com.bigbrotherlee.utils.VerificationCode;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.Permission;
import com.sunshareteam.workblog.entity.Role;
import com.sunshareteam.workblog.entity.User;
import com.sunshareteam.workblog.service.UserService;

@RestController
@RequestMapping("/user")
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
	 * @param eamil 接受邮件的email地址
	 * @return 成功则返回 ResponseResult的json，state为1，message发送成功，data为空
	 */
	@GetMapping("/getemailcode/{email}")
	public ResponseResult<String> getEmailCode(HttpSession session,@PathVariable String email){
		ResponseResult<String> result=new ResponseResult<String>();
		
		
		return result;
	}
	
	/**
	 * 发送短信验证码，验证码有效期为15分钟
	 * @param session
	 * @param phone 用户电话号码
	 * @return 成功则返回 ResponseResult的json，state为1，message发送成功，data为空
	 */
	@GetMapping("/getsmscode/{phone}")
	public ResponseResult<String> getSmsCode(HttpSession session,@PathVariable String phone){
		ResponseResult<String> result=new ResponseResult<String>();
		
		
		return result;
	}
	
	/**
	 * 验证验证码是否正确，验证码有效期为15分钟
	 * @param code 用户提交的验证码
	 * @param session
	 * @return 成功则无返回ResponseResult<String>,state:1,message:验证成功，失败则抛出异常LeeException
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
	 * 注册接口
	 * @param user 注册用户信息
	 * @param code 验证码
	 * @param session
	 * @return 成功则返回ResponseResult<User> state：1，message：注册成功，data注册的user
	 */
	@PostMapping("/register")
	public ResponseResult<User> register(User user,String code,HttpSession session){
		ResponseResult<User> result=new ResponseResult<User>();
		validate(code,session);
		
		return result;
	}
	
	/**
	 * 重置密码接口
	 * @param password 新密码
	 * @param code 验证码
	 * @param session
	 * @return 成功则返回ResponseResult<String> state：1，message：重置成功
	 */
	@PostMapping("/resetpassword")
	public ResponseResult<String> register(String password,String code,HttpSession session){
		ResponseResult<String> result=new ResponseResult<>();
		validate(code,session);
		
		return result;
	}
	
	/**
	 * 登录接口，参数为用户名和密码
	 * @param request
	 * @return 登录成功则继续访问，登录失败则抛出异常
	 */
	@PostMapping("/login")
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
	
	/**
	 * 得到指定id用户的信息
	 * @param id 用户id
	 * @return 查询成功则返回responseresult<user>，state：1，message：查询成功，data:该user的json
	 */
	@GetMapping("/get/{id}")
	public ResponseResult<User> getUserInfoById(@PathVariable Integer id){
		ResponseResult<User> result=new ResponseResult<User>();
		
		return result;
	}
	
	/**
	 * 查询管理员
	 * @param index 第几页
	 * @param length 一页几条
	 * @param key 关键字
	 * @return 查询成功返回ResponseResult<PageInfo<User>>分页数据，失败抛出异常LeeException
	 */
	@RequiresPermissions("admin:select:*")
	@GetMapping("/getadmin/{index}/{length}")
	public ResponseResult<PageInfo<User>> getAdmin(@PathVariable int index,@PathVariable int length,String key) {
		ResponseResult<PageInfo<User>> result=new ResponseResult<PageInfo<User>>();
		
		return result;
	}
	
	/**
	 * 删除（禁用）用户，只有用户删除权限的人才可以调用
	 * @param id 用户id
	 * @return 删除成功则返回responseresult<String>，state：1，message禁用成功，失败抛出异常
	 */
	@RequiresRoles("admin")
	@RequiresPermissions("user:delete:*")
	@DeleteMapping("/delete/{id}")
	public ResponseResult<String> deleteUser(@PathVariable Integer id){
		ResponseResult<String> result=new ResponseResult<String>();
		
		return result;
	}
	
	
	/**
	 * 更改用户信息
	 * @param user 更改后的用户信息
	 * @param session
	 * @return 更改成功则返回responseresult<User>，state：1，message：修改成功，data：更改后的用户信息json，失败抛出异常
	 */
	@RequiresRoles("user")
	@PutMapping("/update")
	public ResponseResult<User> updateUser(User user,HttpSession session){
		ResponseResult<User> result=new ResponseResult<User>();
		User realUser=(User) SecurityUtils.getSubject().getPrincipal();
		SecurityUtils.getSubject().hasRole("admin");
		
		return result;
	}
	
	/**
	 * 得到用户列表（分页）
	 * @param start 开始位置
	 * @param length 每页大小
	 * @param key 用户名
	 * @return 成功则返回responseresult<PageInfo<User>>，state：1，message：查询成功，data：用户分页数据，失败抛出异常
	 */
	@GetMapping("/list/{start}/{length}")
	public ResponseResult<PageInfo<User>> getUserList(@PathVariable int start,@PathVariable int length,String key) {
		ResponseResult<PageInfo<User>> result=new ResponseResult<PageInfo<User>>();
		
		return result;
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @return 添加成功则返回responseresult<User>，state：1，message：添加成功，data：添加的用户信息json，失败抛出异常
	 */
	@RequiresRoles("admin")
	@PostMapping("/adduser")
	public ResponseResult<User> addUser(User user ,HttpSession session){
		ResponseResult<User> result=new ResponseResult<User>();
		
		return result;
	}
	
	
	/**
	 * 添加角色
	 * @param role 要添加的角色信息
	 * @return 添加成功则返回responseresult<Role>，state：1，message：添加成功，data：添加的角色信息json，失败抛出异常
	 */
	@RequiresPermissions("role:insert:*")
	@PostMapping("/addrole")
	public ResponseResult<Role> addRole(Role role){
		ResponseResult<Role> result=new ResponseResult<Role>();
		return result;
	}
	
	
	/**
	 * 添加权限
	 * @param permission 要添加的权限对象
	 * @return 添加成功则返回responseresult<Permission>，state：1，message：添加成功，data：添加的权限信息json，失败抛出异常
	 */
	@RequiresPermissions("permission:insert:*")
	@PostMapping("/addpermission")
	public ResponseResult<Permission> addPermission(Permission permission){
		ResponseResult<Permission> result=new ResponseResult<Permission>();
		
		return result;
	}
	
	/**
	 * 为角色添加权限
	 * @param permissionid 权限id
	 * @param roleid 角色id
	 * @return 添加成功则返回responseresult<String>，state：1，message：添加成功，data：
	 */
	@RequiresPermissions("permission:insert:*")
	@PostMapping("/addPermissionToRole/{permissionid}/{roleid}")
	public ResponseResult<String> addPermissionToRole(int permissionid,int roleid){
		ResponseResult<String> result=new ResponseResult<String>();
		return result;
	}
	
	
	/**
	 * 为用户添加角色
	 * @param userid 用户id
	 * @param roleid 角色id
	 * @return 添加成功则返回responseresult<String>，state：1，message：添加成功，data
	 */
	@RequiresRoles("admin")
	@PostMapping("/addusertorole/{userid}/{roleid}")
	public ResponseResult<String> addUserToRole(int userid,int roleid){
		ResponseResult<String> result=new ResponseResult<String>();
		return result;
	}
	
	
}
