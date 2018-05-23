<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<div class="centerContentResponse">
				<p class="fail">入力内容に誤りがあります。もう一度入力して下さい。</p>
					<form action="/BBSLike/ContributeSuccessServlet" method="post">
						<p>コメント(200文字以内)：</p>
						<textarea cols="60" rows="7" name="contribute"></textarea><br>
						<div class="contributeButton"><input type="submit" value="投稿"></div>
					</form>
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

