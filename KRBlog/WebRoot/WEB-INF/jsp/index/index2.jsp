<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>

<title>狂人BLOg</title>
</head>

<frameset rows="100,*,25" framespacing="0" border="0" frameborder="0">
    <frame target="main" noresize name="TopMenu" scrolling="no" src="${pageContext.request.contextPath}/index/head.action">
    <frameset cols="180,*" id="resize">
        <frame target="main" noresize name="menu" scrolling="yes" src="${pageContext.request.contextPath}/index/left.action">
        <frame noresize name="main" scrolling="yes" src="${pageContext.request.contextPath}/index/right.action">
    </frameset>
    <frame noresize name="status_bar" scrolling="no" src="${pageContext.request.contextPath}/index/bottom.action">
</frameset>
    
</noframes>

</html>