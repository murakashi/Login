<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="style.css">

<% String flag = (String)session.getAttribute("flag");

   if(flag == null){
	   RequestDispatcher rd = request.getRequestDispatcher("login");
	   rd.forward(request, response);
	   return;
   }
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新規登録</title>
</head>
<body>

<center>

<h1>新規登録</h1>

<form action="insertCheck" method="post">
<p>　　　ID　　　　　<input type="text" name="id" id="insert"></p>
<p>　　　パスワード<input type="password" name="pass" id="insert"></p>
<p>　　　氏名　　　　<input type="text" name="name" id="insert"></p>
<p>　　　住所　　　　<input type="text" name="adress" id="insert"></p>

<input type="submit" value="登録">
</form>

</center>


</body>
</html>