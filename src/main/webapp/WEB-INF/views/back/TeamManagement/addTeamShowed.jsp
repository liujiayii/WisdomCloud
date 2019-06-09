<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
		    	<!-- 内容主体区域 -->
		    	<div class="layui-body-top">
					<span class="layui-breadcrumb">
					  	<a href=""><cite><i class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a>
					  	<a href="">团队展示</a>
					  	<a href="">团队添加</a>
					</span>
		    	</div>
		    	<div class="layui-body-content">
		    		<p class="ContP"><img src="/img/back/dataSj.png">团队添加</p>
		    		<div class="ContDom ContForm">
		    			<div class="formDemo">
			    			<form action="" method="post"class="layui-form addForm" >
			    				<input type="hidden" value="0" name="status">
			    				<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">姓名</label>
									    <div class="layui-input-inline">
											<input type="text" name="name" value="" lay-verify="required" placeholder="" autocomplete="off" class="layui-input"> 
									    </div>
									    <div class="layui-form-mid layui-word-aux">请填写员工姓名</div>
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">岗位</label>
									    <div class="layui-input-inline">
									    	<select name="station" class="layui-select" lay-verify="required">   
									    		<option value="员工">员工</option>
                                                <option value="主管">主管</option>
                                                <option value="经理">经理</option>
                                                <option value="副总经理">副总经理</option>
                                                <option value="总经理">总经理</option>
									    	</select>
									    </div>
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">简介</label>
									    <div class="layui-input-inline">
									    	<textarea rows="10" cols="60" name="introduction"  lay-verify="required"></textarea>
									    </div>
									    <div class="layui-form-mid layui-word-aux"></div>
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">是否首页显示</label>
									    <div class="layui-input-inline">
									    	<select name="home_page" class="layui-select" lay-verify="required">   
									    		<option value="0">是</option>
									    		<option value="1">否</option>
									    	</select>
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
											<p>287*360,jpg/png,大小不超过2M</p>
										</div>
								    </div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
									    <label class="layui-form-label">团队图片</label>
									    <input type="hidden" value="" name="group_img" id="imgUrls"/>
									    <div class="layui-upload-list">
										    <img class="layui-upload-img" id="demo2" src="" alt="选择图片" title="图片" onerror="this.src='/img/back/delete.png'">
										    <p id="demoText"></p>
										</div>
										<div class="layui-input-block imageArea">
											<p  id="test2">本地上传</p>
											<p>120*120,jpg/png,大小不超过2M</p>
										</div>
								    </div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">邮箱</label>
									    <div class="layui-input-inline">
									    	<input type="text" value="" name="email" lay-verify="required|email" class="layui-input"/>
									    </div>
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">排序时间</label>
									    <div class="layui-input-inline">
									    	<input type="text" value="" name="time" lay-verify="required" id="time" class="layui-input"/>
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
nacSelect(2);
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
				url:"/group/insert.action",
				contentType:'application/json',
				data:JSON.stringify(data.field), 
				type:"POST",
				dataType:"json",
				success:function(map){
                   if (map.code ==0) {
                   	window.location.href="/group/list.action";
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