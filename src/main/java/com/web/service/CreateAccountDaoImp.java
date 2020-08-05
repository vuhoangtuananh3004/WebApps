package com.web.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.web.DAO.CreateAccountDAO;
import com.web.entity.UserAccount;

@Repository
public class CreateAccountDaoImp implements CreateAccountDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;

	public class AccountMapper implements RowMapper<UserAccount> {
		   public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
		      UserAccount user = new UserAccount();
		      user.setEmail(rs.getString("email"));
		      user.setFname(rs.getString("fname"));
		      user.setLname(rs.getString("lname"));
		      user.setPassword(rs.getString("password"));
		      user.setSex(rs.getString("sex"));
		      return user;
		   }
		}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existAccount(String email) {
		boolean exist = false;
		String sql = "Select email from user_account where email=?";
		
		try {
			UserAccount existAccount = (UserAccount) jdbcTemplate.queryForObject(sql, new Object [] {email}, new AccountMapper());
			if (existAccount.getEmail().contentEquals(email)) {
			exist = true;}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return exist;
	}
	
	
	@Override
	public int insertNewAccount(UserAccount user) {
		return jdbcTemplate.update("insert into user_account (userid, fname, lname, email, password, sex, date) " 
	+ "values(?, ?, ?, ?, ?, ?, ?)",
				new Object[] { user.getUserId(), user.getFname(), user.getLname(), user.getEmail(),
						user.getPassword(), user.getSex(), user.getDate()});
	}


	@SuppressWarnings("unchecked")
	@Override
	public Object findAccountByEmail(String email) {
		String sql = "Select * from user_account where email=?";
		UserAccount account = jdbcTemplate.queryForObject(sql, new Object[] {email}, new AccountMapper());
		return account;
	}

	@Override
	public List<UserAccount> findAllAccount() {
		String sql = "Select * from user_account";
		List <UserAccount> list = jdbcTemplate.query(sql, new AccountMapper());
		return list;
	}

	@Override
	public int updateAccount(UserAccount user, int userid) {
		String sql = "Update user_account set email = ? where userid = ?";
		return jdbcTemplate.update(sql,user.getEmail(),userid);
	}

	@Override
	public int deleteAccount(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
