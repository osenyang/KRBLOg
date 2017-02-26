<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/index/head.jsp"%>
<!-- 图片浏览 CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/colorbox.css" />
<!-- 图片浏览 JS -->
<script src="${pageContext.request.contextPath}/js/jquery.colorbox-min.js"></script>
<title>相册</title>

<style type="text/css">
.cboxPhoto {
	/* 这里控制点开展示的图片 */
}
#album_photo a:HOVER {
	text-decoration: none;
}
#album_photo{
	display: inline;
}

#album_photo img {
    max-height: 140px;
    margin-bottom: 2px;
    margin-top: 2px;
}

#album_photo :HOVER{
	/* cursor: pointer; */
	border-color: #337AB7;
}

.table {
    margin-bottom: 0px;
}
</style>

<script type="text/javascript">

$(function(){
	$.backAlbumList = function(){
		var url = "${pageContext.request.contextPath }/album/list.action";
		window.location.href = url;
	};
	
	/* 图片浏览 */
	$.fn.colorbox.settings.transition = "elastic";//可设置为"elastic", "fade", "none"
	$.fn.colorbox.settings.bgOpacity = "0.6";
	$.fn.colorbox.settings.contentCurrent = "image {current} of {total}";
	//$(".cpModal").colorbox();
	$('a.cpModal').colorbox({rel:'gal'});
	
	$('.cpModal').click(function(){
		var imgW = $('.cboxPhoto').width();
		
	});
});
</script>
</head>
<body> 
<%@ include file="/WEB-INF/jsp/public/kr_modal.jspf" %>

<div class="container" id="kr_main">
<div class="panel panel-default">
<div class="panel-body">

<table class="table table-striped"><!-- table-striped 各行变色 -->
    <thead>
	    <tr>
	        <th>相册ID</th>
	        <th>名称</th>
	        <th>描述</th>
	        <th width="8%">创建时间</th>
	        <th>状态</th>
	        <th>加密</th>
	        <th width="7%">被观看</th>
	        <th width="7%">回复数</th>
	    </tr>
    </thead>
    
    <tbody>
        <tr>
            <td>${album.id}</td>
            <td>${album.name}</td>
            <td>${album.description}</td>
            <td><fmt:formatDate value="${album.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${album.isSecret}</td>
            <td>${mood.seeCount}</td>
            <td>${album.seeCount}</td>
            <td>${album.replyCount}</td>
        </tr>
    
        
    </tbody>
    
    <tfoot>
        <tr>
            <td colspan="8" class="text-left">
            	<c:if test="${kr_session_manager != null}">
                <a class="btn btn-primary" 
                    data-toggle="modal" data-target="#upload_img_modal_lg"
                    href="<%=path %>/album/uploadImgsUI.action?id=${album.id}" >上传图片</a>
                &nbsp;&nbsp;</c:if>
                <input class="btn btn-default" type="button" value="返回" onclick="$.backAlbumList();"/>
            </td>
        </tr>
        
    </tfoot>
    
</table>

</div><!-- -------------panel-body -->
</div><!-- ------------panel-default -->

<c:if test="${!empty album.photos}">
<div class="panel panel-default">
<div class="panel-body">
	<c:forEach items="${album.photos}" var="photo">
		<div id="album_photo">
			<a class="cpModal" href="<%=path %>/${photo.imgPath}" title="${photo.name}">
	    		<img class="album_photo img-thumbnail" src="<%=path %>/${photo.imgPath}"><!-- img-thumbnail -->
			</a>
		</div>
	</c:forEach>
</div><!-- -------------panel-body -->
</div><!-- ------------panel-default -->
</c:if>


</div><!-- end container -->


</body>

<%@ include file="/WEB-INF/jsp/index/bottom.jsp"%>
</html>