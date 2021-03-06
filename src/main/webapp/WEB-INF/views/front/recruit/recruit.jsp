<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
        <link rel="icon" href="${s2001}" type="img/x-ico" />
		<title>${s101}</title>
		<meta content="${1047}" name="Keywords">
		<meta name="description" content="${1048}">
		<link rel="stylesheet" href="../../../css/style.css" />
		<link rel="stylesheet" type="text/css" href="../../../css/currency.css"/>
		<link rel="stylesheet" type="text/css" href="../../../js/layui/css/layui.css"/>
		<link rel="stylesheet" href="../../../css/index.css" />
		<link rel="stylesheet" href="../../../dist/css/swiper.min.css">
		<script type="text/javascript" src="../../../js/jquery1.11.3-jquery.min.js" ></script>
		<script type="text/javascript" src="../../../js/inheritance.js" ></script>
		<script type="text/javascript" src="../../../js/layui/layui.js" ></script>
		<script src="../../../dist/js/swiper.min.js"></script>
		<style type="text/css">
			.swiper-slide {
		        /* Center slide text vertically */
		        display: -webkit-box;
		        display: -ms-flexbox;
		        display: -webkit-flex;
		        display: flex;
		        -webkit-box-pack: center;
		        -ms-flex-pack: center;
		        -webkit-justify-content: center;
		        justify-content: center;
		        -webkit-box-align: center;
		        -ms-flex-align: center;
		        -webkit-align-items: center;
		        align-items: center;
		    }
		</style>
	</head>
	<body>
		<div class="nav">
			<div class="nav-content">
				<img src="${s2002}" class="logoimg"/>
				<ul class="nav-list">
					<a href="/main/index.action"><li>首页</li></a>
					<a href="/main/about.action"><li>关于</li></a>
					<a href="/case/case.action"><li>案例</li></a>
					<a href="/main/model.action"><li>模版</li></a>
					<a href="/main/advantage.action"><li>优势</li></a>
					<a href="/main/team.action"><li>团队</li></a>
					<a href="/main/employeePage.action"><li class="liSelected">招聘</li></a>
					<a href="/main/contactUs.action"><li>联系我们</li></a>
				</ul>
			</div>
		</div>
		<div class="mian">
			<div class="jumbotron" style="background: url(${s2026}) no-repeat center ">
				<h1>${s1034}</h1>
				<p>${s1035}${s1036}</p>
				
			</div>
			<div class="recruitsBox">
				<h1>JOIN THE ELECTRICITY SOUL</h1>
				<h3>社会招聘</h3>
				<div class="recruitsTable">
					<!-- <div class="recruitSearch">
						<form class="layui-form" method="post">
							<input type="text" name="job" placeholder="搜索您需要的职位" class="layui-input inputsP" />
							<button type="button"  onclick="search()" class="searchs">搜索</button>
						</form>
					</div> -->
					<script type="text/javascript">/* getWantedByjob */
						function search(){
							  
						}
					</script>
					<div class="ulsConts">
						<div class="ulTopArea">
							<ul>
								<li>招聘岗位</li>
								<li>人数</li>
								<li>学历</li>
								<li>专业</li>
								<li>工作地点</li>
							</ul>
						</div>
						<div class="ulTopAreas">
					        <c:forEach items="${wantedList}" var="wanted">
							<div class="liTopArea">
								<ul>
									<li>${wanted.job}</li>
									<li>${wanted.wantNumber}</li>
									<li>${wanted.education}</li>
									<li>${wanted.major}</li>
									<li>${wanted.workplace}</li>
								</ul>
								<ol class="olAreas">
									<li>${wanted.remark}</li>
								</ol>
							</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="recruitSwiper">
				<h2>JOIN THE ELECTRICITY SOUL</h2>
				<p><b>员工风采</b></p>
				<div class="swiper-container swipDoms">
			        <div class="swiper-wrapper swipDoms-Area">
			            <div class="swiper-slide"><img alt="员工风采" src="${s2028}"></div>
			            <div class="swiper-slide"><img alt="员工风采" src="${s2029}"></div>
			            <div class="swiper-slide"><img alt="员工风采" src="${s2030}"></div>
			            <div class="swiper-slide"><img alt="员工风采" src="${s2031}"></div>
			            <div class="swiper-slide"><img alt="员工风采" src="${s2032}"></div>
			        </div>
			        <!-- Add Pagination -->
			        <div class="swiper-pagination"></div>
			        <!-- Add Arrows -->
			        <div class="swiper-button-next"></div>
			        <div class="swiper-button-prev"></div>
			    </div>
			</div>
			<div class="recruitSwiper">
				<h2>JOIN THE ELECTRICITY SOUL</h2>
				<p><b>办公环境</b></p>
				<div class="swiper-container swipDoms">
			        <div class="swiper-wrapper swipDoms-Brea">
			            <div class="swiper-slide"><img alt="办公环境" src="${s2033}"></div>
			            <div class="swiper-slide"><img alt="办公环境" src="${s2034}"></div>
			            <div class="swiper-slide"><img alt="办公环境" src="${s2035}"></div>
			            <div class="swiper-slide"><img alt="办公环境" src="${s2036}"></div>
			            <div class="swiper-slide"><img alt="办公环境" src="${s2037}"></div>
			        </div>
			        <!-- Add Pagination -->
			        <div class="swiper-pagination"></div>
			        <!-- Add Arrows -->
			        <div class="swiper-button-next"></div>
			        <div class="swiper-button-prev"></div>
			    </div>
			</div>
			<div class="tabAreas">
				<h2>
					<span class="spans titles">公司福利</span>
				</h2>
				<div class="divs shows" style="background: url(${s2027}) no-repeat center ">
					<div class="ContDivs">
						<div class="indexT">  
						    <c:forEach items="${welfareList}" var="welfare">
						          <p><span>${welfare.title} : </span>${welfare.content}</p>
						    </c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="address-footer">
				<img src="../../../img/font/tel.jpg" />${information.companyPhone }
				<img src="../../../img/font/address.png" />${information.companyAddress}
			</div>
	<jsp:include page="../nav/footer.jsp"></jsp:include>
	<div class="popupBg">
		<div class="popup">
			<img src="../../../img/font/guang.png" />
			<div class="popup-text">
				<h1>恭喜您投递简历成功</h1>
				<p>稍后会有我们的工作人员<br />与您联系</p>
				<button>好的</button>
			</div>
		</div>
	</div>
	<!-- <div class="popupBgs">
		<div class="popups">
			<form class=""  action="" method="post">
				<div class="f-items">
					<label>姓名</label>
					<input type="text" value="" name="" class="f-int-Big">
				</div>
				<div class="f-items">
					<label>手机</label>
					<input type="text" value="" name="" class="f-int-Big">
				</div>
				<div class="f-items">
					<label>手机</label>
					<input id="upfile" type="file" name="upfile" accept=".xls,.xlsx" class="f-int-Big" />
					<label><input id="import" name="import"  type="submit" class="scbtn"  onclick="return checkData()"value="批量导入"  /></label>
				</div>
				<div class="f-items" style="text-align: center;">
					<label></label>
					<input type="submit" value="" name="" class="f-int-Big" value="发送">
				</div>
			</form>
		</div>
	</div> -->
	<script type="text/javascript">
	$(function(){
		$('.liTopArea').mouseover(function(){
			$(this).find('.olAreas').show();
		});
		$('.liTopArea').mouseout(function(){
			$(this).find('.olAreas').hide();
		});
		
	    var swiper = new Swiper('.swiper-container', {
	        pagination: '.swiper-pagination',
	        nextButton: '.swiper-button-next',
	        prevButton: '.swiper-button-prev',
	        slidesPerView: 1,
	        paginationClickable: true,
	        spaceBetween: 30,
	        loop: true
	    });
	    
		//tab切换
		window.onload = function(){
			var spans = document.getElementsByClassName("spans");
			var divs = document.getElementsByClassName("divs");
			for(var i = 0;i<spans.length;i++){
				spans[i].onclick = function(i){
					return function(){
						for(var j = 0;j<spans.length;j++){
							spans[j].className = "spans";
							divs[j].className = "divs";
						}
						spans[i].className = "spans titles";
						divs[i].className = "divs shows";
					}
				}(i);
			}
		}
	
		$(window).scroll(function(){
			if($(document).scrollTop() > 630){
				$('.nav').addClass('navs');
			}else{
				$('.nav').removeClass('navs')
			}
		})
		
	})
</script>
</body>
</html>
