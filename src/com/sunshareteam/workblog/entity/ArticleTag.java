package com.sunshareteam.workblog.entity;

public class ArticleTag {
	private Integer article_tag_id;
	private Integer articleid;
	private Integer tagid;
	public Integer getArticle_tag_id() {
		return article_tag_id;
	}
	public void setArticle_tag_id(Integer article_tag_id) {
		this.article_tag_id = article_tag_id;
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
		return "ArticleTag [article_tag_id=" + article_tag_id + ", articleid=" + articleid + ", tagid=" + tagid + "]";
	}
}
