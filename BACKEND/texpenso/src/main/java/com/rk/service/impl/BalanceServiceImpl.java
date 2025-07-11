package com.rk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.Balance;
import com.rk.entity.User;
import com.rk.repositery.BalanceRepositery;
import com.rk.repositery.UserRepositery;
import com.rk.service.BalanceService;

@Service
public class BalanceServiceImpl implements BalanceService {

	@Autowired
	private BalanceRepositery repo;

	@Autowired
	private UserRepositery urepo;

	@Override
	public double getCurrentBalance(int id) {
		try {
			User user = urepo.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));

			Balance balance = repo.findByUser(user);
			if (balance == null) {
				throw new IllegalArgumentException("Balance not found for user with id: " + id);
			}

			return balance.getBalance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to fetch current balance: " + e.getMessage());
		}
	}

	// This method properly fetches user and avoids duplicates
	public String initBalance(int uid) {
		try {
			User user = urepo.findById(uid)
					.orElseThrow(() -> new IllegalArgumentException("User not found with id: " + uid));

			// Avoid duplicate balance creation
			Balance existing = repo.findByUser(user);
			if (existing != null) {
				return "Balance already exists for this user.";
			}

			Balance balance = new Balance();
			balance.setUserid(user);
			balance.setBalance(0); // Optional: initial balance

			repo.save(balance);
			return "Balance created successfully.";

		} catch (Exception e) {
			e.printStackTrace();
			return "Error creating balance: " + e.getMessage();
		}
	}

}
