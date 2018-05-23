package model;

public class Login {
	private String pass;
	private String mail;

	public Login(String mail, String pass) {
		this.mail = mail;
		this.pass = pass;
	}

	public String getMail() {
		return mail;
	}

	public String getPass() {
		return pass;
	}
}
