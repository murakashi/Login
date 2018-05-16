<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="bean.User" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<% String flag = (String)session.getAttribute("flag");

   if(flag == null){
	   RequestDispatcher rd = request.getRequestDispatcher("login");
	   rd.forward(request, response);
	   return;
   }
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>変更確認</title>
</head>
<body>

<center>

<h1>変更確認</h1>
<p>この内容でよろしいですか？</p>

<p>ID→<jsp:getProperty property="id" name="user"/></p>
<p>パスワード→<jsp:getProperty property="pass" name="user"/></p>
<p>氏名→<jsp:getProperty property="name" name="user"/></p>
<p>住所→<jsp:getProperty property="adress" name="user"/></p>

<form action="updateDecide" method="post">
<input type="hidden" name="id" value="<jsp:getProperty property="id" name="user" />">
<input type="hidden" name="pass" value="<jsp:getProperty property="pass" name="user" />">
<input type="hidden" name="name" value="<jsp:getProperty property="name" name="user" />">
<input type="hidden" name="adress" value="<jsp:getProperty property="adress" name="user" />">
<p><input type="submit" value="OK"></p>
</form>

<form action="update" method="post">
<input type="submit" value="キャンセル">
</form>

</center>


</body>
</html>