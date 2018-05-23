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
					<form action="/BBSLike/MakeTopicSuccessServlet" method="post">
						<p>スレッドタイトル(20文字以内):</p>
						<textarea cols="60" rows="1" name="makeTopicTitle" maxlength="20"></textarea><br><br>
						<p>内容(300文字以内)：</p>
						<textarea cols="60" rows="7" name="makeTopicContent"></textarea><br>
						<div class="contributeButton"><input type="submit" value="スレッド作成"></div>
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