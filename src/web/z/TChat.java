package web.z;

import java.util.Date;

/**
 * 
 * 用来存放论坛信息------JavaBean  
 *
 */
public class TChat {
	private Long id;
	private String user;
	private String content;
	private Date time;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
