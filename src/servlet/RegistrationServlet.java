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

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");


		// 会員登録処理の実行
		Account account = new Account(pass, email, userName);
		RegistrationLogic registrationLogic = new RegistrationLogic();
		boolean result = registrationLogic.registerAccount(account);

		// 会員登録の成否によって処理を分岐
		if (result) {
			HttpSession session = request.getSession();
			session.setAttribute("account", account);

			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registrationOK.jsp");
			dispatcher.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("account", account);

			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registrationFail.jsp");
			dispatcher.forward(request, response);

			// response.sendRedirect("/BBSLike/RegistrationServlet");
		}
	}

}
