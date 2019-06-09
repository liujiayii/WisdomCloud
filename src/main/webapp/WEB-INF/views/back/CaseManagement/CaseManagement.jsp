<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
		    	<!-- 内容主体区域 -->
		    	<div class="layui-body-top">
					<span class="layui-breadcrumb">
					  	<a href=""><cite><i class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a>
					  	<a href="">案例管理</a>
					</span>
		    	</div>
		    	<div class="layui-body-content">
		    		<p class="ContP"><img src="/img/back/dataSj.png">案例管理<a href="/case/add.action" class="contp_a"><i class="layui-icon">&#xe608;</i>添加</a></p>
		    		<div class="ContDom">
		    			<table id="demo" lay-filter="test"></table>
		    		</div>
		        </div> 
		      	
<jsp:include page="../Inheritance/footer.jsp"></jsp:include>
<script type="text/html" id="openTpl">
		{{#	if(d.url_open_type == 0){}}
				<span style="color: #29a672;">是</span>
		{{#	}else if(d.url_open_type == 1){}}
				<span style="color: #ccc;">否</span>
		{{#		}  }}
</script>
<script type="text/html" id="statusId">
        {{# if(d.status == 0){}}
                <span style="color: #29a672;">上架中</span>
        {{# }else if(d.status == 1){}}
                <span style="color: #ccc;">下架中</span>
        {{#     }  }}
</script>
<script type="text/html" id="imgTpl">
       <img src="{{d.main_img}}">
</script>
<script type="text/html" id="imgsTpl">
       <img src="{{d.case_img}}">
</script>
<script type="text/html" id="barDemo">
	<a class="layui-btnA" lay-event="edit"><i class="layui-icon">&#xe642;</i></a>
	{{#	if(d.status == 0){}}
		<a lay-event="detail"><img src="/img/back/la.png"></a>
	{{#	}else if(d.status == 1){}}
		<a lay-event="detail" ><img src="/img/back/top.png"></a>
	{{#		}  }}
	<a class="layui-btnA" lay-event="del"><i class="layui-icon">&#xe640;</i></a>
</script>
<script type="text/javascript">
nacSelect(1);
	var cols=[{field: "id", title: "编号" ,align:"center" ,unresize:true },
				{field: "name", title: "名称" ,align:"center",unresize:true},
				{field: "type", title: "项目类型" ,align:"center",unresize:true },
				{field: "introduction", title: "简介" ,align:"center",unresize:true },
				{field: "status", title: "状态" ,align:"center",unresize:true ,hide:true},
				{field: "main_img", title: "首页图片" ,align:"center",unresize:true  ,toolbar:"#imgTpl"},
				{field: "case_img", title: "案例图片" ,align:"center",unresize:true  ,toolbar:"#imgsTpl"},
				{field: "url_open_type", title: "是否在当前页面打开" ,align:"center",unresize:true ,toolbar:"#openTpl" ,width:160},
				{field: "url", title: "跳转链接" ,align:"center",unresize:true },
				{field: "time", title: "排序时间" ,align:"center",unresize:true,templet:function (d) {
					 return formatDateTime(d.time)}},
			    {field: "status", title: "状态" ,align:"center",unresize:true ,toolbar:"#statusId"},
				{title: "操作" ,toolbar: '#barDemo' ,align:"center",unresize:true }
			]
layui.use([ 'form','jquery','element','layer','table'], function(){
	var table = layui.table,element = layui.element,form = layui.form,jquery = layui.jquery;
  	var layer = layui.layer;
  	
  	
  	/*数据表格*/
  	table.render({
		elem: '#demo',
		cols: [
			cols
		],
		url:"/case/listAll.action",
		method : 'POST',
		page: {theme: '#73b1fe'}, //是否显示分页
		defaultToolba:['filter', 'print'],
		parseData : function(res) { // res 即为原始返回的数据
			return {
				"code" : res.code, // 解析接口状态
				"msg" : res.msg, // 解析提示文本
				"count" : res.data.count, // 解析数据长度
				"data" : res.data.list
			// 解析数据列表
			};
		},
		even:true,
		limit: 15, //每页默认显示的数量
		limits:[15,30,45],
		loading: false ,//请求数据时，是否显示loading
		done: function (res, curr, count) {
	        $('thead tr').css({'background-color': '#73b1fe', 'color': '#fff'});
	   }	
	});
	table.on('tool(test)', function(obj){
	    var data = obj.data;
	    if (obj.event === 'del') {
			layer.confirm('真的删除吗', function(index){
				obj.del();
				$.post('/case/delete.action',{'id':data.id},function(){
	    		},'json');
				closeDialog();
			})
		}else if(obj.event === 'edit'){
	    	window.location.href="/case/update.action?id="+data.id;
	    }else if (obj.event === 'detail') {
	    	var status = data.status;
			if(status == 0){
				layer.confirm('确定要下架吗？', function(index){
					$.ajax({
						url:'/case/update.action',
						contentType :'application/json;charset=utf-8',
						data:JSON.stringify({'id':data.id,'status':1}),
						type:"POST",
						dataType:"json",
						success:function(map){
		                   if(map.code == 0){
		                	   window.location.reload()
		                   }else{
		                	   layer.msg(map.msg)
		                   }            
		                },
			            error: function(result) {
			            	window.wxc.xcConfirm("抱歉！出了一点小问题", window.wxc.xcConfirm.typeEnum.error);
			            }
					})
				})
			}else if(status == 1){
				layer.confirm('确定要上架吗？', function(index){
					$.ajax({
						url:'/case/update.action',
						contentType :'application/json;charset=utf-8',
						data:JSON.stringify({'id':data.id,'status':0}),
						type:"POST",
						dataType:"json",
						success:function(map){
							if(map.code == 0){
								window.location.reload()
		                    }else {
		                    	layer.msg(map.msg)
		                    }    
		                },
			            error: function(result) {
			            	window.wxc.xcConfirm("抱歉！出了一点小问题", window.wxc.xcConfirm.typeEnum.error);
			            }
					})
				})
			}
		}
	});

})
function closeDialog(){
	window.parent.location.reload();
	parent.layer.close();
}
</script>
</body>
</html>