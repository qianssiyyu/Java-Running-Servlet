<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>layout 管理系统大布局 - Layui</title>
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
<div class="layui-card-header" style="height:60px">
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
<div style="padding-bottom: 10px;">
    	
          <button class="layui-btn layuiadmin-btn-useradmin" data-type="add">添加</button>
        </div>
<table id="demo" lay-filter="test">
</table>
</div>
</div>
</div>



<script src="./layui/layui.js"></script>
<script src="./js/jquery.js"></script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  
</script>
<script>
layui.use(['form','table'], function(){
        var table = layui.table;
        table.render({
        elem: '#demo', //需要显示数据表格的table标签
        height: 350 ,
        url: '${ctx }/musician/getAllMusicians', //请求地址  lxl 
        page: true,//开启分页  
        limits: [3,5,10],
        limit: 10,
        id: 'musicianReload',//lxl
        skin: 'row',
        
        //lxl
        cols: [[
            {checkbox: true, fixed: true}
            ,{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
            ,{field: 'name', title: '姓名', width:80}
            ,{field: 'shortProfile', title: '简单介绍', width:80}
            ,{field: 'longProfile', title: '详细介绍', width:80}
            ,{field: 'sex', title: '性别', width:80}
            ,{field: 'userId', title: '用户编号', width:80}
            ,{field: 'photoPath', title: '照片', width:80}
            ,{fixed: 'right', title: '操作',width:150, align:'center', toolbar: '#barDemo'}
            ]]
        });
 



table.on('tool(test)', function(obj){
   var data = obj.data;
   if(obj.event === 'del'){
       layer.confirm('真的删除行么', function(index){
           console.log(data);           
           $.ajax({
               url: "${ctx }/musician/delMusicianById",//lxl
               type: "POST",
               data:{"id":data.id},//lxl
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
            content: '${ctx }//musician/edit',
            offset: '20px',//设置弹出层在距离顶部，100px 水平居中
            btn : ['保存','取消'],
            success : function(layero, index) { // 成功弹出后回调
                layer.iframeAuto(index);
                 var body = layer.getChildFrame('body', index);  //巧妙的地方在这里哦
                    body.contents().find("#id").val(data.id);
                    body.contents().find("#name").val(data.name);
                    body.contents().find("#shortpro").val(data.shortProfile);
                    body.contents().find("#longpro").val(data.longProfile);
                    body.contents().find("#sex").val(data.sex);
                    body.contents().find("#userid").val(data.userId);
                    body.contents().find("#photopath").val(data.photoPath);
            },
            yes : function(index, layero) { // 保存按钮回调函数
                layer.iframeAuto(index);
                var body = layer.getChildFrame('body', index);  //巧妙的地方在这里哦
                var id = body.contents().find("#id").val();
                var phone = body.contents().find("#name").val();
                var name = body.contents().find("#shortpro").val();
                var password = body.contents().find("#longpro").val();
                var photoPath = body.contents().find("#sex").val();
                var intro = body.contents().find("#userid").val();
                var stars = body.contents().find("#photopath").val();
                var params = {
                        'id':id,
                        'name':name,
                        'shortpro':password,
                        'longpro':photoPath,
                        'sex':intro,
                        'userid':stars,
                        'photopath':followers
                   };
                 
                $.ajax({
                    url:"${ctx }/musician/edit",
                    type:"post",
                    dataType:'json',
                    data:params,
                    success: function(data){
                         
                        if(data.state==1){
                           //关闭弹框
                            layer.close(index);
                            table.reload('musicianReload',{//重载表格
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