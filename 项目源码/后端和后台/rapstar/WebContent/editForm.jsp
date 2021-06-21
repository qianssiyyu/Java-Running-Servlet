<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>layout 管理系统大布局 - Layui</title>
<link rel="stylesheet" href="./layui/css/layui.css" media="all">
</head>
<body>
	<%
		String type = request.getParameter("type");
	%>
	<c:if test="${type eq 'user'}">
		<div class="site-text" style="margin: 5%" id="box1" target="test123">
			<form class="layui-form layui-form-pane" onsubmit="return false"
				id="usertype">
				<div class="layui-form-item">
					<label class="layui-form-label">ID编号</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input layui-disabled text_add "
							id="uid" name="uid" disabled="disabled">
					</div>
					<br> <label class="layui-form-label"> 电话</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input" id="uphone" name="uphone"><br>
					</div>
					<label class="layui-form-label"> 用户名</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input" id="uname" name="uname"><br>
					</div>
					<label class="layui-form-label"> 密码</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input" id="upwd" name="upwd"><br>
					</div>
					<label class="layui-form-label"> 头像</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input" id="upath" name="upath"><br>
					</div>
					<label class="layui-form-label"> intro</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input" id="uintro" name="uintro"><br>
					</div>
					<label class="layui-form-label"> 粉丝</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input" id="ustars" name="ustars"><br>
					</div>
					<label class="layui-form-label"> 关注</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input" id="ufoll" name="ufoll"><br>
					</div>
					<label class="layui-form-label"> 级别</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input" id="uvip" name="uvip"><br>
					</div>
					<label class="layui-form-label"> 身份</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input" id="ucer" name="ucer"><br>
					</div>
				</div>
			</form>
		</div>
	</c:if>


	<c:if test="${type eq 'musician'}">
		<div class="site-text" style="margin: 5%" id="box1" target="test123">
			<form class="layui-form layui-form-pane" onsubmit="return false"
				id="usertype">
				<div class="layui-form-item">
					<label class="layui-form-label">ID编号</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input layui-disabled text_add "
							id="id" name="id" disabled="disabled">
					</div>
					<br> <label class="layui-form-label"> 姓名</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input" id="name" name="name"><br>
					</div>
					<label class="layui-form-label"> 简单介绍</label>
					<div class="layui-input-block">
					<textarea rows="2" cols="20" class="layui-input" id="shortpro" name="shortpro">
                                                              
                           </textarea>
<!-- 						<input type="text" class="layui-input" id="shortpro" -->
<!-- 							name="shortpro"><br> -->
					</div>
					<label class="layui-form-label"> 详细介绍</label>
					<div class="layui-input-block">
						<textarea rows="3" cols="20" class="layui-input" id="longpro" name="longpro">
                                                              
                           </textarea>
<!-- 						<input type="text" class="layui-input" id="longpro" name="longpro"><br> -->
					</div>
					<label class="layui-form-label"> 性别</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input" id="sex" name="sex"><br>
					</div>
					<label class="layui-form-label"> 用户编号</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input" id="userid" name="userid"><br>
					</div>
					<label class="layui-form-label"> 照片</label>
					<div class="layui-input-block">
						<input type="text" class="layui-input" id="photopath"
							name="photopath"><br>
					</div>

				</div>
			</form>
		</div>
	</c:if>


</body>
</html>