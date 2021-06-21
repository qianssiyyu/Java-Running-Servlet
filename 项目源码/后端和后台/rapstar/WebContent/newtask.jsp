<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ctx }/layui/css/layui.css">
<link rel="stylesheet" href="${ctx }/layui/css/admin.css">
<style>
.layui-tab-brief>.layui-tab-more li.layui-this:after, .layui-tab-brief>.layui-tab-title .layui-this:after {
    border: none;
    border-radius: 0;
    border-bottom: 2px solid #583f64;
}
.layui-laypage .layui-laypage-curr .layui-laypage-em {
    background-color: #583f64;
}
.layadmin-carousel {
    height: 185px!important;
}
</style>
</head>
<body layadmin-themealias="default">
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md8">
        <div class="layui-row layui-col-space15">
          <div class="layui-col-md6">
            <div class="layui-card">
              <div class="layui-card-header">快捷方式</div>
              <div class="layui-card-body">
                
                <div class="layui-carousel layadmin-carousel layadmin-shortcut" lay-anim="" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 280px;">
                  <div carousel-item="">
                    <ul class="layui-row layui-col-space10 layui-this">
                      <li class="layui-col-xs3">
                        <a href="${ctx }/accList.jsp">
                          <i class="layui-icon layui-icon-headset"></i>
                          <cite>伴奏</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a href="${ctx }/songList.jsp">
                          <i class="layui-icon layui-icon-chart"></i>
                          <cite>歌曲</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a href="${ctx }/demoList.jsp">
                          <i class="layui-icon layui-icon-template-1"></i>
                          <cite>demo</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a href="${ctx }/musicianList.jsp">
                          <i class="layui-icon layui-icon-chat"></i>
                          <cite>歌手</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a href="${ctx }/accList.jsp">
                          <i class="layui-icon layui-icon-star"></i>
                          <cite>收藏</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a href="${ctx }/accsetList.jsp">
                          <i class="layui-icon layui-icon-templeate-1"></i>
                          <cite>伴奏单</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a href="${ctx }/userList.jsp">
                          <i class="layui-icon layui-icon-user"></i>
                          <cite>用户</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a href="set/system/website.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>设置</cite>
                        </a>
                      </li>
                    </ul>
                    <ul class="layui-row layui-col-space10">
                      <li class="layui-col-xs3">
                        <a href="set/user/info.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>我的资料</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a href="set/user/info.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>我的资料</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a href="set/user/info.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>我的资料</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a href="set/user/info.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>我的资料</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="set/user/info.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>我的资料</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="set/user/info.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>我的资料</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="set/user/info.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>我的资料</cite>
                        </a>
                      </li>
                      <li class="layui-col-xs3">
                        <a lay-href="set/user/info.html">
                          <i class="layui-icon layui-icon-set"></i>
                          <cite>我的资料</cite>
                        </a>
                      </li>
                    </ul>
                    
                  </div>
                <div class="layui-carousel-ind"><ul><li class="layui-this"></li><li></li></ul></div><button class="layui-icon layui-carousel-arrow" lay-type="sub"></button><button class="layui-icon layui-carousel-arrow" lay-type="add"></button></div>
                
              </div>
            </div>
          </div>
          <div class="layui-col-md6">
            <div class="layui-card">
              <div class="layui-card-header">待办事项</div>
              <div class="layui-card-body">

                <div class="layui-carousel layadmin-carousel layadmin-backlog" lay-anim="" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 280px;">
                  <div carousel-item="">
                    <ul class="layui-row layui-col-space10 layui-this">
                      <li class="layui-col-xs6">
                        <a lay-href="app/content/comment.html" class="layadmin-backlog-body" style="color:#583f64">
                          <h3>待审用户</h3>
                          <p><cite style="color:#583f64;">4</cite></p>
                        </a>
                      </li>
                      <li class="layui-col-xs6">
                        <a lay-href="app/forum/list.html" class="layadmin-backlog-body" style="color:#583f64">
                          <h3>待审伴奏</h3>
                          <p><cite style="color:#583f64;">2</cite></p>
                        </a>
                      </li>
                      <li class="layui-col-xs6">
                        <a href="${ctx }/checksong.jsp" class="layadmin-backlog-body" style="color:#583f64">
                          <h3>待审歌曲</h3>
                          <p><cite style="color:#583f64;">9</cite></p>
                        </a>
                      </li>
                      <li class="layui-col-xs6">
                        <a href="javascript:;" onclick="layer.tips('不跳转', this, {tips: 3});" class="layadmin-backlog-body">
                          <h3>待下架</h3>
                          <p><cite style="color:#583f64;">3</cite></p>
                        </a>
                      </li>
                    </ul>
                    <ul class="layui-row layui-col-space10">
                      <li class="layui-col-xs6">
                        <a href="javascript:;" class="layadmin-backlog-body">
                          <h3>待审友情链接</h3>
                          <p><cite style="color: #FF5722;">5</cite></p>
                        </a>
                      </li>
                    </ul>
                  </div>
                <div class="layui-carousel-ind"><ul><li class="layui-this"></li><li></li></ul></div><button class="layui-icon layui-carousel-arrow" lay-type="sub"></button><button class="layui-icon layui-carousel-arrow" lay-type="add"></button></div>
              </div>
            </div>
          </div>
          <div class="layui-col-md12">
            <div class="layui-card">
              <div class="layui-card-header">数据概览</div>
              <div class="layui-card-body">
              	<div id="main" style="width: 600px; height: 300px;"></div>
                
              </div>
                
             </div>
            </div>
		  </div>
		  
       </div>
     
     <div class="layui-col-md4">
		  	<div class="layui-card">
              <div class="layui-tab layui-tab-brief layadmin-latestData">
                <ul class="layui-tab-title">
                  <li class="layui-this">今日热搜</li>
                  <li>今日热帖</li>
                </ul>
                <div class="layui-tab-content">
                  <div class="layui-tab-item layui-show">
                  	<table id="demo" lay-filter="test">
                  </div>
                  <div class="layui-tab-item" style="">
                  </div>
                </div>
              </div>
            </div>
     </div>
      
 
      
    </div>
</div>
<script src="${ctx }/layui/layui.js"></script>
<script src="${ctx }/layui/echarts.js"></script>

<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
 
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '一周内用户增长数量'
            },
            tooltip: {},
            legend: {
            	data:['用户增长数']
            },
            xAxis: {
            	
                data: ["6-3","6-4","6-5","6-6","6-7","6-8","6-9"]
            },
            yAxis: {},
            series: [{
                name: '用户增长数',
                type: 'bar',
                color:'#583f64',
                data: [8,5, 4, 9, 10, 10, 12]
            }]
        };
 
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
    
    
    
<script>
layui.use(['form','table'], function(){
	  	var table = layui.table;
		table.render({
	    elem: '#demo', //需要显示数据表格的table标签
	    height: 552 ,
	    url: '${ctx }/keyword/getall', //请求地址   
	    page: false,//开启分页  
	    limits: [3,5,10],
        limit: 10,
        id: 'userReload',
        skin: 'nob',
	    cols: [[
	    	 {field: 'num', title: '序号', width:80,type:'numbers',align:'center'}
	    	,{field: 'keyword', title: '热搜词', width:150,align:'center'}
	    	,{field: 'mycount', title: '次数', width:100,align:'center'}
	        ]]
		});
 





});

</script>


</body>
</html>