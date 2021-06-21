<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>歌曲管理</title>
<link rel="stylesheet" href="./layui/css/layui.css" media="all">
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
<div class="layui-card-header" style="height:80px">
<form class="layui-form" action="">
  <div class="layui-inline" style="margin-top:15px">
            <label class="layui-form-label">ID</label>
            <div class="layui-input-block">
              <input type="text" name="id" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
          </div>
          <div class="layui-inline" style="margin-top:15px">
            <label class="layui-form-label">歌曲名</label>
            <div class="layui-input-block">
              <input type="text" name="username" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
          </div>
          <div class="layui-inline" style="margin-top:11px;margin-left:10px">
            <button class="layui-btn layuiadmin-btn-useradmin" lay-submit="" lay-filter="LAY-user-front-search" style="background:#583f64">
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

{{#  if(d.mystate == 0){ }}
	<a class="layui-btn layui-btn-primary layui-btn-xs">已审核</a>
	<a class="layui-btn layui-btn-primary layui-btn-xs">已下架</a>
{{#  }if(d.mystate == 1){ }}
	<a class="layui-btn layui-btn-primary layui-btn-xs">已审核</a>
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="checkres">未下架</a>
{{#  }if(d.mystate == 2){ }}
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="checkres" style="color:#fff">未审核</a>
{{#  } }}

</script>

<script>
layui.use(['form','table'], function(){
	  	var table = layui.table;
	  	
		table.render({
	    elem: '#demo', //需要显示数据表格的table标签
	    height: 370 ,
	    url: '${ctx }/song/getallsong', //请求地址   
	    page: true,//开启分页  
	    limits: [3,5,10],
        limit: 10,
        id: 'songReload',
        skin: 'row',
	    cols: [[
	    	{checkbox: true, fixed: true}
	    	,{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
	    	,{field: 'name', title: '歌曲名', width:80}
	    	,{field: 'authorid', title: '创作者', width:80}
	    	,{field: 'lyricpath', title: '歌词', width:80}
	    	,{field: 'acc', title: '使用伴奏', width:80}
	    	,{field: 'style', title: '风格', width:80}
	    	,{field: 'path', title: '存储路径', width:80}
	    	,{field: 'money', title: '付费金额', width:80}
	        ,{field: 'imgpath', title: '封面', width:80}
	        ,{field: 'songlistid', title: '所属歌单', width:80}
	        ,{fixed: 'right', title: '操作',width:150, align:'center', toolbar: '#barDemo'}
	        ,{field: 'mystate', title: '资源状态', width:80,hide:true}
	        ]]
		});
		
		table.on('tool(test)', function(obj){
			   var data = obj.data;
			   
			   if(obj.event === 'checkres'){	    	
			                $.ajax({
			                    url:"${ctx }/song/edit",
			                    type:"post",
			                    dataType:"json",
			                    data:{"id":data.id,"mystate":data.mystate},
			                    success: function(data){			                    	
			                        if(data.state==1){
			                           
			                            table.reload('songReload',{//重载表格
			              				  page:{
			              					  curr:1
			              				  }
			              			  });

			                            layer.msg("修改成功", {icon: 6});
			                        }else{
			                            layer.msg("修改失败", {icon: 5});
			                        }
			                    }
			                });
			    }
						
			        
			    	
			    
			});

});
 





    	


</script>



</body>
</html>