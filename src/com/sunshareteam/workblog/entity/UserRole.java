package com.sunshareteam.workblog.entity;

public class UserRole {
	private Integer userroleid;
	private Integer roleid;
	private Integer userid;
	public Integer getUserroleid() {
		return userroleid;
	}
	public void setUserroleid(Integer userroleid) {
		this.userroleid = userroleid;
	}
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
	@Override
	public String toString() {
		return "UserRole [userroleid=" + userroleid + ", roleid=" + roleid + ", userid=" + userid + "]";
	}
}
