package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.PostBBSTitleListLogic;
import model.Thread;

/**
 * Servlet implementation class MakeTopicSuccessServlet
 */
@WebServlet("/MakeTopicSuccessServlet")
public class MakeTopicSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインしているか確認するためセッションスコープからユーザー情報を取得
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Account loginUser = (Account) session.getAttribute("loginUser");

		if (loginUser == null) {
			// リダイレクト
			response.sendRedirect("/BBSLike/LoginServlet");
		} else {
			// 投稿処理の実行
			String userName = loginUser.getName();
			String title = request.getParameter("makeTopicTitle");
			String content = request.getParameter("makeTopicContent");

			// 投稿処理の実行
			Thread bbsTitle = new Thread(title, userName, content);
			PostBBSTitleListLogic postBBSTitleListLogic = new PostBBSTitleListLogic();
			List<Thread> bbsTitleRet = (List<Thread>) postBBSTitleListLogic.execute(bbsTitle);
			session.setAttribute("bbsTitleRet", bbsTitleRet);

			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/makeTopicSuccess.jsp");
			dispatcher.forward(request, response);
		}
	}

}
