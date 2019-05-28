package com.sunshareteam.workblog.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5350559997843641294L;
    private String id;
    private String name;
    private String available;
}
