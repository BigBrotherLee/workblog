package com.sunshareteam.workblog.entity;

public class UserRole {
	private Integer user_role_id;
	private Integer roleid;
	private Integer userid;
	
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(Integer user_role_id) {
		this.user_role_id = user_role_id;
	}
	@Override
	public String toString() {
		return "UserRole [user_role_id=" + user_role_id + ", roleid=" + roleid + ", userid=" + userid + "]";
	}
}
