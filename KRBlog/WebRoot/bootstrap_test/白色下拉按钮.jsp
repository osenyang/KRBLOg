<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<title>Insert title here</title>
</head>
<body>

<!-- Single button -->
<div class="btn-group">
	<button type="button" class="btn btn-default dropdown-toggle"
		data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		我的心情 <span class="caret"></span>
	</button>
	<ul class="dropdown-menu">
		<li><a
			href="${pageContext.request.contextPath }/mood/list.action">所有心情</a></li>
		<li><a href="#">Another action</a></li>
		<li role="separator" class="divider"></li>
		<li><a href="#">Separated link</a></li>
	</ul>
</div>

<div class="btn-group">
	<button type="button" class="btn btn-default dropdown-toggle"
		data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		相册 <span class="caret"></span>
	</button>
	<ul class="dropdown-menu">
		<li><a
			href="${pageContext.request.contextPath }/album/list.action">相册列表</a></li>
		<li><a href="#">Another action</a></li>
		<li role="separator" class="divider"></li>
		<li><a href="#">Separated link</a></li>
	</ul>
</div>
	
</body>
</html>