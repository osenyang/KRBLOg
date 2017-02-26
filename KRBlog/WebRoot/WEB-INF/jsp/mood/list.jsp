<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>我的心情</title>
<%-- <%@ include file="/WEB-INF/jsp/public/common.jspf"%> --%>
<!-- 首页顶部 -->
<%@ include file="/WEB-INF/jsp/index/head.jsp"%>
<style type="text/css">
.top {
	color: green;
}

.elite {
	color: orange;
}
</style>

<script type="text/javascript">
	$(document).ready(function(){
	    $('#mood_list_table').dataTable({
	    	"pagingType" : "full_numbers",// 控制分页按钮
	    	//"bSort": false,// 排序是否
	    	"order": [[ 3, "desc" ]] //默认排序，0是第一列
	    	/* "aoColumns": [ //哪一列无需排序
	    	              { "bSortable": false },
	    	              null,
	    	              { "bSortable": false },
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

	<div class="container" id="kr_main">
	
		<c:if test="${kr_session_manager != null}">
			<%@ include file="jspf/save.jspf"%>
		</c:if>

		    <div class="panel panel-success">
		    <div class="panel-heading">我的心情</div>
		    <div class="panel-body">
			<!-- <div class="panel-heading">不用这个头部</div> -->
			
		    <!-- border="1"和 table-bordered（bootstrap制定的）加上表格边框 -->
			<!-- table-striped 表示默认隔行加颜色 -->
			<table class="table table-hover" id="mood_list_table">
			<thead>
			<tr>
			    <th>内容</th>
			    <th width="8%">发表时间</th>
			    <th width="8%">标签</th>
			    <th width="8%" style="display:none;">置顶时间</th>
			    <th width="7%">被观看</th>
			    <th width="7%">回复数</th>
			    
			    <c:if test="${kr_session_manager != null}">
			    <th width="12%">操作</th>
			    </c:if>
			</tr>
			</thead>
			
			<tbody>
			<c:forEach items="${moodList}" var="mood">
			<tr>
			    <td >
			        <font class="top"><c:if test="${mood.isTop == true}">[置顶]</c:if></font>
			        <font class="elite"><c:if test="${mood.status == 6}">[精华]</c:if></font>
			        <a onclick="$.kr_detail('${pageContext.request.contextPath}/mood/detail.action?id=${mood.id}');"
			             href="#">
			            ${mood.content}
			        </a>
			    </td>
			    <td><fmt:formatDate value="${mood.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${mood.tag}</td>
			    <td style="display:none;"><fmt:formatDate value="${mood.topTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${mood.seeCount}</td>
			    <td>${mood.replyCount}</td>
			    
			    <c:if test="${kr_session_manager != null}">
			    <td>
			        <%@ include file="jspf/handle.jspf"%>
			    </td>
			    </c:if>
			    
			</tr>
			</c:forEach>
			</tbody>
			
			<tfoot>
            </tfoot>
			</table>
			
			</div><!-- /panel-body -->
			</div><!-- /panel-default -->
	
	</div> <!-- ====container -->
	
</body>
<%@ include file="/WEB-INF/jsp/index/bottom.jsp"%>
</html>