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
<a href="${ctp}addUI.action?currPage=${currPage}">添加</a>
<h3 align="center">用户列表</h3>
	<table align="center">
			<tr>
				<td>用户名</td>
				<td>用户编号</td>
				<td>用户年龄</td>
				<td>用户性别</td>
			</tr>
	
			<c:forEach items="${list}" var="user">	
			
				<tr>
				<td>${user.userName}</td>
				<td>${user.userNo}</td>
				<td>${user.userAge}</td>
				<td>
				
					<c:if test="${user.userSex==0}">
						女
					</c:if>
					
					<c:if test="${user.userSex==1}">
						男
					</c:if>
				
				</td>
				<td><a href="${ctp}delete.action?id=${user.userId}&currPage=${currPage}">删除</a>
					<a href="${ctp}editUI.action?id=${user.userId}&currPage=${currPage}">编辑</a>
				</td>
				</tr>	
			
			</c:forEach>
	
			
	</table>
			<div align="center">	
			<li>总记录：${page.pageQuery_infoCount}</li>
			<li>总页数：${page.pageQuery_Psize}</li>
			<li>当前页：${page.pageQuery_currPage}</li>
			<input type="hidden" name="currPage" value="${currPage}">
			<li><a href="${ctp}listUI.action?currPage=${currPage+1}">下一页</a>
 			<li><a href="${ctp}listUI.action?currPage=${currPage-1}">上一页</a>
 			</div>
			

</body>
</html>