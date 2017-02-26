<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
<title>Insert title here</title>
</head>
<body>
	<table class="table table-bordered">
		<thead></thead>
		<tbody>
			<!-- On rows -->
			<tr class="active"><td></td><td></td><td></td><td></td><td></td>
			</tr>
			<tr class="success"><td></td><td></td><td></td><td></td><td></td>
			</tr>
			<tr class="warning"><td></td><td></td><td></td><td></td><td></td>
			</tr>
			<tr class="danger"><td></td><td></td><td></td><td></td><td></td>
			</tr>
			<tr class="info"><td></td><td></td><td></td><td></td><td></td>
			</tr>

			<!-- On cells (`td` or `th`) -->
			<tr>
				<td class="active">active</td>
				<td class="success">success</td>
				<td class="warning">warning</td>
				<td class="danger">danger</td>
				<td class="info">info</td>
			</tr>
		</tbody>
	</table>
</body>
</html>