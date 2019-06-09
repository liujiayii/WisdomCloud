<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  	<title>智莱云案例管理</title>
  	<link rel="stylesheet" href="/js/layui/css/layui.css">
  	<link rel="stylesheet" type="text/css" href="/css/inheritance.css"/>
  	<script type="text/javascript" src="/js/jquery-3.1.1.min.js"></script>
  	<script type="text/javascript" src="/js/echarts.js"></script>
  	<script type="text/javascript" src="/js/inheritance.js"></script>
	<script type="text/javascript" src="/js/layui/layui.js"></script>
</head>
<body>
	<div  class="layui-layout layui-layout-admin">
			<div class="layui-header header header-demo">
				<div class="layui-main">
					<div class="admin-logo-box"><img src="/img/back/logo.png"></div>
					<div class="admin-logo-user">
						<ul class="layui-nav top-nav" lay-filter="">
							<li class="layui-nav-item">
							    <a href="javacript:;" style="color: #fff;">
							    	超级管理员
							    	<img src="/img/back/next.png" style="margin-left: 5px;">
							    </a>
							    <dl class="layui-nav-child child-dl"> <!-- 二级菜单 -->
							      <dd class="child-dd"><a href="/login/supervisor.action">退出<img style="float: right;margin-top: 10px;" src="/img/back/close.png"></a></dd>
							    </dl>
						  	</li>
						</ul>
					</div>
					<div class="static-Area"><button type="button" onclick='btnStatic();'>一键静态化</button></div>
				</div>
			</div>
		  <div class="layui-side layui-bg-black  side-scrolls">
		    <div class="layui-side-scroll  side-scrolls">
		      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
		     	 <ul class="layui-nav layui-nav-tree side-scrolls"  lay-filter="test" lay-shrink="all">
				        <li class="layui-nav-item">
				          <a href="/amount/list.action"><i class="layui-icon">&#xe68e;</i>首页</a>
				        </li>
				        <li class="layui-nav-item">
				          <a href="/case/list.action"><i class="layui-icon">&#xe670;</i>案例管理</a>
				        </li>
				        <li class="layui-nav-item">
				            <a href="/group/list.action"><i class="layui-icon">&#xe630;</i>团队展示</a>
				        </li>
				        <li class="layui-nav-item">
			                <a href="/news/list.action"><i class="layui-icon">&#xe60e;</i>新闻资讯</a>
			            </li>
			            <li class="layui-nav-item">
                            <a href="/ztTextList.action"><i class="layui-icon">&#xe644;</i>文字管理</a>
                        </li>
				        <li class="layui-nav-item">
				            <a href="/picture/list.action"><i class="layui-icon">&#xe60d;</i>图片管理</a>
				        </li>
				        <li class="layui-nav-item">
				            <a href="/message/list.action"><i class="layui-icon">&#xe63c;</i>数据管理</a>
				        </li>
				        <li class="layui-nav-item">
                            <a href="/partner/list.action"><i class="layui-icon">&#xe613;</i>合作伙伴管理</a>
                        </li>
                        <li class="layui-nav-item">
                            <a href="/wanted/list.action"><i class="layui-icon">&#xe611;</i>招聘信息管理</a>
                        </li>
                        <li class="layui-nav-item">
                            <a href="/welfare/list.action"><i class="layui-icon">&#xe620;</i>公司福利信息管理</a>
                        </li>
                        <li class="layui-nav-item">
                            <a href="/information/list.action"><i class="layui-icon">&#xe620;</i>平台信息管理</a>
                        </li>
			        </ul>
		    </div>
		  </div>
			<div class="layui-body">