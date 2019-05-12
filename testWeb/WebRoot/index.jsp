<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%String path=request.getContextPath(); %>
</head>
<body>
<%--  用utf-8编码正常显示中文。
	<%= new java.util.Date() %> <!-- 表达式，不能有分号； -->
	<%! int i=5; %>	<!-- java声明变量 -->  --%>

	<% out.println("登录成功！"); %>
	<p>欢迎你：${sessionScope.user}</p>
	<form action="<%= path %>/logoutServlet" method="post">
		<table>
			<tr><td><input type="text"  readonly="readonly"  value="欢迎你登录。"></td></tr>
			<tr><td><input type="submit"  disabled="disabled"  value="退出"></td></tr>
			<tr><td><input type="submit"    value="退出"></td></tr>
		</table>
	</form>
		<p>当前在线人数：${applicationScope.nums}人</p>
		
</body>
</html>