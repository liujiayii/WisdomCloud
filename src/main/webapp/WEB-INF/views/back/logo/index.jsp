<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<title>登录</title>
		<link rel="stylesheet" href="/js/layui/css/layui.css">
		<link rel="stylesheet" href="/css/login.css">
		<script type="text/javascript" src="/js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript" src="/js/layui/layui.js"></script>
	</head>
	<body>
		<div class="main">
			<div class="article_main">
				<div class="contLeft">
					<img src="/img/back/ImageLeft.png"/>
				</div>
				<div class="contRight">
					<img src="/img/back/loginlogo.png" />
					<div class="contForm">
						<form action="" method="post"  id="fin_form" class="layui-form">
							<div class="details">
								<input type="text" name="account" value="" lay-verify="required" placeholder="请输入您的账号" class="allInput" autocomplete="off"/>
							</div>
							<div class="details">
								<input type="password" name="password" value="" lay-verify="required" placeholder="密码6-12位字符含数字、字母、下划线！" class="allInput" autocomplete="off" maxlength="12"/>
							</div>
							<div class="details">
								<input type="text" name="verifyCode" id="fin_code" value="" placeholder="请输入您的验证码" class="allInput" style="width: 297px;float: left;" autocomplete="off"/>
								<img id="img" class="auth_code" src="/login/getCode.action">
								<div class="clear" style="clear: both;"></div>
							</div>
							<div class="details subdetails">
								<input type="button"  id="sub" value="马上登录" lay-submit lay-filter="sub" class="allInput submit"/>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		$("#img").click(function(){
			$("#img").attr("src","/login/getCode.action?t=" + + new Date().getTime());
		})
		
		layui.use([ 'form', 'jquery', 'element', 'layer', 'table','laydate','upload'], function(){
			var table = layui.table, element = layui.element, form = layui.form, jquery = layui.jquery;
			var layer = layui.layer,laydate = layui.laydate,upload = layui.upload;
			var form = layui.form;
			// 提交按钮
			form.on('submit(sub)', function(data) {
				console.log(data.field)
				$.ajax({
					type : 'POST',
					url : '/login/login.action',
					data : data.field,
					dataType : 'json',
					success : function(res) {
						if (res.code == 0) {
							window.location.href = "/amount/list.action";
						} else {
								//$("#img").attr("src","/login/getCode.action?t=" + + new Date().getTime());
							layer.msg(res.msg,function() {
								$("#img").attr("src","/login/getCode.action?t=" + + new Date().getTime());
							});
						}
					},
					error : function(err) {
						layer.msg('后台异常', function() {
						});
					}
				});
				return false; // 阻止表单跳转。如果需要表单跳转，去掉这段即可。
			})
		})

		
		/* 回车键登录 */
		$("body").keydown(function(event){
			if(event.keyCode == "13"){
				$("#sub").click();
			}
		})
	</script>
</html>