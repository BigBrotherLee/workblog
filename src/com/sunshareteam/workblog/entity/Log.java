package com.sunshareteam.workblog.entity;

import java.util.Date;

public class Log {
	private Integer logid;
    private Date createdate;
	private String logcontent;
	public Integer getLogid() {
		return logid;
	}
	public void setLogid(Integer logid) {
		this.logid = logid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getLogcontent() {
		return logcontent;
	}
	public void setLogcontent(String logcontent) {
		this.logcontent = logcontent;
	}
	@Override
	public String toString() {
		return "Log [logid=" + logid + ", createdate=" + createdate + ", logcontent=" + logcontent + "]";
	}
}
