package model;

import java.util.List;

public class Thread {
	private int threadId;
	private String title;
	private String content;
	private String userName;
	private String postTime;
	private String updateTime;
	private int responseNum;
	private List<Response> commentList;

	public Thread() {};

	public Thread(int threadId, String title, String userName, String content) {
		this.threadId = threadId;
		this.title = title;
		this.userName = userName;
		this.content = content;
	}

	public Thread(String title, String userName, String content, List<Response> commentList) {
		this.title = title;
		this.userName = userName;
		this.content = content;
		this.commentList = commentList;
	}

	public Thread(String title, String userName, String content) {
		this.title = title;
		this.userName = userName;
		this.content = content;
	}

	// ===
	public Thread(int threadId, String title, String content, String userName, String postTime) {
		this.threadId = threadId;
		this.title = title;
		this.userName = userName;
		this.content = content;
		this.postTime = postTime;
	}

	// ===
	public Thread(int threadId, String title,  String userName, String content, String postTime, String updateTime, int responseNum) {
		this.threadId = threadId;
		this.title = title;
		this.userName = userName;
		this.content = content;
		this.postTime = postTime;
		this.updateTime = updateTime;
		this.responseNum = responseNum;
	}

	// ===
	public Thread(int threadId) {
		this.threadId = threadId;
	}

	public Thread(int threadId, String title, String userName, String content, List<Response> commentList) {
		this.threadId = threadId;
		this.title = title;
		this.userName = userName;
		this.content = content;
		this.commentList = commentList;
	}

	public int getThreadId() {
		return threadId;
	}

	public String getThreadTitle() {
		return title;
	}

	public String getThreadUserName() {
		return userName;
	}

	public String getThreadContent() {
		return content;
	}

	public void setCommentList(List<Response> commentList) {
		this.commentList = commentList;
	}

	public String getThreadPostTime() {
		return postTime;
	}

	public String getThreadUpdateTime() {
		return updateTime;
	}

	public int getThreadResponseNum() {
		return responseNum;
	}

	public List<Response> getCommentList() {
		return commentList;
	}
}
