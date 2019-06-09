<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<head>
<meta content="${s1049}" name="Keywords">
<meta name="description" content="${s1050}">
</head>
<jsp:include page="../nav/nav.jsp"></jsp:include>
		<div class="navs navas">
			<div class="nav-content">
				<img src="${s2002}" class="logoimg"/>
				<ul class="nav-list">
					<a href="/main/index.action"><li>首页</li></a>
					<a href="/main/about.action"><li>关于</li></a>
					<a href="/case/case.action"><li>案例</li></a>
					<a href="/main/advantage.action"><li>优势</li></a>
					<a href="/main/team.action"><li>团队</li></a>
					<a href="/main/employeePage.action"><li>招聘</li></a>
					<a href="/main/contactUs.action"><li class="liSelected">联系我们</li></a>
				</ul>
			</div>
		</div>
		<div class="mian">
			<div class="contactUs-banner" style="background: url(${s2025}) no-repeat center;">
			</div>
			<form class="contactUs-form layui-form" action="" method="post" id="contactUs-form">
				<h1>在线申请项目报价</h1>
				<div class="form-list">
					<span>项目类型：</span><input type="text" name="type"  lay-verify="required" placeholder="如app，网站建站，软件开发，平面设计，其他"/>
				</div>
				<div class="form-list">
					<span>项目简介：</span><textarea name="introduction" lay-verify="required"></textarea>
				</div>
				<div class="form-list">
					<span>联系电话：</span><input type="text" name="phone" maxlength="11"  lay-verify="required|phone"/>
				</div>
				<div class="form-list">
					<span>姓名：</span><input type="text" name="name"  lay-verify="required" />
				</div>
				<div class="form-list">
					<span>备注：</span><textarea name="remark"></textarea>
				</div>
				<input type="button" value="提交" class="sub-btns" lay-submit lay-filter="add-member-submit"/>
			</form>
			<div class="map" id="map">
			</div>
			<div class="address-footer">
				<img src="../../../img/font/tel.jpg" />${information.companyPhone }
				<img src="../../../img/font/address.png" />${information.companyAddress}
			</div>
		<jsp:include page="../nav/footer.jsp"></jsp:include>
		<script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&amp;ak=PdAQXjrLc1LV8SgFtnkm1QCo&amp;s=1"></script>
		<script type="text/javascript" src="https://api.map.baidu.com/getscript?v=2.0&amp;ak=PdAQXjrLc1LV8SgFtnkm1QCo&amp;services=&amp;t=20190123111209"></script>
		<script type="text/javascript">
			//创建和初始化地图函数：
			function initMap() {
				createMap();//创建地图
				setMapEvent();//设置地图事件
				addMapControl();//向地图添加控件
				addMapOverlay();//向地图添加覆盖物
			}
			function createMap() {
				map = new BMap.Map("map");
				map.centerAndZoom(new BMap.Point(114.4823528327,38.0747282958), 18);
			}
			function setMapEvent() {
				map.enableScrollWheelZoom();
				map.enableKeyboard();
				map.enableDragging();
				map.enableDoubleClickZoom()
			}
			function addClickHandler(target, window) {
				target.addEventListener("click", function() {
					target.openInfoWindow(window);
				});
			}
			function addMapOverlay() {
				var markers = [ {
					content : "我的备注",
					title : "智莱云",
					imageOffset : {
						width : 0,
						height : 3
					},
					position : {
						lat : 38.074982958,
						lng : 114.4823528327
					}
				} ];
				for (var index = 0; index < markers.length; index++) {
					var point = new BMap.Point(markers[index].position.lng,
							markers[index].position.lat);
					var marker = new BMap.Marker(
							point,
							{
								icon : new BMap.Icon(
										"http://api.map.baidu.com/lbsapi/createmap/images/icon.png",
										new BMap.Size(20, 25), {
											imageOffset : new BMap.Size(
													markers[index].imageOffset.width,
													markers[index].imageOffset.height)
										})
							});
					var label = new BMap.Label(markers[index].title, {
						offset : new BMap.Size(25, 5)
					});
					var opts = {
						width : 200,
						title : markers[index].title,
						enableMessage : false
					};
					var infoWindow = new BMap.InfoWindow(markers[index].content, opts);
					marker.setLabel(label);
					addClickHandler(marker, infoWindow);
					map.addOverlay(marker);
				}
				;
				var labels = [];
				for (var index = 0; index < labels.length; index++) {
					var opt = {
						position : new BMap.Point(labels[index].position.lng,
								labels[index].position.lat)
					};
					var label = new BMap.Label(labels[index].content, opt);
					map.addOverlay(label);
				}
				;
			}
			//向地图添加控件
			function addMapControl() {
				var scaleControl = new BMap.ScaleControl({
					anchor : BMAP_ANCHOR_BOTTOM_LEFT
				});
				scaleControl.setUnit(BMAP_UNIT_IMPERIAL);
				map.addControl(scaleControl);
				var navControl = new BMap.NavigationControl({
					anchor : BMAP_ANCHOR_TOP_LEFT,
					type : BMAP_NAVIGATION_CONTROL_LARGE
				});
				map.addControl(navControl);
				var overviewControl = new BMap.OverviewMapControl({
					anchor : BMAP_ANCHOR_BOTTOM_RIGHT,
					isOpen : true
				});
				map.addControl(overviewControl);
			}
			var map;
			initMap();
		</script>
		<script type="text/javascript">
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
		</script>
	</body>
</html>
