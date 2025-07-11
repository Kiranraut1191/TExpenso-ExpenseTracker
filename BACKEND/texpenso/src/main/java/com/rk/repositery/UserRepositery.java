package com.rk.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rk.entity.User;

@Repository
public interface UserRepositery extends JpaRepository<User, Integer> {
	User findByEmailAndPassword(String email, String password);

	User findByEmail(String email);

	boolean existsByEmail(String email);
}
