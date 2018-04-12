package model;

import java.util.List;

import dao.BBSTitleDAO;

public class PostBBSTitleListLogic {
	public List<Thread> execute(Thread bbsTitle) {
		BBSTitleDAO dao = new BBSTitleDAO();
		List<Thread> bbsTitleList = dao.postTitle(bbsTitle);
		return bbsTitleList;
	}
}
