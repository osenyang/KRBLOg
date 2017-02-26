<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<title>Insert title here</title>

<style type="text/css">
img {
    max-height: 200px;
    width: auto;
}

#carousel-example-generic{
    width: 666px;
}
</style>
</head>
<body>
<div class="container">

<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="../img/kuangren.gif" alt="...">
      <div class="carousel-caption">
                    狂人
      </div>
    </div>
    <div class="item">
      <img src="../img/xf.jpg" alt="...">
      <div class="carousel-caption">
        <h4>标题</h4>
        <p>爱情信封</p>
      </div>
    </div>
    <div class="item">
      <img src="../img/home.jpg" alt="...">
      <div class="carousel-caption">
        <h4>标题</h4>
                    梦想家园
      </div>
    </div>
    <div class="item">
      <img src="../img/1314.jpg" alt="...">
      <div class="carousel-caption">
        1314
      </div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

</div>
</body>
</html>