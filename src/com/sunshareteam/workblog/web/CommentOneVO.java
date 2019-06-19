package com.sunshareteam.workblog.web;

import java.util.Date;

public class CommentOneVO {
	@Override
	public String toString() {
		return "CommentOneVO [comment_one_id=" + comment_one_id + ", pic=" + pic + ", author=" + author + ", title="
				+ title + ", username=" + username + ", content=" + content + ", createdate=" + createdate
				+ ", articleid=" + articleid + "]";
	}
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	private Integer comment_one_id;
    private String pic;
	private String author;
	private String title;
    private String username;
	private String content;
	private Date createdate;
	private Integer articleid;
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}	
}
