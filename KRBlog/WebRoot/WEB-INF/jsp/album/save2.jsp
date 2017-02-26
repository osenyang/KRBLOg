<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- <title>
	<c:choose>
		<c:when test="${album.id == null}">新增相册</c:when>
		<c:otherwise>修改相册</c:otherwise>
	</c:choose>
</title> --%>

<script type="text/javascript">
<!--
$(function(){
	//$("form.kr_validate").validate();//jQueryvalidate 也是和模态框冲突，不起作用
	//$('form.kr_validate').bootstrapValidator();//总是和模态框发生冲突
	//$('#album_form').bootstrapValidator();//总是和模态框发生冲突
});
//-->
</script>
<!-- <div class="container"> -->

<!-- 显示错误信息 -->
<%-- <c:if test="${allErrors!=null }"> --%>
	<c:forEach items="${allErrors }" var="error">
		<font style="color: red;">${error.defaultMessage}</font><br/><!-- 因为这里使用了模态框，所以返回的页面是list。所以这里的消息不会出现 -->
	</c:forEach>
<%-- </c:if> --%>


<form class="form kr_validate" id="album_form" action="${pageContext.request.contextPath }/album/save.action" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${album.id }"/>

<table class="table table-striped">
<tr>
	<th>相册名称</th>
	<td>
		<input required
			class="form-control" type="text" name="name" value="${album.name}"/>
	</td>
</tr>
<tr>
	<th>相册描述</th>
	<td><input class="form-control" type="text" name="description" value="${album.description}"/></td>
</tr>
<tr>
	<th>所属类别</th>
	<td>
		<select class="form-control" name="typeId">
			<option value="" selected="selected">请选择</option>
        	<c:forEach items="${types}" var="type">
        		<option value="${type.id}">${type.type}</option>
       		</c:forEach>
        </select>
	</td>
</tr>

<tr>
	<th>相册封面</th>
	<td>
		<c:if test="${album.coverPath !=null}">
			<img src="${pageContext.request.contextPath }/${album.coverPath}" width=100 height=100/>
			<br/>
		</c:if>
		<input class="form-control" type="file"  name="img"/> 
	</td>
</tr>

<%-- <c:if test="${!empty album.id}">
	<tr>
		<td colspan="2"><a class="btn btn-default" href="${pageContext.request.contextPath }/album/encryptUI.action?id=${album.id}">加密</a></td>
	</tr>
</c:if> --%>

<!-- <tfoot>
	<tr>
		<td colspan="2" class="text-right">
		  <input class="btn btn-default" type="button" value="返回" onclick="history.back(-1);"/>
		  <input class="btn btn-primary" type="submit" value="确认"/>
		</td>
	</tr>
</tfoot> -->
</table>

</form>

<!-- </div> -->
