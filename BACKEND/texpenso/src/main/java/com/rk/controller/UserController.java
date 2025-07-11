package com.rk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rk.dto.request.UserLoginRequest;
import com.rk.dto.request.UserRequest;
import com.rk.dto.response.UserResponse;
import com.rk.entity.User;
import com.rk.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserRequest request) {
		try {
			UserResponse response = service.register(request);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed: " + e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<UserResponse> login(@RequestBody UserLoginRequest request) {
		return service.login(request);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<UserResponse> updateCustomer(@PathVariable int id, @RequestBody UserRequest request) {
		return new ResponseEntity<>(service.updateCustomer(id, request), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
		return ResponseEntity.ok(service.deleteCustomer(id));
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable int id) {
		return new ResponseEntity<>(service.getuserById(id), HttpStatus.OK);
	}

	// Returns only relevant flat user fields for Angular to render
	@GetMapping("/all")
	public ResponseEntity<List<Map<String, Object>>> getAllUsers() {
		List<User> users = service.getAllUsers();

		List<Map<String, Object>> simplifiedUsers = users.stream().map(user -> {
			Map<String, Object> map = new HashMap<>();
			map.put("uid", user.getUid());
			map.put("u_name", user.getU_name());
			map.put("email", user.getEmail());
			map.put("mob_no", user.getMob_no());
			return map;
		}).collect(Collectors.toList());

		return ResponseEntity.ok(simplifiedUsers);
	}
}
