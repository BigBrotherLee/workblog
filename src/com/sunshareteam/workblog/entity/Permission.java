package com.sunshareteam.workblog.entity;

import java.util.Date;

public class Permission {

	private Integer permissionid;
	private String permissionname;
    private String permissiondetail;
    private Date createdate;
    private Date modifydate;
    private Integer modifyuser;
    private String Permissioncode;
    private String resource;
    private String menu;
	public Integer getPermissionid() {
		return permissionid;
	}
	public void setPermissionid(Integer permissionid) {
		this.permissionid = permissionid;
	}
	public String getPermissionname() {
		return permissionname;
	}
	public void setPermissionname(String permissionname) {
		this.permissionname = permissionname;
	}
	public String getPermissiondetail() {
		return permissiondetail;
	}
	public void setPermissiondetail(String permissiondetail) {
		this.permissiondetail = permissiondetail;
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
		return "Permission [permissionid=" + permissionid + ", permissionname=" + permissionname + ", permissiondetail="
				+ permissiondetail + ", createdate=" + createdate + ", modifydate=" + modifydate + ", modifyuser="
				+ modifyuser + ", Permissioncode=" + Permissioncode + ", resource=" + resource + ", menu=" + menu + "]";
	}

}
