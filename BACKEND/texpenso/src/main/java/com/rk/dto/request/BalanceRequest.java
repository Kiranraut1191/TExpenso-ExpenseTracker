package com.rk.dto.request;

import org.springframework.stereotype.Component;

@Component
public class BalanceRequest {
	private int uid;
	private double balance;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double budget) {
		this.balance = budget;
	}

	public BalanceRequest(int uid, double budget) {
		super();
		this.uid = uid;
		this.balance = budget;
	}

	public BalanceRequest() {
		super();
	}

	@Override
	public String toString() {
		return "BudgetRequest [uid=" + uid + ", balance=" + balance + "]";
	}

}
