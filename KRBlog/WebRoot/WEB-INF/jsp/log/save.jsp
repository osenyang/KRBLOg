<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/fckeditor/fckeditor.js"></script>
<script type="text/javascript">
	$(function(){
		var fck = new FCKeditor('advanced_content') ; // 提交表单时本字段使用的参数名
		fck.BasePath	= "${pageContext.request.contextPath}/js/fckeditor/" ; // 必须要有，这是指定editor文件夹所在的路径，一定要以'/'结尾
		fck.Height	= "360";
		fck.Width	= "100%";
		fck.ToolbarSet = "log" ;//设置要应用的功能组（myconfig.js里面设置并且对应）
		fck.ReplaceTextarea(); // 替换id或name为指定值的textarea
		
		
		/* $(".select2").select2({
			language: 'zh-CN'
		});  */
	});
	
</script>

<form id="log_form" action="${pageContext.request.contextPath }/log/save.action" 
	class="form form-horizontal" method="post" role="form">
<input type="hidden" name="id" value="${log.id}"/>

<div class="form-group">
	<label class="control-label col-lg-1" for="log_title">标题</label>
	<div class="col-lg-7">
		<input class="form-control" id="log_title" type="text" name="title" value="${log.title}"/>
	</div>
<!-- </div>

<div class="form-group"> -->
	<label class="control-label col-lg-1" for="advanced_content">类别</label>
	<div class="col-lg-3">
		<select class="form-control select2" name="typeId" style="width: 100%;">
			<option value="" selected="selected">请选择类别</option>
	      	<c:forEach items="${types}" var="type">
	      		<option value="${type.id}">${type.type}</option>
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


</form>

<!-- ==================================================================== -->
