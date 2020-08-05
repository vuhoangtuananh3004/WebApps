package com.web.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name ="UserAccount")
public class UserAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name ="userid")
	private int userId;
	@Column(name = "fname")
	private String fname;
	@Column(name = "lname")
	private String lname;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "sex")
	private String sex;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@OneToMany (fetch = FetchType.LAZY)
	private List<Student> studentList = new ArrayList<>();
	public UserAccount() {
		super();
	}
	
	public UserAccount(int userId, String fname, String lname, String email, String password, String sex) {
		super();
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.sex = sex;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
	
		return date;
	}

	public void setDate(Date date) {
		date = new Date();
		this.date = date;
	}

	@Override
	public String toString() {
		return "UserAccount [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", password=" + password + ", sex=" + sex + ", date=" + date + "]";
	}

	
	

}
