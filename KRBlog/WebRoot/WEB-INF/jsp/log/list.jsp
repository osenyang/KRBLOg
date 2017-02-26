<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>我的日志</title>
<!-- 首页顶部 -->
<%@ include file="/WEB-INF/jsp/index/head.jsp"%>
<script type="text/javascript">
	$(document).ready(function(){
	    $('#log_list_table').dataTable({
	    	"pagingType" : "full_numbers",// 控制分页按钮
	    	//"bSort": false,// 排序是否
	    	"order": [[ 3, "desc" ]] //默认排序，0是第一列
	    	/* "aoColumns": [ //哪一列无需排序
	    	              { "bSortable": false },
	    	              null,
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

	<div class="container" id="kr_main">
	
		    <div class="panel panel-info">
		    <div class="panel-heading">日志列表</div>
		    <div class="panel-body">
			<!-- <div class="panel-heading">不用这个头部</div> -->
			
		    <!-- border="1"和 table-bordered（bootstrap制定的）加上表格边框 -->
			<!-- table-striped 表示默认隔行加颜色 -->
			<table class="table table-hover" id="log_list_table">
			<thead>
			<tr>
			    <th>标题</th>
			    <th width="8%">发表时间</th>
			    <th width="8%">类别</th>
			    <th width="8%" style="display:none;">置顶时间</th>
			    <th width="7%">被观看</th>
			    <th width="7%">回复数</th>
			    <c:if test="${kr_session_manager != null}">
			    <th width="12%">操作</th>
			    </c:if>
			</tr>
			</thead>
			
			<c:forEach items="${logList}" var="log">
			<tr>
			    <td >
			        <font class="top"><c:if test="${log.isTop == true}">[置顶]</c:if></font>
			        <font class="elite"><c:if test="${log.status == 6}">[精华]</c:if></font>
			        <a onclick="$.kr_detail('${pageContext.request.contextPath}/log/detail.action?id=${log.id}');"
			             href="#">
			            ${log.title}
			        </a>
			    </td>
			    <td><fmt:formatDate value="${log.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${log.type}</td>
			    <td style="display:none;"><fmt:formatDate value="${log.topTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${log.seeCount}</td>
			    <td>${log.replyCount}</td>
			    
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
				   <td colspan="6">
						<a class="btn btn-default" 
						     onclick="$.kr_form('${pageContext.request.contextPath }/log/saveUI.action', 'log_form', '发表日志', 'lg');"
						     href="#" >写日志</a>
						     
						<a class="btn btn-default" 
						     href="${pageContext.request.contextPath }/log/saveUI.action?publish=1" >发表文章</a>
					</td>
				</tr>
			</tfoot>
			</c:if>
			</table>
			
			</div><!-- /panel-body -->
			</div><!-- /panel-default -->
	
	</div> <!-- ====container -->
	
</body>

<%@ include file="/WEB-INF/jsp/index/bottom.jsp"%>
</html>
