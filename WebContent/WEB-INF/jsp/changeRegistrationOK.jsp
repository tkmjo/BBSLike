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
			<div id="pageBodyOnly">
				<div class="notificationPara">
					<p>登録情報を変更しました。</p>
					<p class="linkPara"><a href="/BBSLike/MainServlet">トピック一覧へ</a></p>
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