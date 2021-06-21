<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<script type="text/javascript">
	function exit() {
		window.opener = null;
		window.open("", "_self");
		window.close();

	};
</script>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>rapstar后台管理</title>
<link rel="stylesheet" href="${ctx }/layui/css/layui.css">
<style>
dd{
color:#583f64;
}
.layui-nav .layui-nav-item a {
    
    color: #fff;
    
}
@font-face
{
    font-family: myFirstFont;
    src: url(${ctx }/css/hh.ttf);
    
}
 
.layui-layout-admin .layui-header {
    background-color: #fff;
}

.layui-layout-admin .layui-logo {
    font-family:myFirstFont;
    font-size:35px;
    font-weight:900;
    color:#fff;
    background-color: #583f64;
    
}
.layui-nav-itemed>.layui-nav-child {
    
    background-color: #fff!important;
}
.layui-nav {
    background-color: #583f64;
}
.layui-nav-itemed>a .layui-nav-more {
    
    border-color: transparent transparent #fff;
}
.layui-nav .layui-nav-more {
    
    border-color: transparent transparent #eee;
}
.layui-bg-black {
    background-color: #583f64!important;
}
.layui-nav-bar {
    background-color:#eee;
}
.layui-nav-tree .layui-nav-bar {
    
    background-color: #eee;
}
.layui-this > a {
    background-color: #eee !important;
}
.layui-nav-tree li > a:hover{
    background-color: #583f64 !important;
}
.layui-layout-admin .layui-input-search {
    border: none;
}
.layui-icon-spread-left:before {
    content: "\e66b";
}

