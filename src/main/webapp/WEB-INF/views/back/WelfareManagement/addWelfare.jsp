<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
		    	<!-- 内容主体区域 -->
		    	<div class="layui-body-top">
					<span class="layui-breadcrumb">
					  	<a href="/amount/list.action"><cite><i class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a>
					  	<a href="">公司福利信息</a>
					  	<a href="">公司福利添加</a>
					</span>
		    	</div>
		    	<div class="layui-body-content">
		    		<p class="ContP"><img src="/img/back/dataSj.png">公司福利添加</p>
		    		<div class="ContDom ContForm">
			    		<div class="formDemo">
			    			<form action="" method="post"class="layui-form addForm" >
			    				
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">标题</label>
									    <div class="layui-input-inline">
									    	<input type="text" value="" name="title" class="layui-input"  lay-verify="required"/>
									    </div>
									    <div class="layui-form-mid layui-word-aux">1-20个字符</div>
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">内容</label>
									    <div class="layui-input-inline">
									    	<textarea rows="15" cols="60" name="content" lay-verify="required"></textarea>
									    </div>
									</div>
								</div>
								
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">状态</label>
									    <div class="layui-input-inline">
									    	<select name="state" class="layui-select" lay-verify="required" lay-search>   
									    		<option value="0">上架</option>
									    		<option value="1">下架</option>
									    	</select>
									    </div>
									</div>
								</div>
								
								<div class="layui-form-item ">
									<div class="layui-inline  form-submit">
									    	<input type="button" name="" class="layui-btn buts" lay-submit value="保存" lay-filter="add-member-submit"/>
									    	<input type="button" name="" onclick="javascript:history.back(-1);" class="layui-btn buts resets" value="取消"/>
									</div>
								</div>
			    			</form>
		    			</div>
		    		</div>
		        </div> 
<jsp:include page="../Inheritance/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
nacSelect(9);
layui.use([ 'form', 'jquery', 'element', 'layer', 'table','laydate','upload','layedit'], function(){
		var table = layui.table, element = layui.element, form = layui.form, jquery = layui.jquery;
		var layer = layui.layer,laydate = layui.laydate,upload = layui.upload,layedit = layui.layedit;
		//自定义验证规则
		  form.verify({
		      content: function(value){
		    	  return layedit.sync(index);
		      }
		  })
		
		  form.on('submit(add-member-submit)',function(data){
		   delete data.field.file;
	  		$.ajax({
				url:"/welfare/saveWelfare.action",
				data:JSON.stringify(data.field), 
				contentType:'application/json',
				type:"POST",
				dataType:"json",
				success:function(map){
                   if (map.code ==0) {
                   	 window.location.href="/welfare/list.action";
                   }else{
                   	layer.msg(map.msg,{icon:5})
                   }                   
                },
	            error: function(map) {
	            	window.wxc.xcConfirm("抱歉！出了一点小问题", window.wxc.xcConfirm.typeEnum.error);
	            }
			});
	  	 })
})


</script>

</html>