package com.sunshareteam.workblog.entity;

import java.util.Date;

public class CommentOne {
	private Integer comment_one_id;
    private Integer author;
    private String content;
    private Date createdate;
    private Integer createuser;
    private Date modifydate;
    private Integer modifyuser;
    private Integer articleid;

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
	public Integer getComment_one_id() {
		return comment_one_id;
	}
	public void setComment_one_id(Integer comment_one_id) {
		this.comment_one_id = comment_one_id;
	}
	@Override
	public String toString() {
		return "CommentOne [comment_one_id=" + comment_one_id + ", author=" + author + ", content=" + content
				+ ", createdate=" + createdate + ", createuser=" + createuser + ", modifydate=" + modifydate
				+ ", modifyuser=" + modifyuser + ", articleid=" + articleid + "]";
	}
}
