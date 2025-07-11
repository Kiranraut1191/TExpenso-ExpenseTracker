package com.rk.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rk.entity.Balance;
import com.rk.entity.User;

@Repository
public interface BalanceRepositery extends JpaRepository<Balance, Integer> {

	Balance findByUser(User user);
}
