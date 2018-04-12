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
				<div class="centerContent">
					<form action="/BBSLike/ChangeRegistrationServlet" method="post">
						<input type="hidden" name="userId" value="${loginUser.userId }">  <!-- aaaaaaa -->
						<span class="para">パスワード:　</span><input type="password" name="pass" value="${loginUser.pass }"><br><br>
						<span class="para">メールアドレス:　</span><input type="text" name="email" value="${loginUser.mail }"><br><br>
						<span class="para">ユーザーネーム:　</span><input type="text" name="userName" value="${loginUser.name }"><br><br>
						<span class="para">年齢:　</span><input type="text" name="age" value="${loginUser.age }"><br>
						<div class="submitButton"><input type="submit" value="登録"></div>
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