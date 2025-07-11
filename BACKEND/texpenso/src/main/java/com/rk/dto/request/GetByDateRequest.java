package com.rk.dto.request;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class GetByDateRequest {
	private Date startdate;
	private Date enddate;

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public GetByDateRequest(Date startdate, Date enddate) {
		super();
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public GetByDateRequest() {
		super();
	}

	@Override
	public String toString() {
		return "GetByDateRequest [startdate=" + startdate + ", enddate=" + enddate + "]";
	}

}
