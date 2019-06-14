<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
<!-- 内容主体区域 -->
<div class="layui-body-top">
					<span class="layui-breadcrumb">
					  	<a href=""><cite><i class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a>
					  	<a href="">文字管理</a>
					  	<a href="">文字添加</a>
					</span>
</div>
<div class="layui-body-content">
  <p class="ContP"><img src="/img/back/dataSj.png">文字添加</p>
  <div class="ContDom ContForm">
    <div class="formDemo">
      <form action="" method="post" class="layui-form addForm">
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">文字编号</label>
            <div class="layui-input-inline">
              <input type="text" value="" lay-verify="required" name="id" class="layui-input" maxlength="10"/>
            </div>
            <div class="layui-form-mid layui-word-aux">1-10个字符</div>
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">文字位置</label>
            <div class="layui-input-inline">
              <input type="text" value="" lay-verify="required" name="textPlace" class="layui-input" maxlength="50"/>
            </div>
            <div class="layui-form-mid layui-word-aux">1-50个字符</div>
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">文字名称</label>
            <div class="layui-input-inline">
              <input type="text" value="" lay-verify="required" name="name" class="layui-input" maxlength="10"/>
            </div>
            <div class="layui-form-mid layui-word-aux">1-10个字符</div>
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">文字内容</label>
            <input type="text" value="" lay-verify="required" name="textInfo"/>
          </div>
        </div>
        <div class="layui-form-item ">
          <div class="layui-inline  form-submit">
            <input type="button" class="layui-btn buts" lay-submit value="保存" lay-filter="add-member-submit"/>
            <input type="button" name="" onclick="javascript:history.back(-1);" class="layui-btn buts resets"
                   value="取消"/>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
<jsp:include page="../Inheritance/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
  nacSelect(4);
  layui.use(['form', 'jquery', 'element', 'layer', 'table', 'laydate', 'upload'], function () {
    var table = layui.table, element = layui.element, form = layui.form, jquery = layui.jquery;
    var layer = layui.layer, laydate = layui.laydate, upload = layui.upload;

    /*时间*/
    laydate.render({
      elem: '#time', //指定元素
    });


    form.on('submit(add-member-submit)', function (data) {
      delete data.field.file;
      $.ajax({
        url: "/text/insert.action",
        data: JSON.stringify(data.field),
        contentType: 'application/json',
        type: "POST",
        dataType: "json",
        success: function (map) {
          console.log(map)
          if (map.code == 0) {

            window.location.href = "/text/list.action";
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


</script>

</html>
