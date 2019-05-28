package com.sunshareteam.workblog.entity;

import java.util.Date;

public class Permission {
	private Integer Permissionid;
    private String Permissionname;
    private String Permissiondetail;
    private Date createdate;
    private Date modifydate;
    private Integer modifyuser;
    private String Permissioncode;
    private String resource;
    private String menu;
	 public Integer getPermissionid() {
		return Permissionid;
	}
	public void setPermissionid(Integer permissionid) {
		Permissionid = permissionid;
	}
	public String getPermissionname() {
		return Permissionname;
	}
	public void setPermissionname(String permissionname) {
		Permissionname = permissionname;
	}
	public String getPermissiondetail() {
		return Permissiondetail;
	}
	public void setPermissiondetail(String permissiondetail) {
		Permissiondetail = permissiondetail;
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
	public String getPermissioncode() {
		return Permissioncode;
	}
	public void setPermissioncode(String permissioncode) {
		Permissioncode = permissioncode;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	@Override
	public String toString() {
		return "Permission [Permissionid=" + Permissionid + ", Permissionname=" + Permissionname + ", Permissiondetail="
				+ Permissiondetail + ", createdate=" + createdate + ", modifydate=" + modifydate + ", modifyuser="
				+ modifyuser + ", Permissioncode=" + Permissioncode + ", resource=" + resource + ", menu=" + menu + "]";
	}
}
