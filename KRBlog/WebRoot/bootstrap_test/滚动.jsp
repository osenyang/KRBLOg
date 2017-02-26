<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

<script type="text/javascript">
$(function(){
	//$('body').scrollspy({ target: '#navbar-example' })
});

</script>

<head>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<title>Insert title here</title>
</head>
<body data-spy="scroll" data-target="#navbar-example">
  ...
  <div id="navbar-example" style="border: 1px solid;width: 600px;height: 6000px;">
    <ul class="nav nav-tabs" role="tablist">
      ...
    </ul>
  </div>
  ...
</body>
</html>