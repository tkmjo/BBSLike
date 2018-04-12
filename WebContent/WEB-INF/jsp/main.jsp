<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>SimpleBBS</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/common/css/normalize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/common/css/style.css">
</head>
<body>
	<div id="page">
		<div id="pageHead">
			<!-- ヘッダー -->
			<h1 id="siteTitle">SimpleBBS</h1>
		</div>

		<div id="pageBody">
			<div id="pageBodyMain">
				<div class="makeThreadButton">
					<!-- メインカラム -->
					<p><a href="/BBSLike/MakeTopicServlet">スレッドを作成する</a></p>
				</div>

				<div id="threadList">
					<c:forEach var="bbsTitle" items="${threadList }">
						<div class="threadListDetail">
							<a href="/BBSLike/CommentServlet?threadId=${bbsTitle.threadId }&sid=1">
								<div class="threadContent">
									<p class="threadContentTitle">${bbsTitle.threadTitle }(${bbsTitle.threadResponseNum })</p>
									<p class="threadContentDate">${bbsTitle.threadUpdateTime }</p>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
			</div>

			<div id="pageBodySub">
				<div class="localNavi">
					<!-- サブカラム -->
					<ul>
						<li><a href="/BBSLike/MainServlet">更新</a></li>
						<li><a href="/BBSLike/ChangeRegistrationServlet">登録情報変更</a></li>
						<li><a href="/BBSLike/LogoutServlet">ログアウト</a></li>
					</ul>
				</div>
			</div>
		</div>

		<div id="pageFoot">
			<!-- フッター -->
			<p id="copyright">Copyright&copy; 2017 @SimpleBBS All Rights Reserved.</p>
		</div>
	</div>
</body>
</html>