package com.sunshareteam.workblog.web;

import java.util.Date;

public class ArticleVO {
	private Integer articleid;
	private Integer authorid;
	private String authorname;
	private String title;
	private String summary;
	private String categotyname;
	private Integer categotyid;
	private Date createdate;
	private String img;
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	public Integer getAuthorid() {
		return authorid;
	}
	public void setAuthorid(Integer authorid) {
		this.authorid = authorid;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
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
	public String getCategotyname() {
		return categotyname;
	}
	public void setCategotyname(String categotyname) {
		this.categotyname = categotyname;
	}
	public Integer getCategotyid() {
		return categotyid;
	}
	public void setCategotyid(Integer categotyid) {
		this.categotyid = categotyid;
	}
	@Override
	public String toString() {
		return "ArticleVO [articleid=" + articleid + ", authorid=" + authorid + ", authorname=" + authorname
				+ ", title=" + title + ", summary=" + summary + ", categotyname=" + categotyname + ", categotyid="
				+ categotyid + ", createdate=" + createdate + ", img=" + img + "]";
	}
	
}
