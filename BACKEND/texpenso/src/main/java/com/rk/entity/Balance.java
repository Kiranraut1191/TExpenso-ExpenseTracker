package com.rk.entity;

import jakarta.persistence.*;

@Entity
public class Balance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bid;

	private int balance;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid", referencedColumnName = "uid")
	private User user;

	// Getters and Setters
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public User getUserid() {
		return user;
	}

	public void setUserid(User i) {
		this.user = i;
	}
}
