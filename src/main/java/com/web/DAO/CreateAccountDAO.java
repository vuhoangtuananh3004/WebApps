package com.web.DAO;

import java.util.List;

import com.web.entity.UserAccount;

public interface CreateAccountDAO {
	
	public int insertNewAccount(UserAccount user);
	public Object findAccountByEmail (String email);
	public List<UserAccount> findAllAccount();
	public int updateAccount (UserAccount user, int userid);
	public int deleteAccount (String email);
	public boolean existAccount (String email);
	

}
