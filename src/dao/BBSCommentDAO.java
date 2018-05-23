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

import model.Response;
import model.Thread;

public class BBSCommentDAO {
	List<Response> responseList = new ArrayList<Response>();

	public List<Response> getComment(Thread title) {
		Connection conn = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続
			conn = DriverManager.getConnection("jdbc:h2:C:/data/bbsLike", "sa", "");

			// SELECT文を準備
			String sql = "SELECT THREAD.TITLE AS THREADTITLE, THREAD.CONTENT AS THREADCONTENT, THREAD.USERNAME AS THREADUSERNAME, "
					+ "THREAD.POSTTIME AS THREADPOSTTIME, RESPONSE.USERNAME AS RESPONSEUSERNAME, "
					+ "RESPONSE.CONTENT AS RESPONSECONTENT, RESPONSE.POSTTIME AS RESPONSEPOSTTIME"
					+ " FROM RESPONSE JOIN THREAD ON RESPONSE.THREADID = THREAD.THREADID "
					+ "WHERE RESPONSE.THREADID= ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, title.getThreadId());

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String threadTitle = rs.getString("THREADTITLE");
				String threadContent = rs.getString("THREADCONTENT");
				String threadUserName = rs.getString("THREADUSERNAME");
				Date threadPostTimeDate = rs.getTimestamp("THREADPOSTTIME");
				String threadPostTime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(threadPostTimeDate);
				String responseUserName = rs.getString("RESPONSEUSERNAME");
				String responseContent = rs.getString("RESPONSECONTENT");
				Date responsePostTimeDate = rs.getTimestamp("RESPONSEPOSTTIME");
				String responsePostTime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(responsePostTimeDate);
				Response response = new Response(threadTitle, threadContent, threadUserName, threadPostTime, responseUserName, responseContent, responsePostTime);
				responseList.add(response);
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
		return responseList;
	}


	public List<Response> postComment(Response bbsComment) {
		Connection conn = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続
			conn = DriverManager.getConnection("jdbc:h2:C:/data/bbsLike", "sa", "");

			// INSERT文を準備
			String sql = "INSERT INTO RESPONSE (THREADID,USERNAME,CONTENT,POSTTIME) VALUES(?,?,?,NOW())";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// INSERT文の「?」に使用する値を設定し、SQLを完成
			pStmt.setInt(1, bbsComment.getThreadId());
			pStmt.setString(2, bbsComment.getResponseUserName());
			pStmt.setString(3, bbsComment.getResponseContent());

			// Mailの空文字判定
			if (bbsComment.getResponseContent() == null || bbsComment.getResponseContent().length() == 0) {
				return null;
			}

			// INSERT文を実行
			int result = pStmt.executeUpdate();

			if (result != 1) {
				return null;
			}


			// THREADテーブルにUPDATETIMEとRESPONSENUMを入れる
			// INSERT文を準備
			String sqlTh = "UPDATE THREAD SET UPDATETIME = NOW(), RESPONSENUM = RESPONSENUM + 1 WHERE THREADID = ?";
			PreparedStatement pStmtTh = conn.prepareStatement(sqlTh);

			// INSERT文の「?」に使用する値を設定し、SQLを完成
			pStmtTh.setInt(1, bbsComment.getThreadId());

			// INSERT文を実行
			int resultTh = pStmtTh.executeUpdate();

			if (resultTh != 1) {
				return null;
			}

			String sqlResult = "SELECT THREAD.TITLE AS THREADTITLE, THREAD.CONTENT AS THREADCONTENT, THREAD.USERNAME AS THREADUSERNAME, "
					+ "THREAD.POSTTIME AS THREADPOSTTIME, RESPONSE.USERNAME AS RESPONSEUSERNAME, "
					+ "RESPONSE.CONTENT AS RESPONSECONTENT, RESPONSE.POSTTIME AS RESPONSEPOSTTIME"
					+ " FROM RESPONSE JOIN THREAD ON RESPONSE.THREADID = THREAD.THREADID "
					+ "WHERE RESPONSE.THREADID= ?";
			PreparedStatement pStmtResult = conn.prepareStatement(sqlResult);
			pStmtResult.setInt(1, bbsComment.getThreadId());

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmtResult.executeQuery();

			while (rs.next()) {
				String threadTitle = rs.getString("THREADTITLE");
				String threadContent = rs.getString("THREADCONTENT");
				String threadUserName = rs.getString("THREADUSERNAME");
				Date threadPostTimeDate = rs.getTimestamp("THREADPOSTTIME");
				String threadPostTime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(threadPostTimeDate);
				String responseUserName = rs.getString("RESPONSEUSERNAME");
				String responseContent = rs.getString("RESPONSECONTENT");
				Date responsePostTimeDate = rs.getTimestamp("RESPONSEPOSTTIME");
				String responsePostTime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(responsePostTimeDate);
				Response response = new Response(threadTitle, threadContent, threadUserName, threadPostTime, responseUserName, responseContent, responsePostTime);
				responseList.add(response);
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
		return responseList;
	}
}