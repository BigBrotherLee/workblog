package com.sunshareteam.workblog.entity;

import java.util.Date;

public class CommentTwo {
	private Integer comment_two_id;
    private Integer author;
    private String content;
    private Date createdate;
    private Integer createuser;
    private Date modifydate;
    private Integer modifyuser;
    private Integer oneid;

	public Integer getAuthor() {
		return author;
	}
	public void setAuthor(Integer author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Integer getOneid() {
		return oneid;
	}
	public void setOneid(Integer oneid) {
		this.oneid = oneid;
	}
	public Integer getComment_two_id() {
		return comment_two_id;
	}
	public void setComment_two_id(Integer comment_two_id) {
		this.comment_two_id = comment_two_id;
	}
	@Override
	public String toString() {
		return "CommentTwo [comment_two_id=" + comment_two_id + ", author=" + author + ", content=" + content
				+ ", createdate=" + createdate + ", createuser=" + createuser + ", modifydate=" + modifydate
				+ ", modifyuser=" + modifyuser + ", oneid=" + oneid + "]";
	}
}
