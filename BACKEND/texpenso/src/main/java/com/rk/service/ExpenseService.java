package com.rk.service;

import java.sql.Date;
import java.util.List;
import com.rk.dto.request.ExpenseRequest;
import com.rk.dto.request.GetByDateRequest;
import com.rk.entity.Expense;

public interface ExpenseService {

	String getpenny(ExpenseRequest request, int id);

	String sendpenny(ExpenseRequest request, int id);

	List<Expense> getAllExpenses(int uid);

	List<Expense> sendAllExpenses(int uid);

	List<Expense> getAllExpensesByDate(int id, Date startDate, Date endDate);

}
