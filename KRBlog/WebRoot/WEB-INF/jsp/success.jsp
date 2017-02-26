<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/jsp/public/common.jspf" %>
<title>成功提示</title>

<script type="text/javascript">
$(function(){
	noty({text: "操作成功！", type: 'success'});
});
</script>
</head>
<body>
操作成功！
</body>
</html>