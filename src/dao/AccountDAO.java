package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
	public Account findByLogin(Login login) {
		Connection conn = null;
		Account account = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続
			conn = DriverManager.getConnection("jdbc:h2:C:/data/bbsLike", "sa", "");

			// SELECT文を準備
			String sql = "SELECT ID,PASS,MAIL,NAME FROM ACCOUNT WHERE MAIL = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getMail());
			pStmt.setString(2, login.getPass());

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致したユーザーが存在した場合、そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				// 結果表からデータを取得
				int userId = rs.getInt("ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String name = rs.getString("NAME");

				account = new Account(userId, pass, mail, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return account;
	}

	// 会員登録画面よりアカウントを登録する処理
	public boolean registerUser(Account account) {
		Connection conn = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続
			conn = DriverManager.getConnection("jdbc:h2:C:/data/bbsLike", "sa", "");

			// INSERT文を準備
			String sql = "INSERT INTO ACCOUNT (PASS,MAIL,NAME) VALUES (?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getPass());
			pStmt.setString(2, account.getMail());
			pStmt.setString(3, account.getName());

			// Mailの空文字判定
			if (account.getMail() == null || account.getMail().length() == 0) {
				return false;
			}

			// Nameの空文字判定
			if (account.getName() == null || account.getName().length() == 0) {
				return false;
			}

			// PassWordの空文字判定
			if (account.getPass() == null || account.getPass().length() == 0) {
				return false;
			}

			// INSERT文を実行
			int result = pStmt.executeUpdate();

			if (result != 1) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	public boolean isRegisterUserChange(Account account) {
		Connection conn = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続
			conn = DriverManager.getConnection("jdbc:h2:C:/data/bbsLike", "sa", "");

			// UPDATE文を準備
			String sql = "UPDATE ACCOUNT SET PASS = ?,MAIL = ?,NAME = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getPass());
			pStmt.setString(2, account.getMail());
			pStmt.setString(3, account.getName());

			// Mailの空文字判定
			if (account.getMail() == null || account.getMail().length() == 0) {
				return false;
			}

			// Nameの空文字判定
			if (account.getName() == null || account.getName().length() == 0) {
				return false;
			}

			// PassWordの空文字判定
			if (account.getPass() == null || account.getPass().length() == 0) {
				return false;
			}

			// UPDATE文を実行
			int result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("resultは" + result);
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	// mainからchangeResistrationに遷移した際、Account情報をテキストボックスに配置
	/* いらない？
	public Account getAccount(Login login) {
		Connection conn = null;
		Account account = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続
			conn = DriverManager.getConnection("jdbc:h2:C:/data/bbsLike", "sa", "");

			// SELECT文を準備
			String sql = "SELECT USER_ID,PASS,MAIL,NAME,AGE FROM ACCOUNT WHERE USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());

			// SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				// 結果表からデータを取得
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");

				account = new Account(userId, pass, mail, name, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return account;
	}
	*/
}