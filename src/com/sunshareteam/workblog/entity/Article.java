package com.sunshareteam.workblog.entity;

import java.sql.Blob;
import java.util.Date;

public class Article {
	private Integer articleid;
    private Date createdate;
    private Date modifydate;
    private Integer modifyuser;
    private String img;
    private String content;
    private Integer author;
    private Integer commentnum;
    private Integer categoty;
    private String title;
    private String summary;
	private Boolean state;
	      public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getAuthor() {
		return author;
	}
	public void setAuthor(Integer author) {
		this.author = author;
	}
	public Integer getCommentnum() {
		return commentnum;
	}
	public void setCommentnum(Integer commentnum) {
		this.commentnum = commentnum;
	}
	public Integer getCategoty() {
		return categoty;
	}
	public void setCategoty(Integer categoty) {
		this.categoty = categoty;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
    public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Article [articleid=" + articleid + ", createdate=" + createdate + ", modifydate=" + modifydate
				+ ", modifyuser=" + modifyuser + ", img=" + img + ", content=" + content + ", author=" + author
				+ ", commentnum=" + commentnum + ", categoty=" + categoty + ", title=" + title + ", summary=" + summary
				+ ", state=" + state + "]";
	}
}
