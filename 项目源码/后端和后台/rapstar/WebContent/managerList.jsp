<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>管理员管理</title>
<link rel="stylesheet" href="./layui/css/layui.css" media="all">
<style>
.layui-btn {
    
    background-color: #583f64;
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
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
              <input type="text" name="username" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
          </div>
          <div class="layui-inline" style="margin-top:11px;margin-left:10px">
            <button class="layui-btn layuiadmin-btn-useradmin" lay-submit="" lay-filter="LAY-user-front-search">
              <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
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
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" style="background-color:#e3e3e3" lay-event="del">删除</a>
  
</script>
<script>
layui.use(['form','table'], function(){
	  	var table = layui.table;
		table.render({
	    elem: '#demo', //需要显示数据表格的table标签
	    height: 400 ,
	    url: '${ctx }/manager/getall', //请求地址   
	    page: true,//开启分页  
	    limits: [3,5,10],
        limit: 10,
        id: 'managerReload',
        skin: 'row',
	    cols: [[
	    	{checkbox: true, fixed: true}
	    	,{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
	    	,{field: 'phone', title: '电话', width:80}
	    	,{field: 'name', title: '用户名', width:80}
	    	,{field: 'password', title: '密码', width:80}
	        ,{fixed: 'right', title: '操作',width:150, align:'center', toolbar: '#barDemo'}
	        ]]
		});
 



table.on('tool(test)', function(obj){
   var data = obj.data;
   if(obj.event === 'del'){
	   layer.confirm('真的删除行么', function(index){
           console.log(data);           
           $.ajax({
               url: "${ctx }/manager/getall",
               type: "POST",
               data:{"uid":data.id},
               dataType: "json",
               success: function(data){
                   if(data.state==1){
                      //删除这一行
                       obj.del();
                      //关闭弹框
                       layer.close(index);
                       layer.msg("删除成功", {icon: 1});
                   }else{
                       layer.msg("删除失败", {icon: 5});
                   }
               }
           });    
      });
      //编辑
    } else if(obj.event === 'edit'){
    	layer.open({
            type: 2,
            //skin:'layui-layer-rim',设置边框
            title: '修改角色信息',
            area: ['40%', '350px'],
            shade: [0.5, '#393D49'],
            anim: 2,
            fixed: false,
            content: '${ctx }/user/edit',
            offset: '20px',//设置弹出层在距离顶部，100px 水平居中
            btn : ['保存','取消'],
            success : function(layero, index) { // 成功弹出后回调
                layer.iframeAuto(index);
                 var body = layer.getChildFrame('body', index);  //巧妙的地方在这里哦
                    body.contents().find("#uid").val(data.id);
                    body.contents().find("#uphone").val(data.phone);
                    body.contents().find("#uname").val(data.nickName);
                    body.contents().find("#upwd").val(data.password);
                    body.contents().find("#upath").val(data.photoPath);
                    body.contents().find("#uintro").val(data.intro);
                    body.contents().find("#ustars").val(data.stars);
                    body.contents().find("#ufoll").val(data.followers);
                    body.contents().find("#uvip").val(data.isVip);
                    body.contents().find("#ucer").val(data.certification);
            },
            yes : function(index, layero) { // 保存按钮回调函数
            	layer.iframeAuto(index);
                var body = layer.getChildFrame('body', index);  //巧妙的地方在这里哦
                var id = body.contents().find("#uid").val();
                var phone = body.contents().find("#uphone").val();
                var name = body.contents().find("#uname").val();
                var password = body.contents().find("#upwd").val();
                var photoPath = body.contents().find("#upath").val();
                var intro = body.contents().find("#uintro").val();
                var stars = body.contents().find("#ustars").val();
                var followers = body.contents().find("#ufoll").val();
                var isVip = body.contents().find("#uvip").val();
                var certification = body.contents().find("#ucer").val();
                var params = {
               			'id':id,
           		    	'phone':phone,
           		    	'name':name,
           		    	'password':password,
           		    	'photoPath':photoPath,
           		    	'intro':intro,
           		    	'stars':stars,
           		    	'followers':followers,
           		        'isVip':isVip,
           		        'certification':certification
                   };
                 
                $.ajax({
                    url:"${ctx }/user/edit",
                    type:"post",
                    dataType:'json',
                    data:params,
                    success: function(data){
                    	
                        if(data.state==1){
                           //关闭弹框
                            layer.close(index);
                            table.reload('userReload',{//重载表格
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

    	
    }
});

});

</script>



</body>
</html>