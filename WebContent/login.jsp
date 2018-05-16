<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<title>ログイン画面</title>
</head>
<body>

<center>

<h1>ログイン</h1>

<form action="loginCheck" method="post">

<p>ID　　　　　<input type="text" name="id" id="login"></p>
<p>パスワード<input type="password" name="pass" id="login"></p>

<input type="submit" value="ログイン">

</form>

<p><a href="insertLink?flag=iii">初めての方はこちら</a></p>

</center>

</body>
</html>