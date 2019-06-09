<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<link rel="icon" href="${s2001}" type="img/x-ico" />
		<title>${s101}</title>
		<link rel="stylesheet" href="../../../css/style.css" />
		<link rel="stylesheet" href="../../../css/currency.css" />
	    <link rel="stylesheet" type="text/css" href="../../../css/font.css"/>
	    <link rel="stylesheet" type="text/css" href="../../../js/layui/css/layui.css"/>
		<script type="text/javascript" src="../../../js/jquery1.11.3-jquery.min.js" ></script>
		<script type="text/javascript" src="../../../js/layui/layui.js" ></script>
		<script type="text/javascript" src="../../../js/inheritance.js" ></script>
		<script type="text/javascript">
			function formatDateTime(time){
			    var date = new Date(time);
			    var year = date.getFullYear();
			    var month = date.getMonth()+1;
			    var day = date.getDate();
			    month = month < 10 ? "0"+month:month;
			    day = day < 10 ? "0"+day:day;
			    return year+"-"+month+"-"+day;
			};
		</script>
	</head>
	<body>