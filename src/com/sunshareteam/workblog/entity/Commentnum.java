package com.sunshareteam.workblog.entity;

public class Commentnum {
	@Override
	public String toString() {
		return "Commentnum [commentnum=" + commentnum + ", articleid="
				+ articleid + "]";
	}
	public Integer getArticleid() {
		return articleid;
	}

	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}

	public Integer getCommentnum() {
		return commentnum;
	}

	public void setCommentnum(Integer commentnum) {
		this.commentnum = commentnum;
	}

	private Integer commentnum;
	private Integer articleid;
}
