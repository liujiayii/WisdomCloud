<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
<!-- 内容主体区域 -->
<div class="layui-body-top">
	<span class="layui-breadcrumb">
		<a href=""><cite><i class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a>
		<a href="">案例管理</a>
		<a href="">案例修改</a>
	</span>
</div>
<div class="layui-body-content">
  <p class="ContP"><img src="/img/back/dataSj.png">案例修改</p>
  <div class="ContDom ContForm">
    <div class="formDemo">
      <form action="" method="post" class="layui-form addForm" lay-filter="formTest">
        <input type="hidden" value="" name="id">
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">图片编号</label>
            <div class="layui-input-inline">
              <input type="text" value="" lay-verify="required" name="imageNumber" class="layui-input" maxlength="10"
                     readonly/>
            </div>
            <div class="layui-form-mid layui-word-aux">1-10个字符</div>
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">图片位置</label>
            <div class="layui-input-inline">
              <input type="text" value="" lay-verify="required" name="imgPlace" class="layui-input" maxlength="50"
                     readonly/>
            </div>
            <div class="layui-form-mid layui-word-aux">1-50个字符</div>
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">图片名称</label>
            <div class="layui-input-inline">
              <input type="text" value="" lay-verify="required" name="name" class="layui-input" maxlength="10"
                     readonly/>
            </div>
            <div class="layui-form-mid layui-word-aux">1-10个字符</div>
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">图片</label>
            <input type="hidden" value="" name="imgUrl" id="imgUrl"/>
            <div class="layui-upload-list">
              <img class="layui-upload-img" id="demo1" src="" alt="选择图片" title="图片">
              <p id="demoText"></p>
            </div>
            <div class="layui-input-block imageArea">
              <p id="test1">本地上传</p>
              <p>1920*800，jpg/png,大小不超过2M</p>
            </div>
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
  nacSelect(5);
  $(function () {
    // 详情页面加载执行
    layui.use(['form', 'jquery', 'element', 'layer', 'table', 'laydate', 'upload'], function () {
      var table = layui.table, element = layui.element, form = layui.form, jquery = layui.jquery;
      var layer = layui.layer, laydate = layui.laydate, upload = layui.upload;
      var id = getHrefParam(name);
      $.ajax({
        url: '/picture/getById.action',
        type: 'post',
        dataType: 'json',
        data: {
          id: id
        },
        success: function (result) {
          console.log(result);
          console.log(result.data);
          if (result.code == 0) {
            $("#imgUrl").val(result.data.imgUrl);
            $("#demo1").attr("src", result.data.imgUrl);
            // 表单初始赋值
            form.val('formTest', result.data);
          }
        }
      });
    })
  })
  layui.use(['form', 'jquery', 'element', 'layer', 'table', 'laydate', 'upload'], function () {
    var table = layui.table, element = layui.element, form = layui.form, jquery = layui.jquery;
    var layer = layui.layer, laydate = layui.laydate, upload = layui.upload;

    /*时间*/
    laydate.render({
      elem: '#time', //指定元素
    });


    //普通图片上传
    var uploadInst = upload.render({
      elem: '#test1'
      , method: 'POST'
      , url: '/main/addImg.action'
      , before: function (obj) {
        //预读本地文件示例，不支持ie8
        obj.preview(function (index, file, result) {
          $('#demo1').attr('src', result); //图片链接（base64）
        });
      }
      , done: function (res) {
        //如果上传失败
        if (res.code == 0) {
          uploads = res.data;
          $("#imgUrl").val(res.data);
          return layer.msg(res.msg);
        } else if (res.code > 0) {
          return layer.msg("上传失败");
        }
        //上传成功
      }
      , error: function () {
        //演示失败状态，并实现重传
        var demoText = $('#demoText');
        demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
        demoText.find('.demo-reload').on('click', function () {
          uploadInst.upload();
        });
      }
    });

    form.on('submit(add-member-submit)', function (data) {
      delete data.field.file;
      $.ajax({
        url: "/picture/update.action",
        data: JSON.stringify(data.field),
        contentType: 'application/json',
        type: "POST",
        dataType: "json",
        success: function (map) {
          if (map.code == 0) {
            window.location.href = "/picture/list.action";
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
