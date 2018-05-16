<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="style.css">

<% String flag = (String)session.getAttribute("flag");

   if(!(flag.equals("NG"))){
	   RequestDispatcher rd = request.getRequestDispatcher("login");
	   rd.forward(request, response);
	   return;
   }
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログインエラー</title>
</head>
<body>

<center>
<h1>ログインエラー</h1>

<form action="loginCheck" method="post">
<p>ID　　　　　<input type="text" name="id" id="login"></p>
<p>パスワード<input type="password" name="pass" id="login"></p>
<input type="submit" value="ログイン">
</form>

<p><a href="insert">初めての方はこちら</a></p>

</center>

</body>
</html>