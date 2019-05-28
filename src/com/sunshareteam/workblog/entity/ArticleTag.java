package com.sunshareteam.workblog.entity;

public class ArticleTag {
	private Integer articletagid;
	private Integer articleid;
	private Integer tagid;
	public Integer getArticletagid() {
		return articletagid;
	}
	public void setArticletagid(Integer articletagid) {
		this.articletagid = articletagid;
	}
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	public Integer getTagid() {  
		return tagid;
	}
	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}
	@Override
	public String toString() {
		return "ArticleTag [articletagid=" + articletagid + ", articleid=" + articleid + ", tagid=" + tagid + "]";
	}
}
