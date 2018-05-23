package model;

import dao.AccountDAO;

public class RegistrationLogic {
	public boolean execute(Account account) {
		AccountDAO dao = new AccountDAO();
		boolean result = dao.isRegisterUserChange(account);
		return result;
	}

	public Account registerAccount(Account account) {
		AccountDAO dao = new AccountDAO();
		Account getAccount = dao.registerUser(account);
		return getAccount;
	}

	/*  いらない？
	public Account getAccount(Login login) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.getAccount(login);
		return account;
	}
	*/
}
