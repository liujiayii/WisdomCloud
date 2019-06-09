<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
		    	<!-- 内容主体区域 -->
		    	<div class="layui-body-top">
					<span class="layui-breadcrumb">
					  	<a href=""><cite><i class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a>
					  	<a href="">新闻资讯</a>
					  	<a href="">新闻添加</a>
					</span>
		    	</div>
		    	<div class="layui-body-content">
		    		<p class="ContP"><img src="/img/back/dataSj.png">新闻添加</p>
		    		<div class="ContDom ContForm">
		    			<form action="" method="post"class="layui-form addForm" lay-filter="formTest">
		    			<input type="hidden" name="id" value="${news.id}">
		    				<div class="layui-form-item">
								<div class="layui-inline">
									<label class="layui-form-label">栏目</label>
								    <div class="layui-input-inline">
								    	<select name="type"  class="layui-select" lay-verify="required" lay-search>   
								    		<option value="公司咨询" <c:if test="${'公司咨询'eq news.type}">selected</c:if> >公司咨询</option>
								    		<option value="新闻媒体" <c:if test="${'新闻媒体'eq news.type}">selected</c:if> >新闻媒体</option>
								    	    <option value="企业动态" <c:if test="${'企业动态'eq news.type}">selected</c:if> >企业动态</option>
								    	</select>
								    </div>
								</div>
							</div>
							<div class="layui-form-item">
								<div class="layui-inline">
									<label class="layui-form-label">标题</label>
								    <div class="layui-input-inline">
								    	<input type="text" value="${news.title}" name="title" class="layui-input"  lay-verify="required"/>
								    </div>
								    <div class="layui-form-mid layui-word-aux">1-20个字符</div>
								</div>
							</div>
							<div class="layui-form-item">
								<div class="layui-inline" >
									<label class="layui-form-label">内容</label>
								    <div class="layui-input-inline" style="width: 1200px;">
								    	<textarea class="layui-textarea" id="content" style="display: none;" name="content" lay-verify="content">${news.content}</textarea>
								    </div>
								</div>
							</div>
							<div class="layui-form-item">
								<div class="layui-inline">
									<label class="layui-form-label">关键词</label>
								    <div class="layui-input-inline">
								    	<input type="text" value="${news.key_words}" name="key_words" class="layui-input"  lay-verify="required"/>
								    </div>
								</div>
								<p class="fontRead">0-30个字符，每个关键词用“，”号隔开，例如：讴业普惠，互联网金融第一品牌，深圳</p>
							</div>
							<div class="layui-form-item">
								<div class="layui-inline">
								    <label class="layui-form-label">图片</label>
								    <input type="hidden" value="${news.img_one}" name="img_one" id="imgUrl"/>
								    <div class="layui-upload-list">
									    <img class="layui-upload-img" id="demo1" src="${news.img_one}" alt="选择图片" title="图片">
									    <p id="demoText"></p>
									</div>
									<div class="layui-input-block imageArea">
										<p  id="test1">本地上传</p>
										<p>1920*800，jpg/png,大小不超过2M</p>
									</div>
							    </div>
							</div>
							<div class="layui-form-item">
								<div class="layui-inline">
									<label class="layui-form-label">插入时间</label>
								    <div class="layui-input-inline">
								    	<input type="text" value="${time}" name="time" id="startTime"  lay-verify="required" class="layui-input"/>
								    </div>
								</div>
							</div>
							<div class="layui-form-item">
								<div class="layui-inline">
									<label class="layui-form-label">来源</label>
								    <div class="layui-input-inline">
								    	<input type="text" value="${news.source}" name="source" lay-verify="required" class="layui-input"/>
								    </div>
								    <div class="layui-form-mid layui-word-aux">1-10个字符</div>
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
<jsp:include page="../Inheritance/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
nacSelect(3);
layui.use([ 'form', 'jquery', 'element', 'layer', 'table','laydate','upload','layedit'], function(){
		var table = layui.table, element = layui.element, form = layui.form, jquery = layui.jquery;
		var layer = layui.layer,laydate = layui.laydate,upload = layui.upload,layedit = layui.layedit;
	  	
		//富文本编译器
        var index = layedit.build('content', {
            height: 125 , //设置编辑器高度
             tool: [
                 'strong' //加粗
                 ,'italic' //斜体
                 ,'underline' //下划线
                 ,'del' //删除线
                 
                 ,'|' //分割线
                 
                 ,'left' //左对齐
                 ,'center' //居中对齐
                 ,'right' //右对齐
                 ,'link' //超链接
                 ,'unlink' //清除链接
                 ,'face' //表情
                 ,'help' //帮助
               ]
        });
		
	    /*时间*/
	  	laydate.render({
		    elem: '#startTime', //指定元素
		  });
		  
	  //自定义验证规则
        form.verify({
            content: function(value){
                return layedit.sync(index);
            }
        })
      		  
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
		
		  form.on('submit(add-member-submit)',function(data){
		   console.log(data.field);
		   delete data.field.file;
	  		$.ajax({
	  			url:"/news/update.action",
				data:JSON.stringify(data.field), 
				contentType:'application/json',
				type:"POST",
				dataType:"json",
				success:function(map){
	                   if (map.code ==0) {
	                	   window.location.href="/news/list.action";
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