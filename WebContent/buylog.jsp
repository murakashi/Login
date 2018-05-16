<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入履歴</title>
</head>
<body>

<% ArrayList<String[]> log_list = (ArrayList<String[]>)session.getAttribute("log_list"); %>

<center>

<h1>購入履歴</h1>

<a href="logNext?offset=1">1</a>
<a href="logNext?offset=20">2</a>
<a href="logNext?offset=40">3</a>
<a href="logNext?offset=60">4</a>
<a href="logNext?offset=80">5</a>

<table border="1">
	<tr>
	<td>購入日時</td>
	<td>商品名</td>
	<td>数量</td>
	<td>金額</td>
	<td>削除</td>
	</tr>
	<% int c=0; %>
	<% for(String[] log_arr : log_list){ %>
		<tr>
		<% for(int i=0;i<log_arr.length;i++){ %>
			<% if(i == 0){ %>

			<% }else{ %>
				<td><%= log_arr[i] %></td>
			<% } %>
		<% } %>
		<td>
		<form action="delete" method="post">
		<input type="hidden" name="num" value="<%= log_arr[0] %>">
		<input type="submit" value="削除">
		</form>
		</td>
		<% c++; %>
		</tr>
	<% } %>
</table>

</center>

</body>
</html>