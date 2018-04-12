package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Thread;

public class BBSTitleDAO {
	// タイトル情報とレスポンスの内容を返す
	public List<Thread> getTitle() {
		Connection conn = null;
		List<Thread> bbsTitleList = new ArrayList<Thread>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続
			conn = DriverManager.getConnection("jdbc:h2:C:/data/bbsLike", "sa", "");

			// SELECT文を準備
			String sql = "SELECT THREADID, TITLE, CONTENT, USERNAME, POSTTIME, UPDATETIME, RESPONSENUM FROM THREAD ORDER BY UPDATETIME DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SELECTを実行し結果表を取得
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				int threadId = rs.getInt("THREADID");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String username = rs.getString("USERNAME");
				Date postTimeDate = rs.getTimestamp("POSTTIME");
				String postTime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(postTimeDate);
				Date updateTimeDate = rs.getTimestamp("UPDATETIME");
				String updateTime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(updateTimeDate);
				int responseNum = rs.getInt("RESPONSENUM");
				Thread bbsTitle = new Thread(threadId, title, username, content, postTime, updateTime, responseNum);
				bbsTitleList.add(bbsTitle);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return bbsTitleList;
	}


	// タイトル情報のみを返す（不用？）
	public Thread getOnlyTitle(Thread thread) {
		Connection conn = null;
		Thread threadRet = new Thread();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続
			conn = DriverManager.getConnection("jdbc:h2:C:/data/bbsLike", "sa", "");

			// SELECT文を準備
			String sql = "SELECT THREADID, TITLE, CONTENT, USERNAME, POSTTIME FROM THREAD WHERE THREADID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// INSERT文の「?」に使用する値を設定し、SQLを完成
			pStmt.setInt(1, thread.getThreadId());

			// SELECTを実行し結果表を取得
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				int threadId = rs.getInt("THREADID");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String username = rs.getString("USERNAME");
				Date postTimeDate = rs.getTimestamp("POSTTIME");
				String postTime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(postTimeDate);
				thread = new Thread(threadId, title, content, username, postTime);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return threadRet;
	}


	// スレッドを作成
	public List<Thread> postTitle(Thread bbsTitle) {
		Connection conn = null;
		List<Thread> bbsTitleList = new ArrayList<Thread>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続
			conn = DriverManager.getConnection("jdbc:h2:C:/data/bbsLike", "sa", "");

			// SELECTを準備
			String sql = "INSERT INTO THREAD (TITLE,USERNAME,CONTENT,POSTTIME, UPDATETIME,RESPONSENUM) VALUES(?,?,?,NOW(), NOW(), 0)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// INSERT文の「?」に使用する値を設定し、SQLを完成
			pStmt.setString(1, bbsTitle.getThreadTitle());
			pStmt.setString(2, bbsTitle.getThreadUserName());
			pStmt.setString(3, bbsTitle.getThreadContent());

			// INSERT文を実行
			int result = pStmt.executeUpdate();

			if (result != 1) {
				return null;
			}


			// SELECT文を準備
			String sqlSelect = "SELECT THREADID,TITLE,USERNAME,CONTENT,POSTTIME,UPDATETIME,RESPONSENUM FROM THREAD";
			PreparedStatement pStmtSelect = conn.prepareStatement(sqlSelect);

			// SELECT文を実行し、結果表を取得
			ResultSet rs = pStmtSelect.executeQuery();

			while (rs.next()) {
				int threadId = rs.getInt("THREADID");
				String title = rs.getString("TITLE");
				String userName = rs.getString("USERNAME");
				String content = rs.getString("CONTENT");
				Date postTime = rs.getTimestamp("POSTTIME");
				String postTimeStr = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(postTime);
				Date updateTime = rs.getTimestamp("UPDATETIME");
				String updateTimeStr = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(updateTime);
				int responseNum = rs.getInt("RESPONSENUM");
				Thread threadRet = new Thread(threadId, title, content, userName, postTimeStr, updateTimeStr,responseNum);
				bbsTitleList.add(threadRet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return bbsTitleList;
	}
}
