package model;

import java.util.List;

import dao.BBSTitleDAO;

public class GetBBSTitleListLogic {
	public List<Thread> execute() {
		BBSTitleDAO dao = new BBSTitleDAO();
		List<Thread> bbsTitleList = dao.getTitle();
		return bbsTitleList;
	}

	public Thread executeGetThread(Thread thread) {
		BBSTitleDAO dao = new BBSTitleDAO();
		Thread threadRet = dao.getOnlyTitle(thread);
		return threadRet;
	}
}
