<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>狂人BLOg</title>
	
<%@ include file="/WEB-INF/jsp/index/head.jsp" %>

</head>
<body>
<div class="container" id="kr_main">

<div class="row">
<div class="col-lg-7 col-xs-3">
	<%@ include file="/WEB-INF/jsp/index/jspf/headPhoto.jspf" %>
</div>
<div class="col-lg-5">
	<%@ include file="/WEB-INF/jsp/index/jspf/frontLog.jspf" %>
</div>
</div><!-- //row -->

<div class="row">
<div class="col-lg-5">
	<%@ include file="/WEB-INF/jsp/index/jspf/frontMessage.jspf" %>
</div>
<div class="col-lg-7">
	<%@ include file="/WEB-INF/jsp/index/jspf/frontMood.jspf" %>
</div>
</div><!-- //row -->


</div><!-- //container -->
</body>

<%@ include file="/WEB-INF/jsp/index/bottom.jsp"%>
</html>