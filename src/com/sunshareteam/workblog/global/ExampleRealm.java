package com.sunshareteam.workblog.global;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.sunshareteam.workblog.entity.User;
import com.sunshareteam.workblog.entity.Permission;
import com.sunshareteam.workblog.entity.Role;
import com.sunshareteam.workblog.service.UserService;


public class ExampleRealm extends  AuthorizingRealm{
	
//	@Autowired
	private UserService userService;
	
	/* 
	 * 授权
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		User user=(User) principal.getPrimaryPrincipal();
		List<Permission> Permissions=userService.getPermissionByUserId(user.getUserid());
		List<Role> roles=userService.getRoleByUserId(user.getUserid());
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		for(Role r:roles) {
			info.addRole(r.getRolename());
		}
		for(Permission p: Permissions) {
			info.addStringPermission(p.getPermissioncode());
		}
		return info;
	}
	
	/* 
	 * 认证
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 使用get方式会直接登录失败
		Integer name=(Integer)token.getPrincipal();
		User a=userService.getUserById(name);
		AuthenticationInfo info=new SimpleAuthenticationInfo(a, a.getPassword(), ByteSource.Util.bytes(a.getSalt()), "com.sunshareteam.workblog.global.ExampleRealm");
		return info;
	}
	
}
