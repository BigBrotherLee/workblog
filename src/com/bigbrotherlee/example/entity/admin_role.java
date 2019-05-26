package com.bigbrotherlee.example.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class admin_role implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -990831259168037947L;
	private String id;
    private String userid;
    private String roleid;
}
