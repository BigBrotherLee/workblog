package com.sunshareteam.workblog.entity;

import java.sql.Blob;
import java.util.Date;

public class User {
	private Integer userid;
    private String username;
    private String paasword;
    private Date createdate;
    private Date modifydate;
    private Integer modifyuser;
    private String phone;
    private String email;
    private String pic;
    private String autograph;
    private Blob deleted;
      public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPaasword() {
		return paasword;
	}
	public void setPaasword(String paasword) {
		this.paasword = paasword;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getAutograph() {
		return autograph;
	}
	public void setAutograph(String autograph) {
		this.autograph = autograph;
	}
	public Blob getDeleted() {
		return deleted;
	}
	public void setDeleted(Blob deleted) {
		this.deleted = deleted;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", paasword=" + paasword + ", createdate="
				+ createdate + ", modifydate=" + modifydate + ", modifyuser=" + modifyuser + ", phone=" + phone
				+ ", email=" + email + ", pic=" + pic + ", autograph=" + autograph + ", deleted=" + deleted + "]";
	}     
}
