package com.rk.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;

	private String u_name;

	@OneToMany(targetEntity = Expense.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "uid", referencedColumnName = "uid")
	@JsonManagedReference
	private Set<Expense> expense;

	@Column(unique = true)
	private String email;

	private String password;

	@Column(unique = true)
	private long mob_no;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Balance balance;

	public void setBalance(Balance balance) {
		this.balance = balance;

	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public Set<Expense> getExpense() {
		return expense;
	}

	public void setExpense(Set<Expense> expense) {
		this.expense = expense;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMob_no() {
		return mob_no;
	}

	public void setMob_no(long mob_no) {
		this.mob_no = mob_no;
	}

	public User(String u_name, Set<Expense> expense, String email, String password, long mob_no) {
		this.u_name = u_name;
		this.expense = expense;
		this.email = email;
		this.password = password;
		this.mob_no = mob_no;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", u_name=" + u_name + ", expense=" + expense + ", email=" + email + ", password="
				+ password + ", mob_no=" + mob_no + "]";
	}

}
