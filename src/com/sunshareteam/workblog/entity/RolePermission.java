package com.sunshareteam.workblog.entity;

public class RolePermission {
    private Integer role_permission_id;
	private Integer permissionid;
	private Integer roleid;

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
	   public Integer getRole_permission_id() {
			return role_permission_id;
		}
		public void setRole_permission_id(Integer role_permission_id) {
			this.role_permission_id = role_permission_id;
		}
		@Override
		public String toString() {
			return "RolePermission [role_permission_id=" + role_permission_id + ", permissionid=" + permissionid
					+ ", roleid=" + roleid + "]";
		}
}
