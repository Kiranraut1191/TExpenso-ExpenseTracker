package com.rk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rk.dto.request.BalanceRequest;
import com.rk.dto.request.GetByDateRequest;
import com.rk.entity.Expense;
import com.rk.service.BalanceService;

@RestController
@RequestMapping("/api/balance")
public class BalanceController {

	@Autowired
	private BalanceService service;

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public double getCurrentBalance(@PathVariable int id) {
		return service.getCurrentBalance(id);

	}

}
