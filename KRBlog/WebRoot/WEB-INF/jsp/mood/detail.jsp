<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
    
<table class="table table-striped">
	<tr>
		<th width="12%">心情 ID</th>
		<td>${mood.id}</td>
	</tr>
	<tr>
		<th>内容</th>
		<td>${mood.content}</td>
	</tr>
	<tr>
		<th>创建时间</th>
		<td><fmt:formatDate value="${mood.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	</tr>
	<tr>
		<th>状态</th>
		<td>${mood.status}</td>
	</tr>
	<tr>
		<th>加密</th>
		<td>${mood.isSecret}</td>
	</tr>
	<tr>
		<th>被观看</th>
		<td>${mood.seeCount}</td>
	</tr>
	<tr>
		<th>回复数</th>
		<td>${mood.replyCount}</td>
	</tr>
	
	<!-- <tr>
		<td colspan="2" class="text-right"><input class="btn btn-default" type="button" value="返回" onclick="history.back(-1);"/></td>
	</tr> -->
	
</table>

