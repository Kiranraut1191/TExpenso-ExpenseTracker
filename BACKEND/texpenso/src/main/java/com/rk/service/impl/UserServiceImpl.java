package com.rk.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rk.dto.request.UserLoginRequest;
import com.rk.dto.request.UserRequest;
import com.rk.dto.response.UserResponse;
import com.rk.entity.Expense;
import com.rk.entity.User;
import com.rk.repositery.ExpenseRepositery;
import com.rk.repositery.UserRepositery;
import com.rk.service.UserService;
import com.rk.util.Status;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepositery repo;

	@Autowired
	private BalanceServiceImpl balanceServiceImpl;

	public User ConvertedCoustomer(UserRequest request) {
		User customer = new User();
		customer.setU_name(request.getU_name());
		customer.setEmail(request.getEmail());
		customer.setMob_no(request.getMob_no());
		customer.setPassword(request.getPassword());
		return repo.save(customer);
	}

	private UserResponse covertedToResponseFromUser(User user) {
		UserResponse cr = new UserResponse();
		cr.setReponse(user);
		cr.setStatus(Status.SUCCESS);
		return cr;
	}

	@Override
	public ResponseEntity<UserResponse> login(UserLoginRequest request) {
		User user = repo.findByEmailAndPassword(request.getEmail(), request.getPassword());
		if (user != null) {
			return ResponseEntity.ok(covertedToResponseFromUser(user));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new UserResponse(Status.FAIL, null));
		}
	}

	@Override
	public UserResponse register(UserRequest request) {
		User emailExists = repo.findByEmail(request.getEmail());
		if (emailExists == null) {
			User customer = ConvertedCoustomer(request);
			balanceServiceImpl.initBalance(customer.getUid());
			return covertedToResponseFromUser(customer);
		}
		UserResponse fail = new UserResponse();
		fail.setStatus(Status.FAIL);
		return fail;
	}

	@Override
	public UserResponse updateCustomer(int id, UserRequest request) {
		try {
			User user = repo.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
			user.setEmail(request.getEmail());
			user.setMob_no(request.getMob_no());
			user.setPassword(request.getPassword());
			user.setU_name(request.getU_name());
			repo.save(user);
			return covertedToResponseFromUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return new UserResponse(Status.FAIL, null);
		}
	}

	@Autowired
	private ExpenseRepositery expenseRepo;

	@Override
	public String deleteCustomer(int id) {
		try {
			User user = repo.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
			repo.delete(user);
			return "Record Deleted Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Something Went Wrong While Deleting The Record";
		}
	}


	@Override
	public UserResponse getuserById(int id) {
		Optional<User> userOptional = repo.findById(id);
		return userOptional.map(this::covertedToResponseFromUser).orElse(null);
	}

	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}
}
