package com.bigbrotherlee.example.global;

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

import com.bigbrotherlee.example.entity.admin;
import com.bigbrotherlee.example.entity.promission;
import com.bigbrotherlee.example.entity.role;
import com.bigbrotherlee.example.service.ExampleService;


public class ExampleRealm extends  AuthorizingRealm{
	
	@Autowired
	private ExampleService exampleService;
	
	/* 
	 * 授权
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		admin a=(admin) principal.getPrimaryPrincipal();
		List<promission> promissions=exampleService.getPromission(a.getUsercode());
		List<role> roles=exampleService.getRole(a.getUsercode());
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		for(role r:roles) {
			info.addRole(r.getName());
			System.out.println("----------------realm-----------------"+r.getName());
		}
		for(promission p: promissions) {
			System.out.println("----------------realm-----------------"+p.getPercode());
			info.addStringPermission(p.getPercode());
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
		admin a=exampleService.getAdmin(name);
		AuthenticationInfo info=new SimpleAuthenticationInfo(a, a.getPassword(), ByteSource.Util.bytes(a.getSalt()), "com.bigbrotherlee.example.global.ExampleRealm");
		return info;
	}
	
}
