package model;

import java.util.List;

import dao.BBSCommentDAO;

public class GetBBSCommentListLogic {
	public List<Response> execute(Thread bbsTitle) {
		BBSCommentDAO dao = new BBSCommentDAO();
		List<Response> responseList = dao.getComment(bbsTitle);
		return responseList;
	}
}
