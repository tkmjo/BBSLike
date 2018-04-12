package model;

import java.util.List;

import dao.BBSCommentDAO;

public class PostBBSCommentLogic {
	public List<Response> execute(Response comment) {
		BBSCommentDAO dao = new BBSCommentDAO();
		List<Response> responseList = dao.postComment(comment);
		return responseList;
	}
}
