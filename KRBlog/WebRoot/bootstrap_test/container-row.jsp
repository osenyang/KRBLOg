<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<title>Insert title here</title>
<style type="text/css">
div {
    border: solid;
    border-color: blue;
    background-color: white;
}
</style>

</head>
<body>

<div class="container-fluid">

	<div class="row">
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	</div>
	<div class="row">
	  <div class="col-md-8">.col-md-8</div>
	  <div class="col-md-4">.col-md-4</div>
	</div>
	<div class="row">
	  <div class="col-md-4">.col-md-4</div>
	  <div class="col-md-4">.col-md-4</div>
	  <div class="col-md-4">.col-md-4</div>
	</div>
	<div class="row">
	  <div class="col-md-6">.col-md-6</div>
	  <div class="col-md-6">.col-md-6</div>
	</div>
	
	<!-- 使用 .col-md-offset-* 类可以将列向右侧偏移 -->
	<div class="row">
	  <div class="col-md-4">.col-md-4</div>
	  <div class="col-md-4 col-md-offset-4">.col-md-4 .col-md-offset-4</div>
	</div>
	<div class="row">
	  <div class="col-md-3 col-md-offset-3">.col-md-3 .col-md-offset-3</div>
	  <div class="col-md-3 col-md-offset-3">.col-md-3 .col-md-offset-3</div>
	</div>
	<div class="row">
	  <div class="col-md-6 col-md-offset-3">.col-md-6 .col-md-offset-3</div>
	</div>  
	
	
	<!-- 通过使用 .col-md-push-* 和 .col-md-pull-* 类就可以很容易的改变列（column）的顺序。 -->
	<div class="row">
	  <div class="col-md-9 col-md-push-3">.col-md-9 .col-md-push-3</div>
	  <!-- <div class="col-md-3 col-md-pull-9">.col-md-3 .col-md-pull-9</div> -->
	</div>
	<div class="row">
	  <!-- <div class="col-md-9 col-md-push-3">.col-md-9 .col-md-push-3</div> -->
	  <div class="col-md-3 col-md-pull-9">.col-md-3 .col-md-pull-9</div>
	</div>
</div>
</body>
</html>