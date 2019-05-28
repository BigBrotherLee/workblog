package com.sunshareteam.workblog.entity;

import java.util.Date;

public class CommentOne {
	private Integer commentoneid;
    private Integer author;
    private String content;
    private Date createdate;
    private Integer createuser;
    private Date modifydate;
    private Integer modifyuser;
    private Integer articleid;
	public Integer getCommentoneid() {
		return commentoneid;
	}
	public void setCommentoneid(Integer commentoneid) {
		this.commentoneid = commentoneid;
	}
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
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	@Override
	public String toString() {
		return "CommentOne [commentoneid=" + commentoneid + ", author=" + author + ", content=" + content
				+ ", createdate=" + createdate + ", createuser=" + createuser + ", modifydate=" + modifydate
				+ ", modifyuser=" + modifyuser + ", articleid=" + articleid + "]";
	}
}
