package com.sunshareteam.workblog.entity;

import java.util.Date;

public class Link {
	private Integer linkid;
    private String linktitle;
    private String linkimg;
    private String linkaddress;
    private Date modifydate;
    private Integer modifyuser;
	public Integer getLinkid() {
		return linkid;
	}
	public void setLinkid(Integer linkid) {
		this.linkid = linkid;
	}
	public String getLinktitle() {
		return linktitle;
	}
	public void setLinktitle(String linktitle) {
		this.linktitle = linktitle;
	}
	public String getLinkimg() {
		return linkimg;
	}
	public void setLinkimg(String linkimg) {
		this.linkimg = linkimg;
	}
	public String getLinkaddress() {
		return linkaddress;
	}
	public void setLinkaddress(String linkaddress) {
		this.linkaddress = linkaddress;
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
		return "Link [linkid=" + linkid + ", linktitle=" + linktitle + ", linkimg=" + linkimg + ", linkaddress="
				+ linkaddress + ", modifydate=" + modifydate + ", modifyuser=" + modifyuser + "]";
	}
}
