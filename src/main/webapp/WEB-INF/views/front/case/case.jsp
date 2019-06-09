<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta content="${s1041}" name="Keywords">
<meta name="description" content="${s1042}">
</head>
<jsp:include page="../nav/nav.jsp"></jsp:include>
		<div class="navs navas">
			<div class="nav-content">
				<img src="${s2002}" class="logoimg"/>
				<ul class="nav-list">
					<a href="/main/index.action"><li>首页</li></a>
					<a href="/main/about.action"><li>关于</li></a>
					<a href="/case/case.action"><li  class="liSelected">案例</li></a>
					<a href="/main/advantage.action"><li>优势</li></a>
					<a href="/main/team.action"><li>团队</li></a>
					<a href="/main/employeePage.action"><li>招聘</li></a>
					<a href="/main/contactUs.action"><li>联系我们</li></a>
				</ul>
			</div>
		</div>
		<div class="mian">
			<div class="case-banner" style="background:url(${s2021}) no-repeat center">
				
			</div>
			<div class="case">
				<div class="caseArea">
					
				</div>
				<div class="add">
					<div class="addbut"></div>
				</div>
			</div>
			<div class="footer" style="background: url(${s2017}) no-repeat center black;">
				<div class="contactUs">
					<div class="subtitle">
						| 联系我们
					</div>
					<div class="contact">
                        <img src="${s2018}"/><span><h3>${information.companyName }</h3></span>
                        <p>电话：${information.companyPhone }</p>
                        <p>QQ：${information.qq }</p>
                        <p>邮箱：${information.email }</p>
                        <p>邮编：${information.postcode }</p>
                        <p>上班时间：（9:00--18:00）</p>
                    </div>
					<div class="offer">
						<h1>在线申请项目报价</h1>
						<form action="" method="post" class="layui-form" >
							<input type="hidden" name="status" value="0">
							<div class="form-box">
								<span>项目类型：</span><input type="text"  name="type"  lay-verify="required" placeholder="如app，网站建站，软件开发，平面设计，其他"/>
							</div>
							<div class="form-box">
								<span>项目简介：</span><input type="text"  name="introduction"  lay-verify="required"/>
							</div>
							<div class="form-box">
								<span>联系电话：</span><input type="text"  name="phone" maxlength="11"  lay-verify="required|phone"/>
							</div>
							<div class="form-box">
								<span>姓名：</span><input type="text"  name="name" lay-verify="required"/>
							</div>
							<div class="form-box">
								<span>备注：</span><input type="text"  name="remark"/>
							</div>
							<input type="button" value="提交" id="sub" lay-submit lay-filter="add-member-submit" />
						</form>
					</div>
				</div>
			</div>
		<jsp:include page="../nav/footer.jsp"></jsp:include>
		<script type="text/javascript">
		var limit=4;
		/* 案例+*/
		$(".addbut").click(function(){			
			$.ajax({
	  			url:"/case/listAll.action",
	  			data:{'page':1,'limit':limit},
	  			type:"POST",
	  			dataType:"json",
	  			async : false, //同步执行
	  			success:function(result){
	  				console.log(result.data);
	  				if(result.data.list.length==result.data.count){
	  					$(".addbut").css("display","none")
	  				}
	  				if(result){
	  					$(".caseArea").html("")
	  					for(var i=0;i<result.data.list.length;i++){
		  					$(".caseArea").append("<div class='case-list'><div class='img-box'><img src='"+result.data.list[i].case_img+"' /><div class='tag'>"+result.data.list[i].type+"</div></div><div class='describe'><p>"+formatDateTime(result.data.list[i].time)+"</p><h3>"+result.data.list[i].name+"</h3><p>"+result.data.list[i].introduction+"<p></div></div>")
		  				}
	  				}
	  			},
	  			error: function(result) {
	              	window.wxc.xcConfirm("抱歉！出了一点小问题", window.wxc.xcConfirm.typeEnum.error);
	              }
	  		});
			limit=limit+4
		})
			$(function(){
				/* 案例初始*/
				$(".addbut").trigger("click");
				/* 提交留言 */
				layui.use([ 'form', 'jquery', 'layer', 'laydate'], function(){
					var form = layui.form, jquery = layui.jquery;
					var layer = layui.layer,laydate = layui.laydate;
				
					form.on('submit(add-member-submit)',function(data){
				  		$.ajax({
							url:"/message/insert.action",
							data:JSON.stringify(data.field), 
							contentType:'application/json',
							type:"POST",
							dataType:"json",
							success:function(map){
			                   if (map.code ==0) {
			                	   layer.msg("添加留言成功，稍后我们的工作人员会联系您",{icon: 6,time:500,end:function(){
			                		   window.location.href="/main/index.action";
			                        }})
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
			})
		</script>
	</body>
</html>
