package web.z;

import java.util.Date;

/**
 * 
 * 用来存放私信信息------JavaBean  
 *
 */
public class TMessage {
	private Long id;
	private String suser;
	private String tuser;
	private String content;
	private Date time;
	
	
	public String getSuser() {
		return suser;
	}
	public void setSuser(String suser) {
		this.suser = suser;
	}
	public String getTuser() {
		return tuser;
	}
	public void setTuser(String tuser) {
		this.tuser = tuser;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
