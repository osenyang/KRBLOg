<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/jsp/public/common.jspf" %>

<!-- 路径导航 -->
<%-- <%@ include file="/WEB-INF/jsp/index/breadcrumb.jspf"%> --%>

<style>
<!--
.navbar-default {
	/* background-color: #fff; */
}
-->
</style>

<script type="text/javascript">
$(function(){
	
	/* $.gotoUrl = function(url, dom){
        //divId = "#" + divId;
        $(dom).load(url);
    }; */
    
});
</script>

<!-- ======================================================================================= -->
<nav id="navbar-index" class="navbar navbar-default navbar-fixed-top"><!-- navbar-inverse 反色 -->
<div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand">
            <!-- <span class="glyphicon glyphicon-grain" aria-hidden="true"></span> -->
            <strong>Kuang<small>R</small>en</strong> 
        </a>
    </div>
    <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li role="presentation"> <!-- class="active" -->
                <a href="${pageContext.request.contextPath }" 
                data-toggle="tooltip" data-placement="bottom" title="首页">
                    <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                </a>
            </li>
            
            <li class="dropdown">
                <a id="drop1" href="#"
                class="dropdown-toggle" data-toggle="dropdown" role="button"
                aria-haspopup="true" aria-expanded="false">
                                                    心情 <span class="caret"></span><!-- 倒三角图标 -->
                </a>
                <ul class="dropdown-menu" aria-labelledby="drop1">
                    <li><a href="${pageContext.request.contextPath }/mood/list.action">
                        <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                                                            心情</a></li>
                    <li role="separator" class="divider"></li>
                    <%-- <li><a href="#" onclick="$.gotoUrl('${pageContext.request.contextPath }/mood/list.action', '#mainDiv');">动态加载心情列表</a></li> --%>
                    <li><a href="#"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                                                            标签</a></li>
                </ul>
            </li>
            
            <li class="dropdown">
                <a id="drop2" href="#"
                class="dropdown-toggle" data-toggle="dropdown" role="button"
                aria-haspopup="true" aria-expanded="false">
                                                    日志 <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" aria-labelledby="drop2">
                    <li><a href="${pageContext.request.contextPath }/log/list.action">
                        <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                                                            日志</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">日志分类</a></li>
                </ul>
            </li>
            
            <li class="dropdown">
                <a id="drop2" href="#"
                class="dropdown-toggle" data-toggle="dropdown" role="button"
                aria-haspopup="true" aria-expanded="false">
                                                    相册 <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" aria-labelledby="drop2">
                    <li><a href="${pageContext.request.contextPath }/album/list.action">
                        <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                                                            相册</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">相册分类</a></li>
                </ul>
            </li>
            
            <%-- <li><a href="${pageContext.request.contextPath }/message/list.action">留言板</a></li> --%>
            <li><a href="${pageContext.request.contextPath }/message/list/paging.action">留言板</a></li>
            
            <li class="dropdown">
                <a id="drop2" href="#"
                class="dropdown-toggle" data-toggle="dropdown" role="button"
                aria-haspopup="true" aria-expanded="false">关于我 <span
                    class="caret"></span>
                </a>
                <ul class="dropdown-menu" aria-labelledby="drop2">
                    <li><a href="${pageContext.request.contextPath }/album/list.action">作品展示</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">关于我</a></li>
                    <li><a href="#">我的简历</a></li>
                </ul>
            </li>
            
            <li><a href="#">视频</a></li>
            
            <li class="dropdown">
                <a id="drop2" href="#"
                class="dropdown-toggle" data-toggle="dropdown" role="button"
                aria-haspopup="true" aria-expanded="false">新闻 / 公告 <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" aria-labelledby="drop2">
                    <li><a href="#">新闻</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">公告</a></li>
                </ul>
            </li>
            
            <li><a href="${pageContext.request.contextPath }/album/list.action">发布需求</a></li>
            
            <li class="dropdown">
                <a id="drop2" href="#"
                class="dropdown-toggle" data-toggle="dropdown" role="button"
                aria-haspopup="true" aria-expanded="false">其他 <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" aria-labelledby="drop2">
                    <li><a href="#">访客</a></li>
                    <li><a href="#">网站统计</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="${pageContext.request.contextPath }/manage/type/list.action">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                                                            类别管理</a></li>
                    <li><a href="${pageContext.request.contextPath }/free/user/list/manage.action">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                                                            用户管理</a></li>
                </ul>
            </li>
        </ul>
        <!-- 搜索表单form -->
        <%@ include file="/WEB-INF/jsp/index/jspf/search.jspf"%>

        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${kr_session_user != null || kr_session_manager != null}">
                	<li><a onclick="$.kr_confirm('${pageContext.request.contextPath}/free/user/logout.action', '确定退出吗？');" 
                			href="#">退出</a>
                	</li>
                </c:when>
                
                <c:otherwise><li><a href="#"
                	onclick="$.kr_form('${pageContext.request.contextPath }/free/user/saveUI.action', 'user_form', '用户注册', 'md');"
                	>注册</a></li></c:otherwise>
            </c:choose>
            
            
            <c:choose>
                <c:when test="${kr_session_user != null || kr_session_manager != null}">
                	<li id="fat-menu" class="dropdown">
	                	<a id="drop3" href="#"
			                class="dropdown-toggle" data-toggle="dropdown" role="button"
			                aria-haspopup="true" aria-expanded="false">
			                <c:if test="${kr_session_manager != null}"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></c:if>
			                <font class="orange">${kr_session_manager.name}${kr_session_user.name}</font>
			                <span class="caret"></span>
			            </a>
		                <ul class="dropdown-menu" aria-labelledby="drop3">
		                    <li><a href="#">用户信息</a></li>
		                    <li><a href="#">我的收藏</a></li>
		                    <li><a href="#">我的留言</a></li>
		                    <li><a href="#">回复我的</a></li>
		                    <li role="separator" class="divider"></li>
		                    <li><a href="#">修改资料</a></li>
		                </ul>
		            </li>
				</c:when>
                <c:otherwise>
					<li>
                        <a href="#" data-toggle="modal" data-target="#kr_login_modal">登录</a>
                    </li>
                </c:otherwise>
            </c:choose>
            
        </ul>
        
    </div> <!-- /.nav-collapse -->
</div> <!-- /.container-fluid --> 
</nav> <!-- /navbar-example -->

<!-- <span class="glyphicon glyphicon-plane" aria-hidden="true"></span> -->
<div id="goTopBtn" data-toggle="tooltip" data-placement="left" title="返回顶部">Top</div>
<!-- ======================================================================================= -->
<%@ include file="/WEB-INF/jsp/index/login_modal.jspf"%>
