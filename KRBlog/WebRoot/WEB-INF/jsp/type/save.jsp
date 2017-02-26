<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- 显示错误信息 -->
<c:forEach items="${allErrors }" var="error">
	<font style="color: red;">${error.defaultMessage}</font><br/>
</c:forEach>


<form class="form form-horizontal kr_validate" id="type_form" action="${pageContext.request.contextPath }/manage/type/save.action" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${type.id }"/>


<div class="form-group">
    <label for="form_type_name" class="col-sm-2 control-label">类别名称</label>
    <div class="col-sm-10">
    	<input required id="form_type_name"
			class="form-control" type="text" name="type" value="${type.type}"/>
    </div>
</div>
<div class="form-group">
    <label for="form_type_mark" class="col-sm-2 control-label">应用与</label>
    <div class="col-sm-10">
    	<select class="form-control" id="form_type_mark" name="mark">
			<option value="all">全部</option>
			<option value="mood">心情</option>
			<option value="log">日志</option>
			<option value="album">相册</option>
			<option value="video">视频</option>
			<option value="works">作品</option>
		</select>
    </div>
</div>



</form>

<!-- =================================================================================== -->
