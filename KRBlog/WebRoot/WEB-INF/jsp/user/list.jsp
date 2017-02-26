<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>用户管理</title>
<!-- 首页顶部 -->
<%@ include file="/WEB-INF/jsp/index/head.jsp"%>

<style>
    .userImg {
        max-height: 100px; 
        /* border-radius: 10px; */
    }
</style>

<script type="text/javascript">
    $(document).ready(function(){
        $('#user_list_table').dataTable({
        	"order": [[ 5, "desc" ]],
        	"aoColumns": [ //哪一列无需排序
                           { "bSortable": false },
                           { "bSortable": false },
                           { "bSortable": false },
                           { "bSortable": false },
                           null,
                           null,
                           null,
                           { "bSortable": false }
                         ]
        });
    });
</script>


</head>
<body> 
<!-- 首页顶部 -->
<%-- <%@ include file="/WEB-INF/jsp/index/head.jsp"%> --%>

<div class="container" id="kr_main">
<div class="panel panel-success">
<div class="panel-heading">用户管理</div>
<div class="panel-body">

<table class="table table-hover" id="user_list_table">
<thead>
<tr>
	<th width="17%">头像</th>
	<th>登录名</th>
	<th>用户名</th>
	<th>邮箱</th>
	<th width="7%">状态</th>
	<th width="12%">注册时间</th>
	<th width="12%">上次登录</th>
	<th width="12%">操作</th>
</tr>
</thead>
<c:forEach items="${userList}" var="user">
<tr>
	<td>
		<c:if test="${user.imgPath !=null}">
		  <a class="thumbnail">
		       <!-- class="img-thumbnail" 给图片加上，会给图片边框 -->
			<img class="userImg" src="${pageContext.request.contextPath}/${user.imgPath}" />
		  </a>
		</c:if>
	</td>
	<td><a href="#"
		onclick="$.kr_detail('${pageContext.request.contextPath}/free/user/detail.action?id=${user.id}', '用户详情');"
		>${user.loginName}</a></td>
	<td>${user.name}</td>
	<td>${user.email}</td>
	<td>
		<c:if test="${user.status==0}">已禁用</c:if>
		<c:if test="${user.status==1}">正常</c:if>
		<c:if test="${user.status==6}">超级管理员</c:if>
	</td>
	<td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td> 
	<td><fmt:formatDate value="${user.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td> 
	
	<td>
		<%@ include file="jspf/handle.jspf"%>
	</td>
</tr>
</c:forEach>

</table>

</div><!-- /panel-body -->
</div>

</div><!-- /container -->
</body>
<%@ include file="/WEB-INF/jsp/index/bottom.jsp"%>
</html>