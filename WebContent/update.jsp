<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="bean.User" scope="session" />
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
<title>登録情報変更</title>
</head>
<body>

<center>

<h1>登録情報変更</h1>

<form action="updateCheck" method="post">
<p>ID　　　　　<input type="text" name="id" id="update" value="<jsp:getProperty property="id" name="user" />"></p>
<p>パスワード<input type="password" name="pass" id="update"></p>
<p>氏名　　　　<input type="text" name="name" id="update" value="<jsp:getProperty property="name" name="user" />"></p>
<p>住所　　　　<input type="text" name="adress" id="update" value="<jsp:getProperty property="adress" name="user" />"></p>
<input type="submit" value="更新">
</form>

</center>

</body>
</html>