<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
<!-- 内容主体区域 -->
<div class="layui-body-top">
	<span class="layui-breadcrumb"> <a href=""><cite><i
				class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a> <a
		href="">招聘信息</a>
	</span>
</div>
<div class="layui-body-content">
	<p class="ContP">
		<img src="/img/back/dataSj.png">招聘信息<a href="/wanted/add.action" class="contp_a"><i class="layui-icon">&#xe608;</i>添加</a>
	</p>
	<div class="ContDom">
		<table id="demo" lay-filter="test"></table>
	</div>
</div>
<jsp:include page="../Inheritance/footer.jsp"></jsp:include>
<script type="text/html" id="barDemo">
	<a class="layui-btnA" lay-event="edit"><i class="layui-icon">&#xe642;</i></a>
	{{#	if(d.state == 0){}}
		<a lay-event="detail"><img src="/img/back/la.png" title="下架"></a>
	{{#	}else if(d.state == 1){}}
		<a lay-event="detail" ><img src="/img/back/top.png" title="上架"></a>
	{{#		}  }}
	<a class="layui-btnA" lay-event="del"><i class="layui-icon">&#xe640;</i></a>
</script>
<script type="text/javascript">
	nacSelect(8);
	var cols=[{field: "id", title: "编号" ,align:"center" ,unresize:true ,hide:true },
	            {field: "job", title: "招聘岗位" ,align:"center",unresize:true },
				{field: "wantNumber", title: "招聘人数" ,align:"center",unresize:true},
				{field: "education", title: "学历要求" ,align:"center",unresize:true },
				{field: "major", title: "专业要求" ,align:"center",unresize:true},
				{field: "workplace", title: "工作地点" ,align:"center",unresize:true },
				{field: "remark", title: "工作详情" ,align:"center",unresize:true},
				{field: "state", title: "状态" ,align:"center",unresize:true ,hide:true},
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
		id:'testArea',
		skin: 'line' ,
		method : 'POST',
		url:"/wanted/listWanted.action",
		page: {theme: '#73b1fe'}, //是否显示分页
		even:true,
		parseData : function(res) { // res 即为原始返回的数据
			return {
				"code" : res.code, // 解析接口状态
				"msg" : res.msg, // 解析提示文本
				"count" : res.data.count, // 解析数据长度
				"data" : res.data.list
			// 解析数据列表
			};
		},
		limit: 15, //每页默认显示的数量
        limits:[15,30,45],
		done: function (res, curr, count) {
			console.log(res);
	        $('thead tr').css({'background-color': '#73b1fe', 'color': '#fff'});
	   }	

	});
	table.on('tool(test)', function(obj){
	    var data = obj.data;
	    if (obj.event === 'del') {
			layer.confirm('真的删除吗', function(index){
				obj.del();
				$.post('/wanted/removeWanted.action',{'id':data.id},function(){
	    		},'json');
				closeDialog();
			})
		}else if(obj.event === 'edit'){
	    	window.location.href="/wanted/getWantedById.action?id="+data.id;
	    }else if (obj.event === 'detail') {
	    	var state = data.state;
			if(state == 0){
				layer.confirm('确定要下架吗？', function(index){
					$.ajax({
						url:'/wanted/changeWantedState.action',
						contentType :'application/json;charset=utf-8',
						data:JSON.stringify({'id':data.id,'state':1}),
						type:"POST",
						dataType:"json",
						success:function(map){
							window.location.reload();               
		                },
			            error: function(result) {
			            	window.wxc.xcConfirm("抱歉！出了一点小问题", window.wxc.xcConfirm.typeEnum.error);
			            }
					})
				})
			}else if(state == 1){
				layer.confirm('确定要上架吗？', function(index){
					$.ajax({
						url:'/wanted/changeWantedState.action',
						contentType :'application/json;charset=utf-8',
						data:JSON.stringify({'id':data.id,'state':0}),
						type:"POST",
						dataType:"json",
						success:function(map){
							window.location.reload();
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