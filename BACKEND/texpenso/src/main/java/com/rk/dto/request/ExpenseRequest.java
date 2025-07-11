package com.rk.dto.request;

import java.sql.Date;

import com.rk.util.Status;

public class ExpenseRequest {
	private Status Status;
	private String Description;
	private double amount;
	private Date date;

	public Status getStatus() {
		return Status;
	}

	public void setStatus(Status status) {
		Status = status;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ExpenseRequest(com.rk.util.Status status, String description, double amount, Date date) {
		super();
		Status = status;
		Description = description;
		this.amount = amount;
		this.date = date;
	}

	public ExpenseRequest() {
		super();
	}

	@Override
	public String toString() {
		return "ExpenseRequest [Status=" + Status + ", Description=" + Description + ", amount=" + amount + ", date="
				+ date + "]";
	}

}
