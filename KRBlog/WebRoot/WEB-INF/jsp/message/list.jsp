<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>留言板</title>
<!-- 首页顶部 -->
<%@ include file="/WEB-INF/jsp/index/head.jsp"%>

<style type="text/css">
.orange {
	color: #EE7942;
}

.parent_div {
	border: dashed 1px #F5DEB3;
	/* background-color: #FFFFF0; */
	margin-left: 20px;
	margin-bottom: 16px;
	padding: 6px;
}

.user_info {
	/* background-color: #FFF; */
	border-right: 1px dashed #ddd;
}

.user_img {
	height: 50px;
	width: 50px;
	border-radius: 25px;
	/* border: 1px solid; */
}

</style>

<script type="text/javascript">
	/* $(document).ready(function(){
	    $('#message_list_table').dataTable({
	    	"pagingType" : "full_numbers",// 控制分页按钮
	    	//"bSort": false,// 排序是否
	    	"order": [[ 2, "desc" ]] //默认排序，0是第一列
	    	/* "aoColumns": [ //哪一列无需排序
	    	              { "bSortable": false },
	    	              null,
	    	              null,
	    	              { "bSortable": false },
	    	              { "bSortable": false }
	    	            ]  
	    });
	    
	});   */
</script>
</head>
<body>

	<div class="container" id="kr_main">
	
	<c:if test="${sendWordMesg != null}">
	    <div class="panel panel-danger">
	    <div class="panel-heading">主人寄语</div>
	    <div class="panel-body">
	    	<div id="send_word">${sendWordMesg.content}</div>
	    </div>
	    </div>
	</c:if>
		    
		    
		<%@ include file="jspf/save.jspf"%>
			<div class="panel-group" id="accordion">
		    <div class="panel panel-danger">
		    <div class="panel-body">
			<!-- <div class="panel-heading">不用这个头部</div> -->
			
		    <!-- border="1"和 table-bordered（bootstrap制定的）加上表格边框 -->
			<!-- table-striped 表示默认隔行加颜色 -->
			<table class="table table-striped" id="message_list_table">
			<thead>
			<tr>
			    <th width="9%">用户信息</th>
			    <th>内容</th>
			    <th width="8%">发表时间</th>
			    <th width="7%">第几楼</th>
			    <!-- <th width="7%">IP</th> -->
			    <!-- <th width="7%">回复数</th> -->
			    <c:if test="${kr_session_manager != null}">
			    <th width="10%">操作</th>
			    </c:if>
			</tr>
			</thead>
			
			<tbody>
			<c:forEach items="${pagingBean.poList}" var="message">
			<%@ include file="jspf/reply_list.jspf"%>
			<tr>
				<td class="user_info text-center">
					<c:if test="${!empty message.user.imgPath}">
						<img class="user_img" alt="" src="${pageContext.request.contextPath}/${message.user.imgPath}">
						<br>
					</c:if>
					<font class="green">${message.nickname}</font>
				</td>
			    <td>
			    	<c:if test="${message.parent != null}">
				    	<div class="parent_div">
				    		<strong>回复第 ${message.parent.floor} 楼<c:if test="${message.parent.nickname != null}"> "${message.parent.nickname}"</c:if>：</strong>
				    		<br>
				    		${message.parent.content}
				    	</div>
			    	</c:if>
			    	<%-- onclick="$.kr_detail('${pageContext.request.contextPath}/message/detail.action?id=${message.id}');" --%>
			        <div class="font_content">
			            <%-- <c:if test="${message.nickname != null}">"${message.nickname}"说：</c:if> --%>${message.content}
			        </div>
			        <%@ include file="jspf/reply.jspf"%>
				</td>
			    <td><fmt:formatDate value="${message.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td class="orange">${message.floor}</td>
			    <%-- <td>${message.ip}</td> --%>
			    
			    <c:if test="${kr_session_manager != null}">
			    <td>
			        <%@ include file="jspf/handle.jspf"%>
			    </td>
			    </c:if>
			</tr>
			</c:forEach>

			</tbody>
			
			<tfoot>
				<tr>
					<td colspan="5">
						<form action="<%=path %>/message/list/paging.action" id="page_form">
				        <%@ include file="../public/paging.jspf"%>
						</form>
				    </td>
				</tr>
            </tfoot>
			</table>
			
			</div><!-- /panel-body -->
			</div><!-- /panel-default -->
			</div>
	
	</div> <!-- ====container -->
	
</body>
<%@ include file="/WEB-INF/jsp/index/bottom.jsp"%>
</html>