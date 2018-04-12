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
import model.PostBBSCommentLogic;
import model.Response;

/**
 * Servlet implementation class ContributeSuccess
 */
@WebServlet("/ContributeSuccessServlet")
public class ContributeSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 投稿画面の入力内容を取得
				request.setCharacterEncoding("UTF-8");
				HttpSession session = request.getSession();
				// CommentServletでクリックされたときにセッションに保存されたBBSTitleを取り出す
				int threadId = (int) session.getAttribute("threadId");
				Account loginUser = (Account) session.getAttribute("loginUser");
				String responseUserName = loginUser.getName();
				String responseContent = request.getParameter("contribute");

				// 投稿処理の実行
				Response postResponse = new Response(threadId, responseUserName, responseContent);
				PostBBSCommentLogic postBBSCommentLogic = new PostBBSCommentLogic();
				List<Response> responseList = postBBSCommentLogic.execute(postResponse);

				//CommentServletに渡すセッション
				session.setAttribute("postResponse", postResponse);

				// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/contributeSuccess.jsp");
				dispatcher.forward(request, response);
	}

}
