package com.sunshareteam.workblog.web;

public class ResultDemo {
	private String message;
	private String url;
	private int success;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	@Override
	public String toString() {
		return "ResultDemo [message=" + message + ", url=" + url + ", success=" + success + "]";
	}
	
}
