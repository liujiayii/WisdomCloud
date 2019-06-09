<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
		    	<!-- 内容主体区域 -->
		    	<div class="layui-body-top">
					<span class="layui-breadcrumb">
					  	<a href=""><cite><i class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a>
					  	<a href="">案例管理</a>
					  	<a href="">案例添加</a>
					</span>
		    	</div>
		    	<div class="layui-body-content">
		    		<p class="ContP"><img src="/img/back/dataSj.png">案例添加</p>
		    		<div class="ContDom ContForm">
		    			<div class="formDemo">
			    			<form action="" method="post"class="layui-form addForm" >
			    				<input type="hidden" name="status" value="0">
			    				<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">名称</label>
									    <div class="layui-input-inline">
											<input type="text" name="name" value="" lay-verify="required" placeholder="" autocomplete="off" class="layui-input"> 
									    </div>
									    <div class="layui-form-mid layui-word-aux">请填写案例名称</div>
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">项目类型</label>
									    <div class="layui-input-inline">
									    	<select name="type" class="layui-select" lay-verify="required">   
									    		<option value="网站建站">网站建站</option>
									    		<option value="app">app</option>
									    		<option value="软件开发">软件开发</option>
									    		<option value="平面设计">平面设计</option>
									    		<option value="其他">其他</option>
									    	</select>
									    </div>
									    <div class="layui-form-mid layui-word-aux"></div>
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">简介</label>
									    <div class="layui-input-inline">
									    	<textarea rows="10" cols="60" name="introduction"  lay-verify="required"></textarea>
									    </div>
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
									    <label class="layui-form-label">首页图片</label>
									    <input type="hidden" value="" name="main_img" id="imgUrl"/>
									    <div class="layui-upload-list">
										    <img class="layui-upload-img" id="demo1" src="" alt="选择图片" title="图片" onerror="this.src='/img/back/delete.png'">
										    <p id="demoText"></p>
										</div>
										<div class="layui-input-block imageArea">
											<p  id="test1">本地上传</p>
											<p>456*317,jpg/png,大小不超过2M</p>
										</div>
								    </div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
									    <label class="layui-form-label">案例图片</label>
									    <input type="hidden" value="" name="case_img" id="imgUrls"/>
									    <div class="layui-upload-list">
										    <img class="layui-upload-img" id="demo2" src="" alt="选择图片" title="图片" onerror="this.src='/img/back/delete.png'">
										    <p id="demoText"></p>
										</div>
										<div class="layui-input-block imageArea">
											<p  id="test2">本地上传</p>
											<p>285*250,jpg/png,大小不超过2M</p>
										</div>
								    </div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">链接</label>
									    <div class="layui-input-inline">
									    	<input type="text" value="" placeholder="如果没有请输入  #" name="url" lay-verify="required" class="layui-input"/>
									    </div>
									    <div class="layui-input-inline">
									    	<select name="url_open_type">
									    		<option value="0">当前页面打开</option>
									    		<option value="1">不在当前页面打开</option>
									    	</select>
									    </div>
									    <div class="layui-form-mid layui-word-aux">1-100个字符</div>
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">时间</label>
									    <div class="layui-input-inline">
									    	<input type="text" value="" name="time" id="time" lay-verify="required" class="layui-input"/>
									    </div>
									</div>
								</div>
								<div class="layui-form-item ">
									<div class="layui-inline  form-submit">
									    	<input type="button" class="layui-btn buts" lay-submit value="保存" lay-filter="add-member-submit"/>
									    	<input type="button" onclick="javascript:history.back(-1);" class="layui-btn buts resets" value="取消"/>
									</div>
								</div>
			    			</form>
			    		</div>
		    		</div>
		        </div> 
<jsp:include page="../Inheritance/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
nacSelect(1);
layui.use([ 'form', 'jquery', 'element', 'layer', 'table','laydate','upload'], function(){
		var table = layui.table, element = layui.element, form = layui.form, jquery = layui.jquery;
		var layer = layui.layer,laydate = layui.laydate,upload = layui.upload;
	  	
	  	/*时间*/
	  	laydate.render({
		    elem: '#time', //指定元素
		  });
		  
		  
		  
		//普通图片上传
		  var uploadInst = upload.render({
		    elem: '#test1'
		    ,method: 'POST'
		    ,url: '/main/addImg.action'
		    ,before: function(obj){
		      //预读本地文件示例，不支持ie8
		      obj.preview(function(index, file, result){
		        $('#demo1').attr('src', result); //图片链接（base64）
		      });
		    }
		    ,done: function(res){
				//如果上传失败
				if(res.code == 0){
					uploads = res.data;
					$("#imgUrl").val(res.data);
					return layer.msg(res.msg);
				}else if(res.code > 0){
					return layer.msg("上传失败");
				}
		      //上传成功
		    }
		    ,error: function(){
		      //演示失败状态，并实现重传
		      var demoText = $('#demoText');
		      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
		      demoText.find('.demo-reload').on('click', function(){
		        uploadInst.upload();
		      });
		    }
		}); 
		
		
		//普通图片上传
		  var uploadInst = upload.render({
		    elem: '#test2'
		    ,method: 'POST'
		    ,url: '/main/addImg.action'
		    ,before: function(obj){
		      //预读本地文件示例，不支持ie8
		      obj.preview(function(index, file, result){
		        $('#demo2').attr('src', result); //图片链接（base64）
		      });
		    }
		    ,done: function(res){
				//如果上传失败
				if(res.code == 0){
					uploads = res.data;
					$("#imgUrls").val(res.data);
					return layer.msg(res.msg);
				}else if(res.code > 0){
					return layer.msg("上传失败");
				}
		      //上传成功
		    }
		    ,error: function(){
		      //演示失败状态，并实现重传
		      var demoText = $('#demoText');
		      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
		      demoText.find('.demo-reload').on('click', function(){
		        uploadInst.upload();
		      });
		    }
		}); 
		
		  form.on('submit(add-member-submit)',function(data){
			  delete data.field.file;
		  		$.ajax({
					url:"/case/insert.action",
					data:JSON.stringify(data.field), 
					contentType:'application/json',
					type:"POST",
					dataType:"json",
					success:function(map){
	                   if (map.code ==0) {
	                   	 window.location.href="/case/list.action";
	                   }else{
	                   	layer.msg(map.msg,{icon:5})
	                   }                   
	                },
		            error: function(result) {
		            	window.wxc.xcConfirm("抱歉！出了一点小问题", window.wxc.xcConfirm.typeEnum.error);
		            }
				});
		  	})
			
  	

})



</script>

</html>