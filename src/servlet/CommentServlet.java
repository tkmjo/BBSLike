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
import model.GetBBSCommentListLogic;
import model.GetBBSTitleListLogic;
import model.Response;
import model.Thread;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
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
			GetBBSCommentListLogic getBBSCommentListLogic = new GetBBSCommentListLogic();
			GetBBSTitleListLogic getBBSTitleListLogic = new GetBBSTitleListLogic();

			String sid = request.getParameter("sid");


			// main.jspからタイトルをクリックしたとき、コメント一覧画面に遷移する
			if (sid.equals("1")) {
				String threadIdStr = request.getParameter("threadId");
				int threadId = Integer.parseInt(threadIdStr);
				session.setAttribute("threadId", threadId);
				// MainServletから
				List<Thread> threadList = (List<Thread>) session.getAttribute("threadList");
				Thread thread = new Thread();
				for (Thread t : threadList) {
					if (t.getThreadId() == threadId) {
						thread = t;
					}
				}

				Thread bbsTitle = new Thread(threadId);
				List<Response> responseList = getBBSCommentListLogic.execute(bbsTitle);


				if (responseList != null) {
					session.setAttribute("responseList", responseList);

					// Response responseFirst = responseList.get(0);
					session.setAttribute("responseFirst", thread);
				} else {
					session.setAttribute("responseFirst", thread);
				}
			}


			// contributeSuccess.jspから「コメント画面へ戻る」をクリックした時
			if (sid.equals("2")) {
				int threadId = (int) session.getAttribute("threadId");
				session.setAttribute("threadId", threadId);
				Thread bbsTitle = new Thread(threadId);
				List<Response> responseList = getBBSCommentListLogic.execute(bbsTitle);

				session.setAttribute("responseList", responseList);

				Response responseFirst = responseList.get(0);
				session.setAttribute("responseFirst", responseFirst);
			}

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/response.jsp");
				dispatcher.forward(request, response);
		}
	}
}
