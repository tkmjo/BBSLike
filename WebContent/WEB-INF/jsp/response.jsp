<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
<%@ page import="model.Login,model.BBSComment,java.util.List" %>
<%
// セッションスコープに保存されたユーザー情報を取得
Login loginUser = (Login) session.getAttribute("loginUser");
// データベースに保存されたコメントを取得
List<BBSComment> bbsCommentList = (List<BBSComment>) request.getAttribute("bbsCommentList");
%>
--%>
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
			<div id="pageBodyOnly">
				<div class="title">
					<p class="titleContentTitle">${responseFirst.threadTitle }</p>
					<p class="titleContentName">${responseFirst.threadUserName }</p>
					<p class="titleContentDate">${responseFirst.threadPostTime }</p>
					<p class="titleContentP">${responseFirst.threadContent }</p>
				</div>

				<div class="linkButton">
					<span class="linkButtonDecoration"><a href="/BBSLike/ContributeServlet">投稿する</a></span>
					<span class="linkButtonDecoration"><a href="/BBSLike/MainServlet">トピック一覧へ</a></span>
				</div>

				<c:if test="${!empty responseList }">
				<c:forEach var="responseList" items="${responseList }" varStatus="num">
					<div class="responseList">
						<div class="response">
							<p class="responseContentName"><c:out value="${num.count}" />.<span class="responseContentNameColor"><c:out value="${responseList.responseUserName }" /></span></p>
							<p class="responseContentDate"><c:out value="${responseList.responsePostTime }" /></p>
							<p class="responseContentP"><c:out value="${responseList.responseContent }" /></p>
						</div>
					</div>
				</c:forEach>
				</c:if>
			</div>
		</div>

		<div id="pageFoot">
			<!-- フッター -->
			<p id="copyright">Copyright&copy; 2017 @SimpleBBS All Rights Reserved.</p>
		</div>
	</div>
</body>
</html>