<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>🍧冰果店的點餐系統-結果</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
</head>
<body style="padding: 20px">
	<div class="pure-form">
		<h2>🍧冰果店的點餐-結果</h2>
		<fieldset>
			<legend>訂單列表</legend>
			<c:set var="totalPriceSum" value="0" />
			<table class="pure-table pure-table-bordered">
				<thead>
					<tr>
						<th>NO.</th>
						<th>主餐</th>
						<th>配料</th>
						<th>價格</th>
						<th>刪除</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach varStatus="i" var="iceOrder" items="${iceOrders}">
					<tr>
						<td>${ i.index +1 }</td>
						<td>${iceOrder.mainDish.name}</td>
						<td>${iceOrder.topping.toppings}</td>
						<td>
						<fmt:formatNumber value="${iceOrder.totalPrice}" type="currency" maxFractionDigits="1" />
						</td>
						<td title="點擊刪除" style="cursor: pointer;">x</td>
					</tr>
				<c:set var="totalPriceSum" value="${totalPriceSum+iceOrder.totalPrice}" />
				</c:forEach>
				
				</tbody>
				 
				<tfoot>
				 <tr style="background-color: #DDDDDD">
				 <td colspan="3" style="text-align:right;">總金額</td>
				 <td>
				 <fmt:formatNumber value="${ totalPriceSum }" type="currency" maxFractionDigits="1" />
				 </td>
				 </tr>
				</tfoot>
				
			</table>
		</fieldset>
		<a href="/JavaWeb/ice" class="pure-button pure-button-primary">返回</a>			

	</div>
</body>
</html>