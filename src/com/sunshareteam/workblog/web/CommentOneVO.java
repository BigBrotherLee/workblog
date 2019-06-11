package com.sunshareteam.workblog.web;

import java.util.Date;

public class CommentOneVO {
	private Integer comment_one_id;
	private String author;
	private String title;
    private String username;
	private String content;
	private Date createdate;
	public Integer getComment_one_id() {
		return comment_one_id;
	}
	public void setComment_one_id(Integer comment_one_id) {
		this.comment_one_id = comment_one_id;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "CommentOneVO [comment_one_id=" + comment_one_id + ", content=" + content + ", createdate=" + createdate
				+ ", username=" + username + ", title=" + title + ", author=" + author + "]";
	}
	
	
}
