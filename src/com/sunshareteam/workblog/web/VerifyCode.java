package com.sunshareteam.workblog.web;


import java.time.LocalDateTime;

public class VerifyCode {
	private String code;
	private LocalDateTime exdate;
	
	public VerifyCode(String code, LocalDateTime exdate) {
		super();
		this.code = code;
		this.exdate = exdate;
	}
	
	public VerifyCode(String code, LocalDateTime exdate) {
		super();
		this.code = code;
		this.exdate = exdate;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public LocalDateTime getExdate() {
		return exdate;
	}
	public void setExdate(LocalDateTime exdate) {
		this.exdate = exdate;
	}
	public void setExdate(int seconds) {
		this.exdate=LocalDateTime.now().plusSeconds(seconds);
	}
	
}
