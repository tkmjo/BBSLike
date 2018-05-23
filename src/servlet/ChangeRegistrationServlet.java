package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.RegistrationLogic;

@WebServlet("/ChangeRegistrationServlet")
public class ChangeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// ログインしているか確認するためセッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		Account loginUser = (Account) session.getAttribute("loginUser");

		if (loginUser == null) {
			// リダイレクト
			response.sendRedirect("/BBSLike/LoginServlet");
		} else {
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/changeRegistration.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");

		// 会員情報変更処理の実行
		Account account = new Account(pass, email, userName);
		RegistrationLogic registrationLogic = new RegistrationLogic();
		boolean result = registrationLogic.execute(account);


		if (result) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", account);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/changeRegistrationOK.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("/BBSLike/ChangeRegistrationServlet");
		}
	}

}
