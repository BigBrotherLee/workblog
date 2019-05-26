package com.bigbrotherlee.example.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class role_promission implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8591016472712837229L;
    private String id;
    private String roleid;
    private String permissionid;
}
