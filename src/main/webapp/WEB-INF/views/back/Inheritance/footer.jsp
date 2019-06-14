<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="layui-body-bottom">
  <h5>Copyright 2019 ©智莱云后台管理系统.All rights reserved.</h5>
</div>
</div>
</div>
<script type="text/javascript">
  function btnStatic() {
    $.ajax({
      url: "/staticAllPage.action",
      type: "GET",
      success: function (map) {
        console.log(map)
        if (map.code == 1) {
          layer.msg("前台页面静态化成功！", {icon: 6})
        }
      },
      error: function (result) {
        window.wxc.xcConfirm("抱歉！出了一点小问题", window.wxc.xcConfirm.typeEnum.error);
      }
    });
  }

  function nacSelect(index) {
    $(".side-scrolls>li").eq(index).addClass("layui-this layui-nav-itemed");
  }

  function formatDateTime(time) {
    var date = new Date(time);
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    month = month < 10 ? "0" + month : month;
    day = day < 10 ? "0" + day : day;
    return year + "-" + month + "-" + day;
  };
</script>
