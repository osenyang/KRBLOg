<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<title>Insert title here</title>
</head>
<body>
<div class="alert alert-success" role="alert">Well done! You successfully read this important alert message.</div>
<div class="alert alert-info" role="alert">Heads up! This alert needs your attention, but it's not super important.</div>
<div class="alert alert-warning" role="alert">Warning! Better check yourself, you're not looking too good.</div>
<div class="alert alert-danger" role="alert">Oh snap! Change a few things up and try submitting again.</div>

<!-- 为警告框添加一个可选的 .alert-dismissible 类和一个关闭按钮。 -->
<div class="alert alert-warning alert-dismissible" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <strong>Warning!</strong> Better check yourself, you're not looking too good.
</div>
</body>
</html>