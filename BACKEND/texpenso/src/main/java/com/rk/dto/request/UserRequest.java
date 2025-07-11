package com.rk.dto.request;

import org.springframework.stereotype.Component;

@Component
public class UserRequest {
	private String u_name;
	private String email;
	private String password;
	private long mob_no;

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMob_no() {
		return mob_no;
	}

	public void setMob_no(long mob_no) {
		this.mob_no = mob_no;
	}

	public UserRequest(String u_name, String email, String password, long mob_no) {
		super();
		this.u_name = u_name;
		this.email = email;
		this.password = password;
		this.mob_no = mob_no;
	}

	public UserRequest() {
		super();
	}

	@Override
	public String toString() {
		return "UserRequest [u_name=" + u_name + ", email=" + email + ", password=" + password + ", mob_no=" + mob_no
				+ "]";
	}

}
