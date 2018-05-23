package model;

public class Account {
	private int userId;
	private String pass;
	private String mail;
	private String name;

	public Account(int userId, String pass, String mail, String name) {
		this.userId = userId;
		this.pass = pass;
		this.mail = mail;
		this.name = name;
	}

	// 登録時はuserIdがauto_incrementで入れられる為、userIdを除外としている。
	public Account(String pass, String mail, String name) {
		this.pass = pass;
		this.mail = mail;
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}
	public String getPass() {
		return pass;
	}
	public String getMail() {
		return mail;
	}
	public String getName() {
		return name;
	}
}
