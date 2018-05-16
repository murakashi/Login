<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者画面</title>
</head>
<body>

<% ArrayList<String[]> buy_list = (ArrayList<String[]>)session.getAttribute("buy_list");
   String sum = (String)session.getAttribute("sum");
%>

<center>

<h1>管理者ページ</h1>

<p>
<form action="groupBy" method="post">
<input type="submit" value="商品">
</form>
</p>

<table border="1">
	<tr>
	<td>ユーザ名</td>
	<td>商品名</td>
	<td>単価</td>
	<td>数量</td>
	<td>金額</td>
	</tr>
	<% for(String[] buy_arr : buy_list){ %>
		<tr>
		<% for(String buy : buy_arr){ %>
			<td><%= buy %></td>
		<% } %>
		</tr>
	<% } %>
</table>

<p>合計金額：<%= sum %>円</p>

</center>

</body>
</html>