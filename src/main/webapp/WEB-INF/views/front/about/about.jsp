<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
  <meta content="${s1039}" name="Keywords">
  <meta name="description" content="${s1040}">
</head>
<jsp:include page="../nav/nav.jsp"></jsp:include>
<div class="navs navas">
  <div class="nav-content">
    <img src="${s2002}" class="logoimg"/>
    <ul class="nav-list">
      <a href="/main/index.action">
        <li>首页</li>
      </a>
      <a href="/main/about.action">
        <li class="liSelected">关于</li>
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
        <li>联系我们</li>
      </a>
    </ul>
  </div>
</div>
<div class="mian">
  <div class="about-banner" style="background: url(${s2019}) no-repeat center;">
  </div>
  <div class="border-box">
    <div class="aboutUs">
      <h3>关于我们</h3>
      <h1>ABO<u>U</u>T US</h1>
      <div class="elements">
        <img src="${s2020}"/>
        <div class="divs">

          ${information.aboutUs }
        </div>
      </div>
    </div>
    <div class="worth" style="background: url(${s2016}) no-repeat center #000000;">
      <h1>${s1030}</h1>
      <span>
			${s1031}<br/>
			${s1032}
		</span>
    </div>
    <div class="dynamic">
      <h3>企业动态</h3>
      <h1>ENTERPRIS<u>E</u> DYNAMICS</h1>
      <div class="dynamicArea">

      </div>
    </div>
  </div>
  <div class="add">
    <div class="addbut" onclick="addNews();"></div>
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
        <form action="" method="post" class="layui-form">
          <input type="hidden" name="status" value="0">
          <div class="form-box">
            <span>项目类型：</span><input type="text" name="type" lay-verify="required"
                                     placeholder="如app，网站建站，软件开发，平面设计，其他"/>
          </div>
          <div class="form-box">
            <span>项目简介：</span><input type="text" name="introduction" lay-verify="required"/>
          </div>
          <div class="form-box">
            <span>联系电话：</span><input type="text" name="phone" maxlength="11" lay-verify="required|phone"/>
          </div>
          <div class="form-box">
            <span>姓名：</span><input type="text" name="name" lay-verify="required"/>
          </div>
          <div class="form-box">
            <span>备注：</span><input type="text" name="remark"/>
          </div>
          <input type="button" value="提交" id="sub" lay-submit lay-filter="add-member-submit"/>
        </form>
      </div>
    </div>
  </div>
  <jsp:include page="../nav/footer.jsp"></jsp:include>
  <script type="text/javascript">
    $(function () {
      $(".addbut").trigger("click");
    })
    /* 提交留言 */
    layui.use(['form', 'jquery', 'layer', 'laydate'], function () {
      var form = layui.form, jquery = layui.jquery;
      var layer = layui.layer, laydate = layui.laydate;

      form.on('submit(add-member-submit)', function (data) {
        $.ajax({
          url: "/message/insert.action",
          data: $httpParamSerializer({
            news: JSON.stringify(data.field)
          }),
          contentType: 'application/json',
          type: "POST",
          dataType: "json",
          success: function (map) {
            if (map.code == 0) {
              layer.msg("添加留言成功，稍后我们的工作人员会联系您", {
                icon: 6, time: 500, end: function () {
                  window.location.href = "/main/index.action";
                }
              })
            } else {
              layer.msg(map.msg, {icon: 5})
            }
          },
          error: function (result) {
            window.wxc.xcConfirm("抱歉！出了一点小问题", window.wxc.xcConfirm.typeEnum.error);
          }
        });
      })
    })

    var page = 1;

    function addNews() {
      $.ajax({
        url: "/news/listMovement.action",
        data: {'page': page, 'limit': 6},
        type: "POST",
        dataType: "json",
        async: false, //同步执行
        success: function (result) {
          if (result.data.list.length < 6) {
            $(".addbut").css("display", "none")
          }
          if (result.data.list.length >= 0) {
            for (var i = 0; i < result.data.list.length; i++) {
              $(".dynamicArea").append("<div class='dynamic-list'><img src='" + result.data.list[i].img_one + "'><div class='dtxt'><p  onclick=\"window.location.href='/main/businessMovement.action?id=" + result.data.list[i].id + "'\">" + result.data.list[i].title + "</p><span>" + formatDateTime(result.data.list[i].time) + "</span></div>");
            }
          }
        },
        error: function (result) {
          window.wxc.xcConfirm("抱歉！出了一点小问题", window.wxc.xcConfirm.typeEnum.error);
        }
      });
      page = page + 1
    }

  </script>
  </body>
  </html>
