<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<form class="form form-horizontal kr_validate" id="album_form" action="${pageContext.request.contextPath }/album/save.action" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${album.id }"/>

<div class="form-group">
    <label for="form_album_name" class="col-sm-2 control-label">相册名称</label>
    <div class="col-sm-10">
    	<input required id="form_album_name"
			class="form-control" type="text" name="name" value="${album.name}"/>
    </div>
</div>
<div class="form-group">
    <label for="form_album_description" class="col-sm-2 control-label">相册描述</label>
    <div class="col-sm-10">
    	<input class="form-control" id="form_album_description"
    		type="text" name="description" value="${album.description}"/>
    </div>
</div>
<div class="form-group">
    <label for="form_album_type" class="col-sm-2 control-label">所属类别</label>
    <div class="col-sm-10">
    	<select class="form-control" id="form_album_type" name="typeId">
			<option value="">请选择</option>
        	<c:forEach items="${types}" var="type">
        		<option value="${type.id}" ${type.type == album.type ? "selected" : ""}>${type.type}</option>
       		</c:forEach>
        </select>
    </div>
</div>
<div class="form-group">
    <label for="form_album_cover" class="col-sm-2 control-label">相册封面</label>
    <div class="col-sm-10">
    	<c:if test="${album.coverPath !=null}">
			<img src="${pageContext.request.contextPath }/${album.coverPath}" style="max-height: 100px;"/>
			<br/>
		</c:if>
		<input class="form-control" id="form_album_cover" type="file"  name="img"/> 
    </div>
</div>

</form>

<!-- ==================================================================== -->
