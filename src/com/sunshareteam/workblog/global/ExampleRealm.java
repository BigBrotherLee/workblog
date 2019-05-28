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
import com.sunshareteam.workblog.entity.;
import com.sunshareteam.workblog.service.UserService;


public class ExampleRealm extends  AuthorizingRealm{
	
	@Autowired
	private UserService exampleService;
	
	/* 
	 * 授权
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		User a=(User) principal.getPrimaryPrincipal();
		List<Permission> Permissions=exampleService.getPermission(a.getUsercode());
		List<> s=exampleService.get(a.());
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		for( r:s) {
			info.add(r.getName());
			System.out.println("----------------realm-----------------"+r.getName());
		}
		for(Permission p: Permissions) {
			System.out.println("----------------realm-----------------"+p.getPermissioncode());
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
		String name=(String)token.getPrincipal();
		User a=exampleService.getUser(name);
		AuthenticationInfo info=new SimpleAuthenticationInfo(a, a.getPassword(), ByteSource.Util.bytes(a.getSalt()), "com.bigbrotherlee.example.global.ExampleRealm");
		return info;
	}
	
}
