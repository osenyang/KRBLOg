<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>
<!--

footer {
	/* color: #666; */
	/* background-color: #fff; *//* #2A2730; */
	padding-top: 20px;
	
	width: auto;
	height: 190px;
	
	
	/* position: relative;
	bottom: 0px; */
	
	border-top: 1px solid #ebebeb;
	
}



#wechatImg {
	
	margin-top: 22px; 
	width: 200px;
	/* float: left;  */
}
#wechatImg img {
	max-height: 110px;
	border-radius: 6px;
}

#kr_link {
	/* margin-top: 10px; */
	width: 770px; 
	/* float: left;  */
	border-left: 1px solid #DDDDDD;
	padding-left: 26px;
}

#krblog {
	/* margin-top: 16px; */
	/* margin-bottom: 10px; */
	
	font-weight: bolder;
	font-size: 16px;
}

.kr_clock {
	margin-top: 5px; 
	/* float: left;  */
}

.copyright{
	padding-top: 124px;
}
-->
</style>

<footer>
<div class="container">
	<div class="row">
	
	<div class="col-lg-2 col-xs-2">
		<div id="wechatImg">
			<img data-toggle="tooltip" data-placement="top" title="扫码联系我" src="<%=path%>/style/img/OsenYang.jpg">
		</div>
	</div>
	
	<div class="col-lg-3 col-xs-3">
		<div id="kr_link">
			<div id="krblog">狂人BLOg</div>
			<ul>
				<li><a href="<%=path %>/mood/list.action">心情</a></li>
				<li><a href="<%=path %>/log/list.action">日志</a></li>
				<li><a href="<%=path %>/album/list.action">相册</a></li>
				<li><a href="<%=path %>/message/list/paging.action">留言板</a></li>
				<li><a href="<%=path %>/video/list.action">视频</a></li>
				<li><a href="<%=path %>/user/list.action">发布需求</a></li>
				<li><a href="<%=path %>/user/list.action">关于我</a></li>
			</ul>
		</div>
	</div>
	
	<div class="col-lg-5 copyright">
		<div>Copyright © 2017 <font class="orange">KuangREn company - osenYang</font> All Rights Reserved.</div>
	</div>
	
	<div class="col-lg-2 col-xs-2">
		<div class="kr_clock">
			<%@ include file="/WEB-INF/jsp/index/jspf/clock.jspf" %>
		</div>
	</div>
	
	</div>
</div>
</footer>
