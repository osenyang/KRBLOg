<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/jsp/public/common.jspf" %>
    
<div class="container-fluid">
        <div class="list-group row">
              <a target="main" href="${pageContext.request.contextPath}" class="list-group-item active"><b>狂人BLOg</b></a>
              <a target="main" href="${pageContext.request.contextPath}/mood/list.action" class="list-group-item">我的心情</a>
              <a target="main" href="${pageContext.request.contextPath}/log/list.action" class="list-group-item">日志</a>
              <a target="main" href="${pageContext.request.contextPath}/album/list.action" class="list-group-item">相册</a>
              <a target="main" href="${pageContext.request.contextPath}/message/list/paging.action" class="list-group-item">留言板</a>
              <a target="main" href="${pageContext.request.contextPath}/works/list.action" class="list-group-item">我的作品</a>
              <a target="main" href="${pageContext.request.contextPath}/demand/list.action" class="list-group-item">发布项目需求</a>
        </div>
</div>
