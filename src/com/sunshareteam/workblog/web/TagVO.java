package com.sunshareteam.workblog.web;

public class TagVO {
	 private Integer tagid;
	 private String tagtitle;
	 private String username;
	 @Override
		public String toString() {
			return "TagControllerVO [tagid=" + tagid + ", tagtitle=" + tagtitle + ", username=" + username + "]";
		}
		public Integer getTagid() {
			return tagid;
		}
		public void setTagid(Integer tagid) {
			this.tagid = tagid;
		}
		public String getTagtitle() {
			return tagtitle;
		}
		public void setTagtitle(String tagtitle) {
			this.tagtitle = tagtitle;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
}
