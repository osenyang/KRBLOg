<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/index/head.jsp"%>
<title>错误提示</title>
</head>
<body>
<div class="container" id="kr_main">

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">您的操作出现错误如下：</h3>
  </div>
  <div class="panel-body">
    <p style="color: red;">${message}</p>
  </div>
  
  <div class="panel-footer">
  	<input class="btn btn-default" type="button" value="返回" onclick="history.back(-1);"/>
  </div>
</div>

</div>

<%@ include file="/WEB-INF/jsp/index/bottom.jsp"%>
</body>
</html>