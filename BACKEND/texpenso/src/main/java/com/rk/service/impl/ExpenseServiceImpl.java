package com.rk.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.dto.request.ExpenseRequest;
import com.rk.dto.request.GetByDateRequest;
import com.rk.entity.Balance;
import com.rk.entity.Expense;
import com.rk.entity.User;
import com.rk.repositery.BalanceRepositery;
import com.rk.repositery.ExpenseRepositery;
import com.rk.repositery.UserRepositery;
import com.rk.service.ExpenseService;
import com.rk.util.Status;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private BalanceRepositery balrepo;

	@Autowired
	private ExpenseRepositery repo;
	@Autowired
	private UserRepositery userrepo;

	@Override
	public String getpenny(ExpenseRequest request, int id) {
		try {
			Expense expense = new Expense();
			expense.setStatus(Status.GET);
			expense.setAmount(request.getAmount());
			expense.setDescription(request.getDescription());
			expense.setDate(request.getDate());

			User user = userrepo.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("User not found for id: " + id));
			expense.setUser(user);

			repo.save(expense);

			Balance balance = balrepo.findByUser(user);
			if (balance == null) {
				throw new IllegalArgumentException("Balance not found for user id: " + id);
			}

			balance.setBalance((int) (balance.getBalance() + request.getAmount()));
			balrepo.save(balance);

			return "Amount: " + request.getAmount() + " added successfully";

		} catch (Exception e) {
			e.printStackTrace();
			return "Something went wrong!!";
		}
	}

	@Override
	public String sendpenny(ExpenseRequest request, int id) {
		try {
			// Create and set up Expense
			Expense expense = new Expense();
			expense.setStatus(Status.SEND);
			expense.setAmount(request.getAmount());
			expense.setDescription(request.getDescription());
			expense.setDate(request.getDate());

			// Fetch User
			User user = userrepo.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("User not found for id: " + id));
			expense.setUser(user);

			// Save Expense
			repo.save(expense);

			// Update Balance
			Balance balance = balrepo.findByUser(user);
			if (balance == null) {
				throw new IllegalArgumentException("Balance not found for user id: " + id);
			}

			balance.setBalance((int) (balance.getBalance() - request.getAmount()));
			balrepo.save(balance);

			return "Amount: " + request.getAmount() + " deducted successfully";

		} catch (Exception e) {
			e.printStackTrace();
			return "Something went wrong!!";
		}
	}

	@Override
	public List<Expense> getAllExpenses(int uid) {
		List<Expense> expenses = repo.findByUserUid(uid);
		if (expenses.isEmpty()) {
			return null; // or better, return Collections.emptyList();
		}
		return expenses;
	}

	@Override
	public List<Expense> sendAllExpenses(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Expense> getAllExpensesByDate(int id, Date startDate, Date endDate) {
		// TODO Auto-generated method stub

		return repo.findExpensesBetweenDates(id, startDate, endDate);
	}
}