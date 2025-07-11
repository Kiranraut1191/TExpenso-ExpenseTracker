package com.rk.repositery;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rk.entity.Expense;

@Repository
public interface ExpenseRepositery extends JpaRepository<Expense, Integer> {

	List<Expense> findByUserUid(int uid);

	@Query(value = "SELECT e.eid, e.description, e.amount, e.date, e.uid, e.status FROM expense e WHERE e.uid = ?1 AND e.date BETWEEN ?2 AND ?3", nativeQuery = true)
	List<Expense> findExpensesBetweenDates(int uid, Date startDate, Date endDate);

}
