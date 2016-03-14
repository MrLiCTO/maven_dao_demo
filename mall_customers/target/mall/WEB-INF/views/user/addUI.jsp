<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <<jsp:include page="/common.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3  align="center">添加用户</h3>
	<form action="${ctp}add.action" method="post">
		<input type="hidden" name="currPage" value="${currPage}">
		<table align="center">
			
				<tr><td>用户名</td><td><input type="text" name="userName"></td></tr>
				<tr><td>用户编号</td><td><input type="text" name="userNo"></td></tr>
				<tr><td>用户年龄</td><td><input type="text" name="userAge"></td></tr>
				<tr><td>用户性别</td><td><input type="radio" name="userSex" value="1">男<input type="radio" name="userSex" value="0">女</td></tr>
			
		
		</table>
		<input type="submit" value="添加">
	
	</form>

</body>
</html>