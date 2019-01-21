<%@ page language="java" contentType="text/html; charset=UTF-8"
import="java.util.*"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% String path=request.getContextPath(); %>
</head>
<body>
	<%-- 用utf-8编码正常显示中文。
	<%= new java.util.Date() %> <!-- 表达式，不能有分号； -->
	<%! int i=5; %>	<!-- java声明变量 --> --%>
	<form action="<%= path %>/loginServlet" method="post">
	<span style="color:green;">post不会显示出（loginServlet?userName=&passWord=no）比get安全一些</span>
		<table>
			<tr><td>用户名：&emsp;<input type="text" name="userName"value="${sessionScope.user}"><span style="color:red;">${requestScope.msg}</span></td></tr>
			<tr><td>密码：&emsp;&emsp;<input type="password"name="passWord"value="${sessionScope.passWord }"><span style="color:red;">${requestScope.msgpwd}</span></td></tr>
<!-- 			<tr><td>记住我：&emsp;<input type="checkbox" name="remember"value="off"><element></td></tr> -->
			<tr><td>自动登录：<input type="checkbox" name="rememberAndauto"value="on"><element></td></tr>
			<tr><td><input type="submit" value="登录"></element></td></tr>
		</table>
	</form>
</body>
</html>