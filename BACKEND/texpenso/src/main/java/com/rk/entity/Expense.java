package com.rk.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rk.util.Status;

@Entity
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;

	@Enumerated(EnumType.STRING)
	private Status status;

	private String Description;
	private double amount;
	private Date date;

	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "uid", referencedColumnName = "uid")
	@JsonBackReference
	private User user;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Expense(int eid, Status status, String description, double amount, Date date, User user) {
		super();
		this.eid = eid;
		this.status = status;
		this.Description = description;
		this.amount = amount;
		this.date = date;
		this.user = user;
	}

	public Expense() {
		super();
	}

	@Override
	public String toString() {
		return "Expense [eid=" + eid + ", Description=" + Description + ", amount=" + amount + ", date=" + date
				+ ", user=" + user + "]";
	}

}
