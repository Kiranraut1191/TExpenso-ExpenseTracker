package com.rk.controller;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rk.dto.request.ExpenseRequest;
import com.rk.dto.request.GetByDateRequest;
import com.rk.entity.Expense;
import com.rk.service.ExpenseService;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
	@Autowired
	ExpenseService service;

	@RequestMapping(value = "/penny/get/{uid}", method = RequestMethod.POST)
	public String getpenny(@RequestBody ExpenseRequest request, @PathVariable int uid) {
		String msg = service.getpenny(request, uid);
		return msg;

	}

	@RequestMapping(value = "/penny/send/{uid}", method = RequestMethod.POST)
	public String sendpenny(@RequestBody ExpenseRequest request, @PathVariable int uid) {
		String msg = service.sendpenny(request, uid);
		return msg;

	}

	@RequestMapping(value = "/getall/{uid}", method = RequestMethod.GET)
	public List<Expense> getAllExpenses(@PathVariable int uid) {
		List<Expense> expenses = service.getAllExpenses(uid);
		// Filter expenses with status 'get'

		return expenses;
	}

	@RequestMapping(value = "/sendall/{uid}", method = RequestMethod.GET)
	public List<Expense> sendAllExpenses(@PathVariable int uid) {
		List<Expense> expenses = service.sendAllExpenses(uid);
		// Filter expenses with status 'send'

		return expenses;
	}

	@RequestMapping(value = "/getbyDate/{id}/{StartDate}/{EndDate}", method = RequestMethod.GET)
	public List<Expense> getCurrentBalance(@PathVariable int id, @PathVariable long StartDate,
			@PathVariable long EndDate) {

		// Convert timestamps (in ms) to java.sql.Date
		java.sql.Date start = new java.sql.Date(StartDate);
		java.sql.Date end = new java.sql.Date(EndDate);

		return service.getAllExpensesByDate(id, start, end);
	}

}
