<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>我的相册</title>
<!-- 首页顶部 -->
<%@ include file="/WEB-INF/jsp/index/head.jsp"%>

<style>
    img{
        max-height: 100px; 
    }
</style>

<script type="text/javascript">
    $(document).ready(function(){
        $('#album_list_table').dataTable({
        	"order": [[ 4, "desc" ]]
        	/* "aoColumns": [ //哪一列无需排序
                           { "bSortable": false },
                           { "bSortable": false },
                           { "bSortable": false },
                           null,
                           null,
                           null,
                           null,
                           { "bSortable": false }
                         ] */
        });
    });
</script>


</head>
<body> 
<!-- 首页顶部 -->
<%-- <%@ include file="/WEB-INF/jsp/index/head.jsp"%> --%>

<div class="container" id="kr_main">
<div class="panel panel-danger">
<div class="panel-heading">我的相册</div>
<div class="panel-body">

<table class="table table-hover" id="album_list_table">
<thead>
<tr>
	<th width="17%">预览</th>
	<th>名称</th>
	<th>描述</th>
	<th width="7%">类别</th>
	<th width="8%">创建时间</th>
	<th width="7%">被观看</th>
	<th width="7%">回复数</th>
	<c:if test="${kr_session_manager != null}">
	<th width="9%">操作</th>
	</c:if>
</tr>
</thead>
<c:forEach items="${albumList}" var="album">
<tr>
	<td>
		<c:if test="${album.coverPath !=null}">
		  <a class="thumbnail">
		       <!-- class="img-thumbnail" 给图片加上，会给图片边框 -->
			<img src="${pageContext.request.contextPath}/${album.coverPath}" />
		  </a>
		</c:if>
	</td>
	<td><a href="${pageContext.request.contextPath}/album/detail.action?id=${album.id}">${album.name}</a></td>
	       <%-- onclick="$.kr_detail('${pageContext.request.contextPath}/album/detail.action?id=${album.id}', '相册详情');" --%>
	<td>${album.description}</td>
	<td>${album.type}</td>
	<td><fmt:formatDate value="${album.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td> 
	<td>${album.seeCount}</td>
	<td>${album.replyCount}</td>
	
	<c:if test="${kr_session_manager != null}">
	<td>
		<%@ include file="jspf/handle.jspf"%>
	</td>
	</c:if>
</tr>
</c:forEach>

<c:if test="${kr_session_manager != null}">
<tfoot>
	<tr>
	   <td colspan="8">
			<a class="btn btn-default" 
			     onclick="$.kr_form('${pageContext.request.contextPath }/album/saveUI.action', 'album_form', '新增相册', 'lg');"
			     href="#" >新增</a>
		</td>
	</tr>
</tfoot>
</c:if>
</table>

</div><!-- /panel-body -->
</div>

</div><!-- /container -->
</body>
<%@ include file="/WEB-INF/jsp/index/bottom.jsp"%>
</html>