<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guestbook 留言</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
<style>
.form_container {
	max-width: 500px;
	margin: 50px outo;
	padding: 20px;
}

h2 {
	text-align: center;
}
</style>
</head>
<body style="padding: 20px">
	<div class="pure-form">
		<h2>訪客留言</h2>
		<fieldset>
			<legend>Guestbook result</legend>
			<li>本次訊息:${message}</li>
			<li>歷史留言:</li>
			<ol>
			<c:forEach var="guestbook" items="${guestbooks}">
			<li>${guestbook.message} ${guestbook.date}</li>
			</c:forEach>
			</ol>
			
			<p />
			留言數: ${fn:length(guestbooks)}
			<table class="pure-table pure-table-bordered">
				<thead>
					<tr>
						<th>NO.</th>
						<th>留言內容</th>
						<th>留言時間</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach varStatus="i" var="guestbook" items="${guestbooks}">
					<tr>
						<td>${ i.index +1 }</td>
						<td>${guestbook.message}</td>
						<!-- 格式化日期 -->
						<td><fmt:formatDate value="${guestbook.date}" pattern="yyy-MM-dd E a HH:mm:ss" /></td>
					</tr>
				</c:forEach>
				
				</tbody>
			</table>
			
			<a href="/JavaWeb/guestbook" class="pure-button pure-button-primary">返回</a>
		</fieldset>
		</from>
	</div>
</body>
</html>