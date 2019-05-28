package com.sunshareteam.workblog.entity;

import java.util.Date;

public class Role {
	private Integer roleid;
    private String rolename;
    private String roletail;
    private Date createdate;
    private Date modifydate;
    private Integer modifyuser;
	  public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRoletail() {
		return roletail;
	}
	public void setRoletail(String roletail) {
		this.roletail = roletail;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getModifydate() {
		return modifydate;
	}
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	public Integer getModifyuser() {
		return modifyuser;
	}
	public void setModifyuser(Integer modifyuser) {
		this.modifyuser = modifyuser;
	}
	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", rolename=" + rolename + ", roletail=" + roletail + ", createdate="
				+ createdate + ", modifydate=" + modifydate + ", modifyuser=" + modifyuser + "]";
	}
}
