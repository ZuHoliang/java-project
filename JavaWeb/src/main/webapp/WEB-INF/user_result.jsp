<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用者資料表單-結果</title>
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
		<h2>使用者資料表單-結果</h2>
		<fieldset>
			<legend>User result</legend>
			<label>姓名:${user.userName}</label>
			<p />
			<label>性別:${user.gender}</label>
			<p />
			<label>年齡:${user.age}</label>
			<p />
			<label>身高(cm):${user.height} <label>體重(kg):${user.weight}</label>
			<p /> 
			<label>BMI:${user.bmi}</label>
			<p />
			<label>BMI診斷:${user.diagnosis}</label>
			<p />
			<a href="/JavaWeb/user" class="pure-button pure-button-primary">返回</a>
		</fieldset>
		</from>
	</div>
</body>
</html>