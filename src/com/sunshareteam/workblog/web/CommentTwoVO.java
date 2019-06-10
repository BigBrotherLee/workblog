package com.sunshareteam.workblog.web;

import java.util.Date;

public class CommentTwoVO {
	private Integer comment_two_id;
	private String usernameone;
	private String contentone;
	private String usernametwo;
	private String contenttwo;
	private Date createdate;
	public Integer getComment_two_id() {
		return comment_two_id;
	}
	public void setComment_two_id(Integer comment_two_id) {
		this.comment_two_id = comment_two_id;
	}
	public String getUsernameone() {
		return usernameone;
	}
	public void setUsernameone(String usernameone) {
		this.usernameone = usernameone;
	}
	public String getContentone() {
		return contentone;
	}
	public void setContentone(String contentone) {
		this.contentone = contentone;
	}
	public String getUsernametwo() {
		return usernametwo;
	}
	public void setUsernametwo(String usernametwo) {
		this.usernametwo = usernametwo;
	}
	public String getContenttwo() {
		return contenttwo;
	}
	public void setContenttwo(String contenttwo) {
		this.contenttwo = contenttwo;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "CommentTwoVO [comment_two_id=" + comment_two_id + ", usernameone=" + usernameone + ", contentone="
				+ contentone + ", usernametwo=" + usernametwo + ", contenttwo=" + contenttwo + ", createdate="
				+ createdate + "]";
	}
}
