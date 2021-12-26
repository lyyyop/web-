package web.z;

import java.util.Date;

/**
 * 
 * 用来存放用户信息------JavaBean
 *
 */
public class TUser {
	private Long id;
	private String username;
	private String password;
	private String sign;
	private String sex;
	private String age;
	private String ip;
	private Date regTime;
	private Boolean kpl;// 用户状态
	// 返回用户状态

	public String getKplCn() {
		if (this.kpl) {
			return "kp";
		} else {
			return "pl";
		}
	}

	public void setKpl(Boolean kpl) {
		this.kpl = kpl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getKpl() {
		return kpl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
