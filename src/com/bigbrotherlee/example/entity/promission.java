package com.bigbrotherlee.example.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class promission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3647912371809677451L;
    private Long id;
    private String name;
    private String type;
    private String url;
    private String percode;
    private Long parentid;
    private String parentids;
    private String sortstring;
    private String available;

}
