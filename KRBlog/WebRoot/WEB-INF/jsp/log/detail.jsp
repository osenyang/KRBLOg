<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
    
<table class="table table-striped">
	<tr>
		<th width="12%">日志 ID</th>
		<td>${log.id}</td>
	</tr>
	<tr>
		<th>标题</th>
		<td class="font_content">${log.title}</td>
	</tr>
	<tr>
		<th>内容</th>
		<td>${log.content}</td>
	</tr>
	<tr>
		<th>创建时间</th>
		<td><fmt:formatDate value="${log.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	</tr>
	
	<c:if test="${!empty log.updateTime}">
		<tr>
			<th>修改时间</th>
			<td><fmt:formatDate value="${log.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
	</c:if>
	
	<tr>
		<th>类别</th>
		<td>${log.type}</td>
	</tr>
	<tr>
		<th>状态</th>
		<td>${log.status}</td>
	</tr>
	<tr>
		<th>加密</th>
		<td>${log.isSecret}</td>
	</tr>
	<tr>
		<th>被观看</th>
		<td>${log.seeCount}</td>
	</tr>
	<tr>
		<th>被赞</th>
		<td>${log.favor}</td>
	</tr>
	<tr>
		<th>回复数</th>
		<td>${log.replyCount}</td>
	</tr>
	
	
</table>

