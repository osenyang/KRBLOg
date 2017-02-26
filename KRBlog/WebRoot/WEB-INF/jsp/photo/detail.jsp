<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/public/common.jspf" %>
<title>心情</title>
</head>
<body> 
心情：
<table width="100%" border=1>
<tr>
	<td>心情ID</td>
	<td>内容</td>
	<td>创建时间</td>
	<td>状态</td>
	<td>加密</td>
	<td>被观看</td>
	<td>回复数</td>
	<td>操作</td>
</tr>
<tr>
	<td>${mood.id}</td>
	<td>${mood.content}</td>
	<td><fmt:formatDate value="${mood.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${mood.status}</td>
	<td>${mood.isSecret}</td>
	<td>${mood.seeCount}</td>
	<td>${mood.replyCount}</td>
	
	<td><a href="${pageContext.request.contextPath }/mood/encryptUI.action?id=${mood.id}">加密</a></td>

</tr>

</table>
</body>

</html>