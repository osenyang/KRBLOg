<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<title>Insert title here</title>
</head>
<body>
<a class="btn btn-default" href="#" role="button">Link</a>
<button class="btn btn-default" type="submit">Button</button>
<input class="btn btn-default" type="button" value="Input">
<input class="btn btn-default" type="submit" value="Submit">

<!-- 预定义样式 -->
<!-- Standard button -->
<button type="button" class="btn btn-default">（默认样式）Default</button>

<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
<button type="button" class="btn btn-primary">（首选项）Primary</button>

<!-- Indicates a successful or positive action -->
<button type="button" class="btn btn-success">（成功）Success</button>

<!-- Contextual button for informational alert messages -->
<button type="button" class="btn btn-info">（一般信息）Info</button>

<!-- Indicates caution should be taken with this action -->
<button type="button" class="btn btn-warning">（警告）Warning</button>

<!-- Indicates a dangerous or potentially negative action -->
<button type="button" class="btn btn-danger">（危险）Danger</button>

<!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
<button type="button" class="btn btn-link">（链接）Link</button>

<!-- 使用 .btn-lg、.btn-sm 或 .btn-xs 就可以获得不同尺寸的按钮。 -->
<p>
  <button type="button" class="btn btn-primary btn-lg">（大按钮）Large button</button>
  <button type="button" class="btn btn-default btn-lg">（大按钮）Large button</button>
</p>
<p>
  <button type="button" class="btn btn-primary">（默认尺寸）Default button</button>
  <button type="button" class="btn btn-default">（默认尺寸）Default button</button>
</p>
<p>
  <button type="button" class="btn btn-primary btn-sm">（小按钮）Small button</button>
  <button type="button" class="btn btn-default btn-sm">（小按钮）Small button</button>
</p>
<p>
  <button type="button" class="btn btn-primary btn-xs">（超小尺寸）Extra small button</button>
  <button type="button" class="btn btn-default btn-xs">（超小尺寸）Extra small button</button>
</p>

<!-- 通过给按钮添加 .btn-block 类可以将其拉伸至父元素100%的宽度，而且按钮也变为了块级（block）元素。 -->
<button type="button" class="btn btn-primary btn-lg btn-block">（块级元素）Block level button</button>
<button type="button" class="btn btn-default btn-lg btn-block active">（块级元素）Block level button</button><!-- active 激活（按下）状态 -->
 <!-- disabled="disabled" 表示禁用 -->
<button type="button" class="btn btn-default btn-lg" disabled="disabled">Button</button>


<!-- 通过为图片添加 .img-responsive 类可以让图片支持响应式布局。其实质是为图片设置了 max-width: 100%;、 height: auto; 和 display: block; 属性 -->
<img src="../img/test.gif" alt="..." class="img-rounded">
<img src="../img/test.gif" alt="..." class="img-circle">
<img src="../img/test.gif" alt="..." class="img-thumbnail">

<!-- 通过颜色来展示意图，Bootstrap 提供了一组工具类。这些类可以应用于链接，并且在鼠标经过时颜色可以还可以加深，就像默认的链接一样。 -->
<p class="text-muted">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="text-primary">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="text-success">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="text-info">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="text-warning">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="text-danger">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>


<!-- 情境背景色 -->
<p class="bg-muted">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="bg-primary">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="bg-success">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="bg-info">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="bg-warning">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="bg-danger">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>

<!-- 关闭按钮 -->
<button type="button" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></button>
<!-- 三角符号 -->
<span class="caret"></span>
<!-- 快速浮动 -->
<!-- 排列导航条中的组件时可以使用这些工具类：.navbar-left 或 .navbar-right -->
<div class="pull-left">...</div>
<div class="pull-right">...</div>

<!-- 为任意元素设置 display: block 属性并通过 margin 属性让其中的内容居中 -->
<!-- .center-block {
  display: block;
  margin-left: auto;
  margin-right: auto;
} -->
<div class="center-block">...</div>

<!-- 清除浮动 -->
<div class="clearfix">...</div>

<!-- .show 和 .hidden 类可以强制任意元素显示或隐藏 -->
<!-- .invisible 类可以被用来仅仅影响元素的可见性 -->
<div class="show">...</div>
<div class="hidden">...</div>

<!-- .sr-only 类可以对屏幕阅读器以外的设备隐藏内容。.sr-only 和 .sr-only-focusable 联合使用的话可以在元素有焦点的时候再次显示出来（例如，使用键盘导航的用户） -->
<a class="sr-only sr-only-focusable" href="#content">Skip to main content</a>


<!-- 图片替换
使用 .text-hide 类或对应的 mixin 可以用来将元素的文本内容替换为一张背景图。 -->
<h1 class="text-hide">Custom heading</h1>


</body>
</html>