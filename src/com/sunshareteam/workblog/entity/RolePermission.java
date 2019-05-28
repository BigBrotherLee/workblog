package com.sunshareteam.workblog.entity;

public class RolePermission {
    private Integer rolepermissionid;
	private Integer permissionid;
	private Integer roleid;
	public Integer getRolepermissionid() {
		return rolepermissionid;
	}
	public void setRolepermissionid(Integer rolepermissionid) {
		this.rolepermissionid = rolepermissionid;
	}
	public Integer getPermissionid() {
		return permissionid;
	}
	public void setPermissionid(Integer permissionid) {
		this.permissionid = permissionid;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	@Override
	public String toString() {
		return "RolePermission [rolepermissionid=" + rolepermissionid + ", permissionid=" + permissionid + ", roleid="
				+ roleid + "]";
	}
}
