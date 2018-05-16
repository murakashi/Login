<%@page import="java.util.ArrayList"%>
<%@page import="bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="bean.User" scope="session" />
<jsp:useBean id="syohin" class="bean.Syohin" scope="session" />
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
<title>ログイン成功</title>
</head>
<body>

<% ArrayList<String[]> s_list = (ArrayList<String[]>)session.getAttribute("s_list"); %>

<center>

<h1>ようこそ<jsp:getProperty property="name" name="user" />さん</h1>

<h2>商品一覧</h2>

<a href="next?offset=1">1</a>
<a href="next?offset=20">2</a>
<a href="next?offset=40">3</a>

<form action="buyLog" method="post">
<input type="submit" value="購入履歴" id="log">
</form>

<form action="buy" method="post">
<table border="1">
	<tr>
	<td>チェック</td>
	<td>商品ID</td>
	<td>商品名</td>
	<td>単価</td>
	<td>購入個数</td>
	</tr>
	<% int c=0; %>
	<% for(String[] s_arr : s_list){ %>
		<tr>
		<% for(int i=0;i<s_arr.length;i++){ %>
			<% if(i == 0){ %>
			<td><input type="checkbox" name="foods" value="<%= s_arr[i] %>"></td>
			<td><%= s_arr[i] %></td>
			<% }else{ %>
					<td><%= s_arr[i] %></td>
			<% } %>
		<% } %>
		<td><input type="text" name="<%= s_arr[c] %>"></td>
		</tr>
	<% } %>
</table>
<p><input type="submit" value="　　購入　　" width="30"></p>
</form>

<form action="update" method="post">
<p><input type="submit" value="登録情報変更" width="30"></p>
</form>

<form action="logout" method="post">
<input type="submit" value="　　ログオフ　　" width="30">
</form>

</center>

</body>
</html>