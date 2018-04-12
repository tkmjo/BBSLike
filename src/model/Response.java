package model;

public class Response {
	private int responseId;
	private int threadId;
	private String threadTitle;
	private String threadContent;
	private String threadUserName;
	private String threadPostTime;
	private String responseUserName;
	private String responseContent;
	private String responsePostTime;

	// ===
	public Response(String threadTitle, String threadContent, String threadUserName, String threadPostTime, String responseUserName, String responseContent, String responsePostTime) {
		this.threadTitle = threadTitle;
		this.threadContent = threadContent;
		this.threadUserName = threadUserName;
		this.threadPostTime = threadPostTime;
		this.responseUserName = responseUserName;
		this.responseContent = responseContent;
		this.responsePostTime = responsePostTime;
	}

	public Response() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Response(int threadId, String responseUserName, String responseContent) {
		this.threadId = threadId;
		this.responseUserName = responseUserName;
		this.responseContent = responseContent;
	}

	public String getThreadTitle() {
		return threadTitle;
	}

	public String getThreadContent() {
		return threadContent;
	}

	public String getThreadUserName() {
		return threadUserName;
	}

	public String getThreadPostTime() {
		return threadPostTime;
	}

	public String getResponseUserName() {
		return responseUserName;
	}

	public String getResponseContent() {
		return responseContent;
	}

	public String getResponsePostTime() {
		return responsePostTime;
	}


	public int getResponseId() {
		return responseId;
	}

	public int getThreadId() {
		return threadId;
	}
}
