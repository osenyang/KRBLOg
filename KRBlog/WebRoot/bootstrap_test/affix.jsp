<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$('#myAffix').affix({
		  offset: {
		    top: 1000,
		    bottom: function () {
		      return (this.bottom = $('.footer').outerHeight(true))
		    }
		  }
		})
});

</script>
</head>
<body>
<div id="myAffix" data-spy="affix" data-offset-top="60" data-offset-bottom="200"
style="border: 1px solid;width: 600px;height: 6000px;">
  ...affix...affix...affix...affix...affix...affix
</div>
</body>
</html>