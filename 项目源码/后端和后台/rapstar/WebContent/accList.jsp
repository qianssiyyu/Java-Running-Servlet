<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>accList</title>
<link rel="stylesheet" href="./layui/css/layui.css" media="all">
</head>
<style>
.layui-btn {
    
    border-color: #583f64;
    color: #583f64;
}
.layui-laypage .layui-laypage-curr .layui-laypage-em {
    background-color: #583f64;
}

</style>
</head>
<body>

<div class="layui-fluid">
<div class="layui-card" style="margin-top:20px">
<div class="layui-card-header" style="height:60px">
<form class="layui-form" action="">
  <div class="layui-inline" style="margin-top:15px">
            <label class="layui-form-label">ID</label>
            <div class="layui-input-block">
              <input type="text" name="id" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
          </div>
          <div class="layui-inline" style="margin-top:15px">
            <label class="layui-form-label">伴奏名</label>
            <div class="layui-input-block">
              <input type="text" name="username" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
          </div>
          <div class="layui-inline" style="margin-top:11px;margin-left:10px">
            <button class="layui-btn layuiadmin-btn-useradmin" lay-submit="" lay-filter="LAY-user-front-search" style="background-color: #583f64;">
              <i class="layui-icon layui-icon-search layuiadmin-button-btn" style="color:#fff"></i>
            </button>
          </div>
  
</form>

</div>
<div class="layui-card-body">
<table id="demo" lay-filter="test">
</table>
</div>
</div>
</div>




<script src="./layui/layui.js"></script>
<script src="./js/jquery.js"></script>
<script type="text/html" id="barDemo">
	{{#  if(d.state == 0){ }}
	<a class="layui-btn layui-btn-primary layui-btn-xs">已审核</a>
	<a class="layui-btn layui-btn-primary layui-btn-xs">已下架</a>
{{#  }if(d.state == 1){ }}
	<a class="layui-btn layui-btn-primary layui-btn-xs">已审核</a>
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="out">未下架</a>
{{#  }if(d.state == 2){ }}
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="checkres" style="color:#fff">未审核</a>
{{#  } }}
</script>
<script type="text/html" id="imgtmp">
	<img src="http://34.92.146.242:8080/rapstar/imgs/{{d.imgpath}}" style="width:50px;height:50px">
</script>


<script>
layui.use(['form','table'], function(){
	  	var table = layui.table;
		table.render({
	    elem: '#demo', //需要显示数据表格的table标签
	    height: 370 ,
	    url: '${ctx }/acc/getAllAccompaniments', //请求地址   
	    page: true,//开启分页  
	    limits: [3,5,10],
        limit: 10,
        id: 'accReload',
        skin: 'row',
	    cols: [[
	    	{checkbox: true, fixed: true}
	    	,{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
	    	,{field: 'name', title: '电话', width:80}
	    	,{field: 'auname', title: '用户名', width:100}
	    	,{field: 'intro', title: '简介', width:80}
	    	,{field: 'time', title: '密码', width:80}
	    	,{field: 'imgpath', title: '封面', width:80,templet:"#imgtmp"}
	    	,{field: 'stname', title: '风格', width:80}
	    	,{field: 'money', title: '付费', width:80}
	        ,{field: 'path', title: '资源', width:80}
	        ,{fixed: 'right', title: '状态',width:150, align:'center', toolbar: '#barDemo'}
	        ,{field: 'state', hide:true,title: '原始状态', width:80}
	        ]]
		});
		
		table.on('tool(test)', function(obj){
			var data = obj.data;
			if(obj.event === 'checkres'){//审核
				$.ajax({
                    url:"${ctx }/acc/edit",
                    type:"post",
                    dataType:'json',
                    data:{'id':data.id,'flag':0},//审核和下架都是更新，用的同一个方法，只是调用的sql语句不同，flag用来区分是哪一个操作
                    success: function(data){                  	 
                        if(data.s==1){
                           //关闭弹框
                           table.reload('accReload',{//重载表格
              				  page:{
              					  curr:1
              				  }
              			  });                           
                            layer.msg("审核成功", {icon: 6});
                        }else{
                            layer.msg("审核失败", {icon: 5});
                        }
                    }
                });              
			}else if(obj.event === 'out'){//下架歌曲，资源路径置为空
				$.ajax({
                    url:"${ctx }/acc/edit",
                    type:"post",
                    dataType:'json',
                    data:{'id':data.id,'flag':1},
                    success: function(data){                  	 
                        if(data.s==1){
                           //关闭弹框
                           table.reload('accReload',{//重载表格
              				  page:{
              					  curr:1
              				  }
              			  });                           
                            layer.msg("下架成功", {icon: 6});
                        }else{
                            layer.msg("下架失败", {icon: 5});
                        }
                    }
                });            
				
			}
		});
 




});

</script>



</body>
</html>