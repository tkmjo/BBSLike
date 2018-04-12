package model;

import dao.AccountDAO;

public class RegistrationLogic {
	public boolean execute(Account account) {
		AccountDAO dao = new AccountDAO();
		boolean result = dao.isRegisterUserChange(account);
		return result;
	}

	public boolean registerAccount(Account account) {
		AccountDAO dao = new AccountDAO();
		boolean result = dao.registerUser(account);
		return result;
	}

	/*  いらない？
	public Account getAccount(Login login) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.getAccount(login);
		return account;
	}
	*/
}
