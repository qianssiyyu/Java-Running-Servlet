<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rapStar后台登录</title>
<link href="<%=path %>/css/login.css" rel="stylesheet" type="text/css" media="all" />
<!-- <link rel="stylesheet" type="text/css" href="css/login.css" /> -->
<style type="text/css">
body {
	background-image: url("<%=path %>/imgs/home/homeBack.jpg");
	background-size: 100%;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<div id="login_frame">
		<p id="image_logo">
			<img src="<%=path %>/imgs/home/rapstar.png" height="100px">
		</p>
		<form method="post" action="/rapstar/manager/login">
			<p>
				<label class="label_input">手机号</label><input type="text"
					id="username" name="phone" value="${phone }" class="text_field" />
			</p>
			<p>
				<label class="label_input">密码</label><input type="password"
					id="password" name="password" value="${password }"
					class="text_field" />
			</p>

			<div id="login_control">
				<input type="submit" id="btn_login" value="登录" /><br>
				<div style="color: #990033; font-size: 14px; margin-top: 10px">${errorInfo }</div>
			</div>
		</form>
	</div>

</body>
</html>