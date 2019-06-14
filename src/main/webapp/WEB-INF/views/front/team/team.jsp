<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<head>
  <meta content="${s1045}" name="Keywords">
  <meta name="description" content="${s1046}">
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
        <li class="liSelected">团队</li>
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
  <div class="team-banner" style="background: url(${s2024}) no-repeat center;">
  </div>
  <div class="ourTeam">
    <h1><img src="../../../img/font/ple.jpg"/>我们的团队</h1>
    ${information.ourTeam}
  </div>
  <div class="jobDes">

  </div>
  <div class="address-footer">
    <img src="../../../img/font/tel.jpg"/>${information.companyPhone }
    <img src="../../../img/font/address.png"/>${information.companyAddress}
  </div>
  <jsp:include page="../nav/footer.jsp"></jsp:include>
  <script type="text/javascript">
    $(function () {
      $.ajax({
        url: "/group/listByGroupPage.action",
        type: "POST",
        dataType: "json",
        async: false, //同步执行
        success: function (result) {
          console.log(result)
          if (result) {
            for (var i = 0; i < result.data.length; i++) {
              $(".jobDes").append("<div class='jobDes-box'><img src='" + result.data[i].group_img + "' /><span>" + result.data[i].name + "</span><h3>" + result.data[i].station + "</h3><p><img src='../../../img/font/email.png'>" + result.data[i].email + "</p></div>")
            }
          }
        },
        error: function (result) {
          window.wxc.xcConfirm("抱歉！出了一点小问题", window.wxc.xcConfirm.typeEnum.error);
        }
      });
    })
  </script>
  </body>
  </html>
