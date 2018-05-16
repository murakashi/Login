<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="user" class="bean.User" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>

<h1>購入完了しました</h1>

<form action="loginCheck" method="post">
<input type="hidden" name="id" value="<jsp:getProperty property="id" name="user" />">
<input type="hidden" name="pass" value="<jsp:getProperty property="pass" name="user" />">
<input type="submit" value="　　購入画面に戻る　　" width="30">
</form>

</center>

</body>
</html>