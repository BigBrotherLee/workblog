package com.sunshareteam.workblog.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.bigbrotherlee.utils.Alisms;
import com.bigbrotherlee.utils.LeeConstant;
import com.bigbrotherlee.utils.LeeException;
import com.bigbrotherlee.utils.ResponseResult;
import com.bigbrotherlee.utils.UUIDUtils;
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
	private MailSender mailSender;
	
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
		Integer vCode=RandomUtils.nextInt(100000, 999999);
		String msg="[workblog验证码] 感谢您使用workblog，你的验证码是\n："+vCode+"，15分钟内有效。\n如果这不是您的操作，请忽略";
		SimpleMailMessage smm=new SimpleMailMessage();
		smm.setFrom("lee_dage@163.com");
		smm.setSubject("workblog验证码");
		smm.setText(msg);
		smm.setTo(email);
		try {
			mailSender.send(smm);
			User user=new User();
			user.setEmail(email);
			session.setAttribute("registerUser", user);
			VerifyCode code=new VerifyCode(vCode.toString(), LocalDateTime.now().plusSeconds(15*60));
			session.setAttribute("vCode", code);
			result.setMessage("验证码已发送至："+email);
			result.setState(LeeConstant.STATE_SUCCESS);
		}catch (Exception e) {
			result.setMessage("验证码发送失败："+email);
			result.setState(LeeConstant.STATE_ERROR);
		}
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
		Integer vCode=RandomUtils.nextInt(100000, 999999);
		SendSmsRequest request=Alisms.buildRequest(phone, "workblog", "SMS_166865875", "{'code':'"+vCode+"'}", null, null);
		try {
			SendSmsResponse sendSmsResponse=Alisms.doSend(request);
			if(StringUtils.equalsAnyIgnoreCase(sendSmsResponse.getCode(), "OK")) {
				User user=new User();
				user.setPhone(phone);
				session.setAttribute("registerUser", user);
				VerifyCode code=new VerifyCode(vCode.toString(), LocalDateTime.now().plusSeconds(15*60));
				session.setAttribute("vCode", code);
				result.setData(sendSmsResponse.getCode());
				result.setMessage("验证码已发送至："+phone);
				result.setState(LeeConstant.STATE_SUCCESS);
			}else {
				result.setData(sendSmsResponse.getCode());
				result.setMessage("验证码发送失败："+phone);
				result.setState(LeeConstant.STATE_FAIL);
			}
		} catch (ClientException e) {
			result.setData(e.getMessage());
			result.setMessage("验证码发送出错："+phone);
			result.setState(LeeConstant.STATE_ERROR);
		}
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
	@RequiresGuest
	@PostMapping("/register")
	public ResponseResult<User> register(User user,String code,HttpSession session) throws Exception{
		ResponseResult<User> result=new ResponseResult<User>();
		VerifyCode realcode=(VerifyCode) session.getAttribute("vCode");
		if(realcode==null) {
			throw new LeeException("验证码不存在");
		}
		boolean isPast=LocalDateTime.now().isAfter(realcode.getExdate());
		if(isPast) {
			session.removeAttribute("registerUser");
			session.removeAttribute("vCode");
			throw new LeeException("验证码过期");
		}
		boolean notEquel=ObjectUtils.nullSafeEquals(realcode.getCode(), code);
		if(!notEquel) {
			session.removeAttribute("registerUser");
			session.removeAttribute("vCode");
			throw new LeeException("验证码错误，请重新获取");
		}
		User nameUser=userService.getByName(user.getUsername());
		if(nameUser!=null) {
			session.removeAttribute("registerUser");
			session.removeAttribute("vCode");
			throw new LeeException("用户名已存在");
		}
		String email=BeanUtils.getProperty(session.getAttribute("registerUser"), "email");
		String phone=BeanUtils.getProperty(session.getAttribute("registerUser"), "phone");
		if(ObjectUtils.nullSafeEquals(email, user.getEmail()) && ObjectUtils.nullSafeEquals(phone, user.getPhone())) {
			result.setState(LeeConstant.STATE_SUCCESS);
			result.setData(user);
			result.setMessage("注册成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		}else {
			session.removeAttribute("vCode");
			throw new LeeException("你不能更改你的email或者手机号码");
		}
		result.setMessage("注册失败");
		result.setState(LeeConstant.STATE_SUCCESS);
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
	public ResponseResult<String> register(String password,String code,HttpSession session) throws Exception{
		ResponseResult<String> result=new ResponseResult<>();
		VerifyCode realcode=(VerifyCode) session.getAttribute("vCode");
		if(realcode==null) {
			throw new LeeException("验证码不存在");
		}
		boolean isPast=LocalDateTime.now().isAfter(realcode.getExdate());
		if(isPast) {
			session.removeAttribute("vCode");
			throw new LeeException("验证码过期");
		}
		boolean notEquel=ObjectUtils.nullSafeEquals(realcode.getCode(), code);
		if(!notEquel) {
			session.removeAttribute("vCode");
			throw new LeeException("验证码错误，请重新获取");
		}
		String email=BeanUtils.getProperty(session.getAttribute("registerUser"), "email");
		String phone=BeanUtils.getProperty(session.getAttribute("registerUser"), "phone");
		User realuser=null;
		if(!ObjectUtils.isEmpty(email)) {
			realuser=userService.getByEmail(email);
		}
		if(!ObjectUtils.isEmpty(phone)) {
//			realuser=userService.getPhone(phone);
		}
		
		
		if(realuser!=null) {
			result.setState(LeeConstant.STATE_SUCCESS);
			String salt=UUIDUtils.getUUIDNoConnect().substring(0, 6);
			String pwd=new SimpleHash("MD5",password,ByteSource.Util.bytes(salt),2).toString();
			realuser.setSalt(salt);
			realuser.setPassword(pwd);
			userService.updateUser(realuser);
			result.setMessage("修改成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		}else {
			session.removeAttribute("vCode");
			throw new LeeException("你不能更改你的email或者手机号码");
		}
		result.setMessage("修改失败");
		result.setState(LeeConstant.STATE_SUCCESS);
		return result;
		
	}
	
	/**
	 * 登录接口，参数为用户名和密码
	 * @param request
	 * @return 登录成功则继续访问，登录失败则抛出异常
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		//如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		System.out.println(exceptionClassName+"-----------------------");
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
		return new ModelAndView("user/login");
	}
	
	/**
	 * 得到指定id用户的信息
	 * @param id 用户id
	 * @return 查询成功则返回responseresult<user>，state：1，message：查询成功，data:该user的json
	 */
	@GetMapping("/get/{id}")
	public ResponseResult<User> getUserInfoById(@PathVariable Integer id){
		ResponseResult<User> result=new ResponseResult<User>();
		User user=userService.getUserById(id);
		if(ObjectUtils.isEmpty(user)) {
			result.setMessage("查询为空");
			result.setState(LeeConstant.STATE_FAIL);
		}else {
			result.setMessage("查询成功");
			result.setData(user);
			result.setState(LeeConstant.STATE_SUCCESS);
		}
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
	public ResponseResult<PageInfo<User>> getAdmin(@PathVariable int index,@PathVariable int length,@RequestParam(defaultValue = "_",required = false) String key) {
		ResponseResult<PageInfo<User>> result=new ResponseResult<PageInfo<User>>();
		PageInfo<User> info=userService.getAdmin(index, length,key);
		if(info.getTotal()<=0) {
			result.setMessage("查询为空");
			result.setState(LeeConstant.STATE_FAIL);
		}else {
			result.setData(info);
			result.setMessage("查询成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		}
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
		try {
			userService.disableUser(id);
			result.setMessage("已删除");
			result.setData(id.toString());
			result.setState(LeeConstant.STATE_SUCCESS);
		}catch (Exception e) {
			result.setData(e.getMessage());
			result.setMessage("删除失败");
			result.setState(LeeConstant.STATE_ERROR);
		}
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
		boolean hasPermission=realUser.getUserid().equals(user.getUserid()) || SecurityUtils.getSubject().hasRole("admin");
		if(hasPermission) {
			user.setModifydate(new Date());
			user.setModifyuser(realUser.getUserid());
			try{
				userService.updateUser(user);
				result.setData(user);
				result.setState(LeeConstant.STATE_SUCCESS);
				result.setMessage("修改成功");
			}catch (Exception e) {
				result.setData(user);
				result.setState(LeeConstant.STATE_FAIL);
				result.setMessage("修改失败");
			}
			return result;
		}else {
			throw new LeeException("无权限");
		}
	}
	
	/**
	 * 得到用户列表（分页）
	 * @param start 开始位置
	 * @param length 每页大小
	 * @param key 用户名
	 * @return 成功则返回responseresult<PageInfo<User>>，state：1，message：查询成功，data：用户分页数据，失败抛出异常
	 */
	@GetMapping("/list/{start}/{length}")
	public ResponseResult<PageInfo<User>> getUserList(@PathVariable int start,@PathVariable int length,@RequestParam(defaultValue = "_",required = false) String key) {
		ResponseResult<PageInfo<User>> result=new ResponseResult<PageInfo<User>>();
		PageInfo<User> data=userService.getByKey(key, start, length);
		if(data.getTotal()<=0) {
			result.setMessage("查询为空");
			result.setState(LeeConstant.STATE_FAIL);
		}else {
			result.setData(data);
			result.setMessage("查询成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		}
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
		try {
			userService.addUser(user);
			result.setData(user);
			result.setMessage("添加成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		}catch (Exception e) {
			result.setData(user);
			result.setMessage("添加失败");
			result.setState(LeeConstant.STATE_ERROR);
		}
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
		try {
			userService.addRole(role);
			result.setData(role);
			result.setMessage("添加成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		}catch (Exception e) {
			result.setData(role);
			result.setMessage("添加失败");
			result.setState(LeeConstant.STATE_ERROR);
		}
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
		try {
			userService.addPermission(permission);
			result.setData(permission);
			result.setMessage("添加成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		}catch (Exception e) {
			result.setData(permission);
			result.setMessage("添加失败");
			result.setState(LeeConstant.STATE_ERROR);
		}
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
		try {
			userService.addPermissionToRole(permissionid, roleid);
			result.setMessage("添加成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		}catch (Exception e) {
			result.setMessage("添加失败");
			result.setState(LeeConstant.STATE_ERROR);
		}
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
		try {
			userService.addRoleToUser(roleid, userid);
			result.setMessage("添加成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		}catch (Exception e) {
			result.setMessage("添加失败");
			result.setState(LeeConstant.STATE_ERROR);
		}
		return result;
	}
	/**
	 * 检查email
	 * @param email
	 * @return
	 */
	@GetMapping("/checkemail")
	public ResponseResult<String> checkEmail(String email){
		ResponseResult<String> result=new ResponseResult<String>();
		User user=userService.getByEmail(email);
		if(user==null) {
			result.setData(email);
			result.setState(LeeConstant.STATE_FAIL);
			result.setMessage("该email未注册");
			return result;
		}
		result.setData(email);
		result.setState(LeeConstant.STATE_SUCCESS);
		result.setMessage("该email已注册");
		return result;
	}
	
	/**
	 * 检查用户名
	 * @param name
	 * @return
	 */
	@GetMapping("/checkname")
	public ResponseResult<String> checkName(String name){
		ResponseResult<String> result=new ResponseResult<String>();
		User user=userService.getByName(name);
		if(user==null) {
			result.setData(name);
			result.setState(LeeConstant.STATE_FAIL);
			result.setMessage("该用户名未注册");
			return result;
		}
		result.setData(name);
		result.setState(LeeConstant.STATE_SUCCESS);
		result.setMessage("该用户名已注册");
		return result;
	}
	
}
