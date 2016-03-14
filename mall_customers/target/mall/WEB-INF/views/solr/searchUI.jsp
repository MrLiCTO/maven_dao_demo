<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="/common.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<form action="${ctp}searchUI.action">
	<input type="text" name="search_key" value="${search_key}">
	<input type="submit" value="查询">
</form>
<h3 align="center">用户列表</h3>
	<table align="center">
			<tr>
				<td>用户名</td>
				<td>用户编号</td>
				<td>操作</td>
			</tr>
	
			<c:forEach items="${list}" var="user">	
			
				<tr>
				<td>${user.userName}</td>
				<td>${user.userNo}</td>
				<td>
					<a href="${ctp}editUI.action?id=${user.userId}&currPage=${currPage}">查看详情</a>
				</td>
				</tr>	
			
			</c:forEach>
	
			
	</table>
			<div align="center">	
			<li>总记录：${page.pageQuery_infoCount}</li>
			<li>总页数：${page.pageQuery_Psize}</li>
			<li>当前页：${page.pageQuery_currPage}</li>
			<input type="hidden" name="currPage" value="${currPage}">
			<li><a href="${ctp}searchUI.action?currPage=${currPage+1}&search_key=${search_key}">下一页</a>
 			<li><a href="${ctp}searchUI.action?currPage=${currPage-1}&search_key=${search_key}">上一页</a>
 			</div>
			

</body>
</html>