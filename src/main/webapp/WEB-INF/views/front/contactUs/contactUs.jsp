<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<head>
<meta charset="utf-8" />
<meta content="${s1049}" name="Keywords">
<meta name="description" content="${s1050}">
</head>
<jsp:include page="../nav/nav.jsp"></jsp:include>
<div class="navs navas">
	<div class="nav-content">
		<img src="${s2002}" class="logoimg" />
		<ul class="nav-list">
			<a href="/main/index.action">
				<li>首页</li>
			</a>
			<a href="/main/about.action">
				<li>关于</li>
			</a>
			<a href="/case/case.action">
				<li>案例</li>
			</a>
			<a href="/main/model.action">
				<li>模版</li>
			</a>
			<a href="/main/advantage.action">
				<li>优势</li>
			</a>
			<a href="/main/team.action">
				<li>团队</li>
			</a>
			<a href="/main/employeePage.action">
				<li>招聘</li>
			</a>
			<a href="/main/contactUs.action">
				<li class="liSelected">联系我们</li>
			</a>
		</ul>
	</div>
</div>
<div class="mian" id="app">
	<div class="contactUs-banner"
		style="background: url(${s2025}) no-repeat center;"></div>
	<h1 style="text-align: center; font-size: 30px; font-weight: bold">在线申请项目报价</h1>
	<el-form class="contactUs-form" ref="form" :model="form"
		label-width="100px" :rules="rules"> <el-form-item
		label="项目类型" prop="type"> <el-select
		v-model="form.type" placeholder="请选择项目类型"> <el-option
		v-for="item of type" :label="item.typeName" :value="item.typeName"></el-option>
	</el-select> </el-form-item> <el-form-item label="项目简介" prop="introduction"> <el-input
		type="textarea" v-model="form.introduction" placeholder="最多输入500字"></el-input>
	<p v-if="form.introduction">
		<span v-if="form.introduction.length<500">当前还可输入{{500-form.introduction.length}}字</span>
		<span v-else>已超出{{form.introduction.length-500}}字</span>
	</p>
	</el-form-item> <el-form-item label="联系电话" prop="phone"> <el-input
		v-model.number="form.phone"></el-input> </el-form-item> <el-form-item label="姓名"
		prop="name"> <el-input v-model="form.name"></el-input>
	</el-form-item> <el-form-item label="备注"> <el-input type="textarea"
		v-model="form.remark"></el-input> </el-form-item> <el-form-item> <el-button
		type="primary" @click="onSubmit('form')">提交</el-button> </el-form-item> </el-form>
	<div class="map" id="map"></div>
</div>
<div class="address-footer">
	<img src="../../../img/font/tel.jpg" />${information.companyPhone } <img
		src="../../../img/font/address.png" />${information.companyAddress}
</div>
<jsp:include page="../nav/footer.jsp"></jsp:include>
<script type="text/javascript"
	src="https://api.map.baidu.com/api?v=2.0&amp;ak=PdAQXjrLc1LV8SgFtnkm1QCo&amp;s=1"></script>
<script type="text/javascript"
	src="https://api.map.baidu.com/getscript?v=2.0&amp;ak=PdAQXjrLc1LV8SgFtnkm1QCo&amp;services=&amp;t=20190123111209"></script>
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
    map.centerAndZoom(new BMap.Point(114.4823528327, 38.0747282958), 18);
  }

  function setMapEvent() {
    map.enableScrollWheelZoom();
    map.enableKeyboard();
    map.enableDragging();
    map.enableDoubleClickZoom()
  }

  function addClickHandler(target, window) {
    target.addEventListener("click", function () {
      target.openInfoWindow(window);
    });
  }

  function addMapOverlay() {
    var markers = [{
      content: "我的备注",
      title: "智莱云",
      imageOffset: {
        width: 0,
        height: 3
      },
      position: {
        lat: 38.074982958,
        lng: 114.4823528327
      }
    }];
    for (var index = 0; index < markers.length; index++) {
      var point = new BMap.Point(markers[index].position.lng,
        markers[index].position.lat);
      var marker = new BMap.Marker(
        point,
        {
          icon: new BMap.Icon(
            "http://api.map.baidu.com/lbsapi/createmap/images/icon.png",
            new BMap.Size(20, 25), {
              imageOffset: new BMap.Size(
                markers[index].imageOffset.width,
                markers[index].imageOffset.height)
            })
        });
      var label = new BMap.Label(markers[index].title, {
        offset: new BMap.Size(25, 5)
      });
      var opts = {
        width: 200,
        title: markers[index].title,
        enableMessage: false
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
        position: new BMap.Point(labels[index].position.lng,
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
      anchor: BMAP_ANCHOR_BOTTOM_LEFT
    });
    scaleControl.setUnit(BMAP_UNIT_IMPERIAL);
    map.addControl(scaleControl);
    var navControl = new BMap.NavigationControl({
      anchor: BMAP_ANCHOR_TOP_LEFT,
      type: BMAP_NAVIGATION_CONTROL_LARGE
    });
    map.addControl(navControl);
    var overviewControl = new BMap.OverviewMapControl({
      anchor: BMAP_ANCHOR_BOTTOM_RIGHT,
      isOpen: true
    });
    map.addControl(overviewControl);
  }

  var map;
  initMap();
</script>
<script type="text/javascript">
  Vue.use(ELEMENT)

  let vm = new Vue({
    el: '#app',
    data() {
      let validatePhone = (rule, value, callback) => {
        if (!(/^1[3456789]\d{9}$/.test(value)) && !(/^\d{3,4}-\d{7,8}$/.test(value))) {
          callback(new Error('请输入正确的联系方式'));
        } else {
          callback();
        }
      };
      return {
        form: {},
        type: [],
        rules: {
          type: [
            {required: true, message: '请选择项目类型', trigger: 'blur'}
          ],
          introduction: [
            {required: true, message: '请输入项目简介', trigger: 'blur'},
            {min: 1, max: 500, message: '最多500个字符', trigger: 'blur'}
          ],
          name: [
            {required: true, message: '请输入姓名', trigger: 'blur'},
            {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
          ],
          phone: [
            {required: true, message: '请输入电话', trigger: 'blur'},
            {validator: validatePhone, trigger: 'blur'}
          ],
        }
      }
    },
    methods: {
      getType() {
        $.ajax({
          url: "/type/showAllType.action",
          type: "POST",
          dataType: "json",
          success: (res) => {
            console.log(res)
            if (res.code === 0) {
              this.type = res.data
            }
          }
        });
      },
      onSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            $.ajax({
              url: "/message/insert.action",
              data: JSON.stringify(this.form),
              contentType: 'application/json',
              type: "POST",
              dataType: "json",
              success: (res) => {
                if (res.code === 0) {
                  this.$message({
                    message: res.msg,
                    type: 'success',
                    onClose() {
                      window.location.href = "/main/index.action"
                    }
                  });
                } else {
                  this.$message.error(res.msg);
                }
              }
            });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      }
    },
    mounted() {
      this.getType()
    }
  })
</script>
</body>
</html>
