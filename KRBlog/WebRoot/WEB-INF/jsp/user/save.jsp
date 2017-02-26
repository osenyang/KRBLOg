<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<form class="form form-horizontal kr_validate" id="user_form" action="${pageContext.request.contextPath }/free/user/save.action"
	method="post" enctype="multipart/form-data">
<%-- <input user="hidden" name="id" value="${user.id}"/> --%>

<div class="form-group">
    <label for="form_user_login_name" class="col-sm-2 control-label">登录名</label>
    <div class="col-sm-10">
    	<input required id="form_user_login_name" placeholder="登录名称，只能是 [1-9, a-Z]"
			class="form-control" type="text" name="loginName" value="${user.loginName}"/>
    </div>
</div>
<div class="form-group">
    <label for="form_user_name" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-10">
    	<input required id="form_user_name" placeholder="用户昵称"
			class="form-control" type="text" name="name" value="${user.name}"/>
    </div>
</div>
<div class="form-group">
    <label for="form_user_password" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
		<input required id="form_user_password" placeholder="登录密码"
			class="form-control" type="password" name="password" value="${user.password}"/>
    </div>
</div>
<div class="form-group">
    <label for="form_user_img" class="col-sm-2 control-label">头像</label>
    <div class="col-sm-10">
		<c:if test="${user.imgPath !=null}">
			<img src="${pageContext.request.contextPath }/${user.imgPath}" style="max-height: 100px;"/>
			<br/>
		</c:if>
		<input class="form-control" id="form_user_img" type="file"  name="img"/> 
    </div>
</div>

</form>

<!-- =================================================================================== -->
