<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<meta content="${s1043}" name="Keywords">
<meta name="description" content="${s1044}">
</head>
<jsp:include page="../nav/nav.jsp"></jsp:include>
		<div class="navs navas">
			<div class="nav-content">
				<img src="${s2002}" class="logoimg"/>
				<ul class="nav-list">
					<a href="/main/index.action"><li>首页</li></a>
					<a href="/main/about.action"><li>关于</li></a>
					<a href="/case/case.action"><li>案例</li></a>
					<a href="/main/advantage.action"><li class="liSelected">优势</li></a>
					<a href="/main/team.action"><li>团队</li></a>
					<a href="/main/employeePage.action"><li>招聘</li></a>
					<a href="/main/contactUs.action"><li>联系我们</li></a>
				</ul>
			</div>
		</div>
		<div class="mian">  <!--     background: url(../img/font/map.png) no-repeat center; -->
			<div class="advantage-banner" style="background: url(${s2022}) no-repeat center;">
				${s1033}
			</div>
			<div class="advantage-img" style="background: url(${s2023}) no-repeat center;">
			</div>
			<div class="address-footer">
				<img src="../../../img/font/tel.jpg" />${information.companyPhone }
				<img src="../../../img/font/address.png" />${information.companyAddress}
			</div>
		<jsp:include page="../nav/footer.jsp"></jsp:include>
		<script type="text/javascript">
		</script>
	</body>
</html>
