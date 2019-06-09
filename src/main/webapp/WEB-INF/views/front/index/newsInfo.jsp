<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>智莱云-新闻资讯</title>
		<link rel="stylesheet" href="../../../css/style.css" />
		<link rel="stylesheet" type="text/css" href="../../../css/currency.css"/>
		<link rel="stylesheet" type="text/css" href="../../../js/layui/css/layui.css"/>
		<link rel="stylesheet" href="../../../css/font.css" />
		<script type="text/javascript" src="../../../js/jquery1.11.3-jquery.min.js" ></script>
		<script type="text/javascript" src="../../../js/inheritance.js" ></script>
		<script type="text/javascript" src="../../../js/layui/layui.js" ></script>
	</head>
	<body>
		<div class="nav">
			<div class="nav-content">
				<img src="../../../img/font/nav.png" class="logoimg"/>
				<ul class="nav-list">
					<a href="/main/index.action"><li class="liSelected">首页</li></a>
					<a href="/main/about.action"><li>关于</li></a>
					<a href="/case/case.action"><li>案例</li></a>
					<a href="/main/advantage.action"><li>优势</li></a>
					<a href="/main/team.action"><li>团队</li></a>
					<a href="/main/employeePage.action"><li>招聘</li></a>
					<a href="/main/contactUs.action"><li>联系我们</li></a>
				</ul>
			</div>
		</div>
		<div class="mian">
			<div class="news-banner" style="background: url(${s2038}) no-repeat center ">
			</div>
			<div class="breadcrumb-box">
				<div class="breadcrumb">首页>新闻资讯>正文</div>
			</div>
			<div class="central">
				<h1 id="titles">${news.title}</h1>
				<div class="share">
					<span id="times">${time}</span>
					分享到：<img src="../../../img/font/share3.png" title="分享到朋友圈"/>
					<img src="../../../img/font/share4.png" title="分享到微博"/>
					<img src="../../../img/font/share1.png" title="分享到QQ"/>
					<img src="../../../img/font/share2.png" title="分享到空间"/>
				</div>
				<div class="container">${news.content}</div>
				<div class="turned">
					<div class="page" onclick="javascript:history.go(-1);">返回</div>
					<!-- <div class="page">下一篇></div> -->
				</div>
			</div>
			<div class="footer">
				<div class="contactUs">
					<div class="subtitle">
						| 联系我们
					</div>
					<div class="contact">
                        <h3>LOGO <span>${information.companyName }</span></h3>
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
							<input type="button" value="获取项目报价" id="sub" lay-submit lay-filter="add-member-submit" />
						</form>
					</div>
				</div>
			</div>
		<jsp:include page="../nav/footer.jsp"></jsp:include>
		<script type="text/javascript">
			$(window).scroll(function(){
				if($(document).scrollTop() > 630){
					$('.nav').addClass('navs');
				}else{
					$('.nav').removeClass('navs')
				}
			})
			function formatDateTime(time){
			    var date = new Date(time);
			    var year = date.getFullYear();
			    var month = date.getMonth()+1;
			    var day = date.getDate();
			    month = month < 10 ? "0"+month:month;
			    day = day < 10 ? "0"+day:day;
			    return year+"-"+month+"-"+day;
			};
			$(function(){
				// 详情页面加载执行根据id
				
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
