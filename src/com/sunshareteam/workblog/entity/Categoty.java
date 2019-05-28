package com.sunshareteam.workblog.entity;

import java.util.Date;

public class Categoty {
	private Integer categotyid;
    private Date createdate;
    private Date modifydate;
    private Integer modifyuser;
    private String categotytitle;
    private String categotydetail;
    private String img;
	public Integer getCategotyid() {
		return categotyid;
	}
	public void setCategotyid(Integer categotyid) {
		this.categotyid = categotyid;
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
	public String getCategotytitle() {
		return categotytitle;
	}
	public void setCategotytitle(String categotytitle) {
		this.categotytitle = categotytitle;
	}
	public String getCategotydetail() {
		return categotydetail;
	}
	public void setCategotydetail(String categotydetail) {
		this.categotydetail = categotydetail;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Categoty [categotyid=" + categotyid + ", createdate=" + createdate + ", modifydate=" + modifydate
				+ ", modifyuser=" + modifyuser + ", categotytitle=" + categotytitle + ", categotydetail="
				+ categotydetail + ", img=" + img + "]";
	}
}
