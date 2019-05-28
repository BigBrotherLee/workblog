package com.sunshareteam.workblog.entity;

import java.util.Date;

public class Tag {
    private Integer tagid;
    private Date createdate;
    private Integer createuser;
    private Date modifydate;
    private Integer modifyuser;
    private String tagtitle;
	public Integer getTagid() {
		return tagid;
	}
	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Integer getCreateuser() {
		return createuser;
	}
	public void setCreateuser(Integer createuser) {
		this.createuser = createuser;
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
	public String getTagtitle() {
		return tagtitle;
	}
	public void setTagtitle(String tagtitle) {
		this.tagtitle = tagtitle;
	}
	@Override
	public String toString() {
		return "Tag [tagid=" + tagid + ", createdate=" + createdate + ", createuser=" + createuser + ", modifydate="
				+ modifydate + ", modifyuser=" + modifyuser + ", tagtitle=" + tagtitle + "]";
	}
}
