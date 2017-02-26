<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>类别管理</title>
<!-- 首页顶部 -->
<%@ include file="/WEB-INF/jsp/index/head.jsp"%>

<script type="text/javascript">
    $(document).ready(function(){
        $('#type_list_table').dataTable({
        	"order": [[ 1, "desc" ]],
        	"aoColumns": [ //哪一列无需排序
                           { "bSortable": false },
                           null,
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
<div class="container" id="kr_main">
<div class="panel panel-success">
<div class="panel-heading">类别管理</div>
<div class="panel-body">

<table class="table table-striped" id="type_list_table">
<thead>
<tr>
	<th>名称</th>
	<th width="14%">创建时间</th>
	<th width="7%">标记</th>
	<th width="7%">加密</th>
	<th width="7%">被引用</th>
	<th width="10%">操作</th>
</tr>
</thead>

<tbody>
<c:forEach items="${typeList}" var="type">
<tr>
	<td class="font_content">${type.type}</td>
	<td><fmt:formatDate value="${type.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${type.mark}</td>
	<td>${type.isSecret}</td>
	<td>${type.used}</td>
	
	<td>
		<%@ include file="jspf/handle.jspf"%>
	</td>
</tr>
</c:forEach>
</tbody>

<tfoot>
	<tr>
	   <td colspan="6"><%--切记，如果这个数写错了，datatable 会异常 --%>
			<a class="btn btn-default" 
			     onclick="$.kr_form('${pageContext.request.contextPath }/manage/type/saveUI.action', 'type_form', '新增类别', 'md');"
			     href="#" >新增</a>
		</td>
	</tr>
</tfoot>
</table>

</div><!-- /panel-body -->
</div>

</div><!-- /container -->
</body>
<%@ include file="/WEB-INF/jsp/index/bottom.jsp"%>
</html>