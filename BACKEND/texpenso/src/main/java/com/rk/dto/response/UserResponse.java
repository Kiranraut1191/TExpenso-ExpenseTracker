package com.rk.dto.response;

import org.springframework.stereotype.Component;

import com.rk.util.Status;

@Component
public class UserResponse {
	private Object reponse;
	private Status status;

	public Object getReponse() {
		return reponse;
	}

	public void setReponse(Object reponse) {
		this.reponse = reponse;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public UserResponse(Object reponse, Status status) {
		super();
		this.reponse = reponse;
		this.status = status;
	}

	public UserResponse() {
		super();
	}

	@Override
	public String toString() {
		return "UserResponse [reponse=" + reponse + ", status=" + status + "]";
	}

}
