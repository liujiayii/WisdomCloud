<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
		    	<!-- 内容主体区域 -->
		    	<div class="layui-body-top">
						<span class="layui-breadcrumb">
						  	<a href=""><cite><i class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a>
						  	<a href="">图片管理</a>
						</span>
		    	</div>
		    	<div class="layui-body-content">
		    		<p class="ContP"><img src="/img/back/dataSj.png">图片管理<a href="/picture/add.action" class="contp_a"><i class="layui-icon">&#xe608;</i>添加</a></p>
		    		<div class="ContDom">
		    			<table id="demo" lay-filter="test"></table>
		    		</div>
		        </div> 
<jsp:include page="../Inheritance/footer.jsp"></jsp:include>
<script type="text/html" id="barDemo">
	<a class="layui-btnA" lay-event="edit"><i class="layui-icon">&#xe642;</i></a>
</script>
<script type="text/html" id="imgsTpl">
       <img src="{{d.imgUrl}}">
</script>
<script type="text/javascript">
	nacSelect(5);
	var cols=[{field: "id", title: "图片ID" ,align:"center" ,unresize:true ,hide:true},
	            {field: "imageNumber", title: "图片编号" ,align:"center",unresize:true},
	            {field: "imgPlace", title: "图片位置" ,align:"center",unresize:true },
				{field: "name", title: "图片名称" ,align:"center",unresize:true},
				{field: "imgUrl", title: "图片" ,align:"center",unresize:true,toolbar:"#imgsTpl"},
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
		url:"/picture/listAll.action",
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
				$.post('/picture/delete.action',{'id':data.id},function(){
	    		},'json');
				closeDialog();
			})
		}else if(obj.event === 'edit'){
	    	window.location.href="/picture/update.action?id="+data.id;
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