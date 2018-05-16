<%@page import="bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品ごと</title>
</head>
<body>


<% ArrayList<String[]> group_list = (ArrayList<String[]>)session.getAttribute("group_list");
   String sum = (String)session.getAttribute("sum");
   User user = (User)session.getAttribute("user");
%>

<center>

<h1>商品ごとの売上</h1>

<p>
<form action="loginCheck" method="post">
<input type="hidden" name="id" value="<%= user.getId() %>">
<input type="hidden" name="pass" value="<%= user.getPass() %>">
<input type="submit" value="ユーザ">
</form>
</p>

<table border="1">
	<tr>
	<td>商品名</td>
	<td>単価</td>
	<td>数量</td>
	<td>金額</td>
	</tr>
	<% for(String[] group_arr : group_list){ %>
		<tr>
		<% for(String group : group_arr){ %>
			<td><%= group %></td>
		<% } %>
		</tr>
	<% } %>
</table>

<p>合計金額：<%= sum %>円</p>

</center>

</body>
</html>