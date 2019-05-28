package com.sunshareteam.workblog.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class admin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3699180590966324088L;
    private String id;
    private String usercode;
    private String username;
    private String password;
    private String salt;
    private String locked;
}
