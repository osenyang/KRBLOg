<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath %>" />
<title>Insert title here</title>
</head>
<body>
path = <%= path %>

<br>
basePath = <%= basePath %>

<br>
pageContext.request.contextPath = ${pageContext.request.contextPath}

<br>
<a href="index.jsp">跳回首页</a>
</body>
</html>