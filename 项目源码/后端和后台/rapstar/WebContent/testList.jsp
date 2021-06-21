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
<title>Insert title here</title>
<style type="text/css">
body {
    background-image: url("<%=path %>/imgs/home/homeBack.jpg");
    background-size: 100%;
    background-repeat: no-repeat;
}
#content{
  position: absolute;
  top: 30%;
  left: 30%;
  trasform: translate(-50%)
}    

</style>
</head>
<body  style="text-align:center;">
<img id="content" alt="logo loading..." src="<%=path %>/imgs/home/rapstar.png">
<!-- 这是测试的list哦 -->
<!-- 这是测试的list哦 -->
<!-- 这是测试的list哦 -->
<!-- 这是测试的list哦 -->
</body>
</html>