</style>
</head>
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<!--   文字版本 -->
			<div class="layui-logo">Rapstar</div>

			<!--     logo版本     -->
			<!-- 			<div class="layui-logo"> -->
			<%-- 				<img src="${ctx }/imgs/home/rapstar.png" height="50px" /> --%>
			<!-- 			</div> -->
			<!-- 头部区域（可配合layui 已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
          <li class="layui-nav-item layadmin-flexible" lay-unselect="">
            <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
              <i class="layui-icon layui-icon-spread-left" id="LAY_app_flexible" style="color:#000"></i>
            </a>
          </li>
          <li class="layui-nav-item layui-hide-xs" lay-unselect="">
            <a href="http://www.baidu.com/" target="_blank" title="前台">
              <i class="layui-icon layui-icon-website" style="color:#000"></i>
            </a>
          </li>
          <li class="layui-nav-item" lay-unselect="">
            <a href="javascript:;" layadmin-event="refresh" title="刷新">
              <i class="layui-icon layui-icon-refresh-3" style="color:#000"></i>
            </a>
          </li>
          <li class="layui-nav-item layui-hide-xs" lay-unselect="">
            <input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search" layadmin-event="serach" lay-action="template/search.html?keywords="> 
          </li>
        <span class="layui-nav-bar" style="left: 282px; top: 48px; width: 0px; opacity: 0;"></span></ul>
			<!-- <ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">nav 1</a></li>
				<li class="layui-nav-item"><a href="">nav 2</a></li>
				<li class="layui-nav-item"><a href="">nav 3</a></li>
				<li class="layui-nav-item"><a href="javascript:;">nav
						groups</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">menu 11</a>
						</dd>
						<dd>
							<a href="">menu 22</a>
						</dd>
						<dd>
							<a href="">menu 33</a>
						</dd>
					</dl></li>
			</ul>-->
			<ul class="layui-nav layui-layout-right">
			<li class="layui-nav-item" lay-unselect="">
            <a lay-href="app/message/index.html" layadmin-event="message" lay-text="消息中心">
              <i class="layui-icon layui-icon-notice" style="color:#000"></i>  
              
              <!-- 如果有新消息，则显示小圆点 -->
              <span class="layui-badge-dot"></span>
            </a>
          </li>
          
          <li class="layui-nav-item layui-hide-xs" lay-unselect="">
            <a href="javascript:;" layadmin-event="theme">
              <i class="layui-icon layui-icon-theme" style="color:#000"></i>
            </a>
          </li>
          
          <li class="layui-nav-item layui-hide-xs" lay-unselect="">
            <a href="javascript:;" layadmin-event="note">
              <i class="layui-icon layui-icon-note" style="color:#000"></i>
            </a>
          </li>
          
          <li class="layui-nav-item layui-hide-xs" lay-unselect="">
            <a href="javascript:;" layadmin-event="fullscreen">
              <i class="layui-icon layui-icon-screen-full" style="color:#000"></i>
            </a>
          </li>
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="${ctx }/imgs/home/topi.png"
						class="layui-nav-img"> <span style="color:#333">脑浆poppy</span>
				</a>
					<dl class="layui-nav-child">
						<dd>
							<!-- 							<a href="">sign out</a> -->
							<!-- 							当前效果只是清除了子页面 -->
							<a href="" οnclick="exit" style="color:#583f64;font-size:14px;font-weight:800">退出登录</a>
							<!-- 							<a href="/rapstar/manager/logout">退出登录</a> -->
						</dd>
						<!-- 						<dd> -->
						<!-- 							<a href="">setting</a> -->
						<!-- 						</dd> -->
					</dl></li>
				
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
				<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;"><i class="layui-icon layui-icon-home"></i><cite style="margin-left:7px">主页</cite></a>
						<dl class="layui-nav-child">
							<dd>
								<a href="${ctx }/newtask.jsp" style="color:#583f64;font-size:12px;font-weight:600">控制台</a>
							</dd>
							
						</dl></li>
					<li class="layui-nav-item"><a class=""
						href="javascript:;"><i class="layui-icon layui-icon-user"></i><cite style="margin-left:7px">用户</cite></a>
						<dl class="layui-nav-child">
							<dd>
								<a href="${ctx }/userList.jsp" style="color:#583f64;font-size:12px;font-weight:600">普通用户管理</a>
							</dd>
							<dd>
								<a href="${ctx }/musicianList.jsp" style="color:#583f64;font-size:12px;font-weight:600">歌手管理</a>
							</dd>
							<dd>
								<a href="${ctx }/managerList.jsp" style="color:#583f64;font-size:12px;font-weight:600">管理员管理</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;"><i class="layui-icon layui-icon-headset"></i><cite style="margin-left:7px">资源</cite></a>
						<dl class="layui-nav-child">
							<dd>
								<a href="${ctx }/demoList.jsp" style="color:#583f64;font-size:12px;font-weight:600">demo管理</a>
							</dd>
							<dd>
								<a href="${ctx }/accList.jsp" style="color:#583f64;font-size:12px;font-weight:600">伴奏管理</a>
							</dd>
							<dd>
								<a href="${ctx }/songList.jsp" style="color:#583f64;font-size:12px;font-weight:600">歌曲管理</a>
							</dd>
							<dd>
								<a href="${ctx }/songsetList.jsp" style="color:#583f64;font-size:12px;font-weight:600">歌单管理</a>
							</dd>
							<dd>
								<a href="${ctx }/accsetList.jsp" style="color:#583f64;font-size:12px;font-weight:600">伴奏单管理</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;"><i class="layui-icon layui-icon-fire"></i><cite style="margin-left:7px">兴趣</cite></a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" style="color:#583f64;font-size:12px;font-weight:600">收藏管理</a>
							</dd>
							<dd>
								<a href="javascript:;" style="color:#583f64;font-size:12px;font-weight:600">粉丝管理</a>
							</dd>
						</dl></li>
						<li class="layui-nav-item"><a href="javascript:;"><i class="layui-icon layui-icon-cols"></i><cite style="margin-left:7px">其他</cite></a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" style="color:#583f64;font-size:12px;font-weight:600">风格管理</a>
							</dd>
							<dd>
								<a href="javascript:;" style="color:#583f64;font-size:12px;font-weight:600">动态管理</a>
							</dd>
						</dl></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
        
			<!-- 内容主体区域 -->
			<iframe id="iframeMain" src="javascript:;" style="width: 100%;height:100%;border-width:0px;background-color:#eee"></iframe>
		
		</div>
<!-- 底部固定区域 -->
		<!-- <div class="layui-footer">
			
			© 2020-2050 Rapstar
		</div> -->
	</div>

	<script src="${ctx }/layui/layui.js"></script>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;
		});
		layui.use([ 'jquery', 'layer' ], function() {
			var $ = layui.$ //重点处
			, layer = layui.layer;

			//后面就跟你平时使用jQuery一样
			$(document).ready(function() {
				$("dd>a").click(function(e) {
					e.preventDefault();
					$("#iframeMain").attr("src", $(this).attr("href"));
				});
			});
		});
	</script>

</body>
</html>