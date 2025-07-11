package com.rk.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rk.dto.request.UserLoginRequest;
import com.rk.dto.request.UserRequest;
import com.rk.dto.response.UserResponse;
import com.rk.entity.User;

public interface UserService {
	UserResponse register(UserRequest request);

	ResponseEntity<UserResponse> login(UserLoginRequest request);

	UserResponse updateCustomer(int id, UserRequest request);

	String deleteCustomer(int id);

	UserResponse getuserById(int id);

	List<User> getAllUsers(); // ✅ Added
}
