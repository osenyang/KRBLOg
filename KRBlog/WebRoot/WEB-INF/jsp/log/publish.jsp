<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>发表文章</title>
<!-- 首页顶部 -->
<%@ include file="/WEB-INF/jsp/index/head.jsp"%>
<style type="text/css">
	.small_main {
		width: 960px;
	}
</style>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/fckeditor/fckeditor.js"></script>
<script type="text/javascript">
	$(function(){
		var fck = new FCKeditor('advanced_content') ; // 提交表单时本字段使用的参数名
		fck.BasePath	= "${pageContext.request.contextPath}/js/fckeditor/" ; // 必须要有，这是指定editor文件夹所在的路径，一定要以'/'结尾
		fck.Height	= "600";
		fck.Width	= "100%";
		fck.ToolbarSet = "admin" ;//设置要应用的功能组（myconfig.js里面设置并且对应）
		fck.ReplaceTextarea(); // 替换id或name为指定值的textarea
		
		
		/* $(".select2").select2({
			language: 'zh-CN'
		});  */
	});
	
</script>
</head>
<body>

<div class="container small_main" id="kr_main">

	<div class="panel panel-info">
    <div class="panel-heading">发表文章</div>
	
	<form id="log_form" action="${pageContext.request.contextPath }/log/save.action" 
			class="form form-horizontal" method="post" role="form">
			
    <div class="panel-body">

		
		<input type="hidden" name="id" value="${log.id}"/>
		
		<%-- <div class="form-group">
			<label class="control-label" for="log_title">标题</label>
			<input class="form-control" id="log_title" type="text" name="title" value="${log.title}"/>
		</div>
		
		<div class="form-group">
			<label class="control-label" for="advanced_content">类别</label>
			<select class="form-control select2" name="typeId" style="width: 100%;">
				<option value="" selected="selected">请选择类别</option>
		      	<c:forEach items="${types}" var="type">
		      		<option value="${type.id}">${type.type}</option>
		     	</c:forEach>
		    </select>
		</div> --%>
		<div class="form-group">
			<label class="control-label col-lg-1" for="log_title">标题</label>
			<div class="col-lg-7">
				<input class="form-control" id="log_title" type="text" name="title" value="${log.title}"/>
			</div>
			<label class="control-label col-lg-1" for="advanced_content">类别</label>
			<div class="col-lg-3">
				<select class="form-control select2" name="typeId" style="width: 100%;">
					<option value="">请选择类别</option>
			      	<c:forEach items="${types}" var="type">
			      		<option value="${type.id}" ${type.type == log.type ? 'selected' : ''}>${type.type}</option>
			     	</c:forEach>
			    </select>
			</div>
		</div>
		
		<div class="form-group sr-only">
			<label class="control-label" for="advanced_content">内容</label>
		</div>
		<div class="form-group">
			<div class="col-lg-12">
			<textarea class="form-control" id="advanced_content" rows="2" name="content"
	        	>${log.content}</textarea>
	        </div>
		</div>
		

	</div><!-- /panel-body -->
	
	<div class="panel-footer">
		<div class="btn-group">
			<input type="submit" class="btn btn-primary" value="发表" />
			<!-- data-toggle="tooltip" data-placement="top" title="滔滔不绝，就是这么任性哈" -->
			<c:choose>
				<c:when test="${log.status == 2}">
					<label class="btn btn-default" 
				    	style="padding-bottom: 5px; padding-top: 5px;">
				    	<input name="status" value="1" type="checkbox"> 正式发表
				    </label>
				</c:when>
				<c:otherwise>
					<label class="btn btn-default" 
				    	style="padding-bottom: 5px; padding-top: 5px;">
				    	<input name="status" value="2" type="checkbox"> 存为草稿
				    </label>
				</c:otherwise>
			</c:choose>
		    
		    <label class="btn btn-default" 
		    	style="padding-bottom: 5px; padding-top: 5px;">
		    	<input name="isSecret" value="5" type="checkbox"> 加密
		    </label>
		    
		</div>
		&nbsp;&nbsp;
		<a class="btn btn-default" href="<%=path%>/log/list.action">返回</a>
	</div><!-- /panel-footer -->
		
	</form>
	</div><!-- /panel-info -->
	
</div> <!-- ====container -->
</body>

<%@ include file="/WEB-INF/jsp/index/bottom.jsp"%>
</html>