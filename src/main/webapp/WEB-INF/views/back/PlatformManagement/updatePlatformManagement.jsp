<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
<!-- 内容主体区域 -->
<div class="layui-body-top">
					<span class="layui-breadcrumb">
					  	<a href=""><cite><i class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a>
					  	<a href="">公司信息展示</a>
					  	<a href="">公司信息修改</a>
					</span>
</div>
<div class="layui-body-content">
  <p class="ContP"><img src="/img/back/dataSj.png">公司信息修改添加</p>
  <div class="ContDom ContForm">
    <form action="" method="post" class="layui-form addForm">
      <input type="hidden" value="${information[0].id }" name="id">
      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">公司名称</label>
          <div class="layui-input-inline">
            <input type="text" name="companyName" value="${information[0].companyName}" lay-verify="required"
                   placeholder="" autocomplete="off" class="layui-input">
          </div>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">公司电话</label>
          <div class="layui-input-inline">
            <input type="text" name="companyPhone" value="${information[0].companyPhone }" lay-verify="required"
                   placeholder="" autocomplete="off" class="layui-input">
          </div>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">公司地址</label>
          <div class="layui-input-inline">
            <input type="text" value="${information[0].companyAddress}" name="companyAddress" class="layui-input"
                   lay-verify="required"/>
          </div>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">公司QQ</label>
          <div class="layui-input-inline">

            <input type="text" value="${information[0].qq }" name="qq" class="layui-input" lay-verify="required"/>

          </div>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">公司邮编</label>
          <div class="layui-input-inline">

            <input type="text" value="${information[0].postcode }" name="postcode" class="layui-input"
                   lay-verify="required"/>

          </div>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">公司邮箱</label>
          <div class="layui-input-inline">
            <input type="text" value="${information[0].email }" name="email" class="layui-input" lay-verify="required"/>
          </div>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">关于我们信息</label>
          <div class="layui-input-inline" style="width: 1200px;">
            <textarea class="layui-textarea" id="aboutUs" style="display: none;" name="aboutUs" lay-verify="content">${information[0].aboutUs }</textarea>
          </div>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">我们的团队信息</label>
          <div class="layui-input-inline" style="width: 1200px;">

            <textarea class="layui-textarea" id="ourTeam" style="display: none;" name="ourTeam" lay-verify="contents">${information[0].ourTeam}</textarea>

          </div>
        </div>
      </div>
      <div class="layui-form-item ">
        <div class="layui-inline  form-submit">
          <input type="button" name="" class="layui-btn buts" lay-submit value="保存" lay-filter="add-member-submit"/>
          <input type="button" name="" onclick="javascript:history.back(-1);" class="layui-btn buts resets" value="取消"/>
        </div>
      </div>
    </form>
  </div>
</div>
<jsp:include page="../Inheritance/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
  nacSelect(10);
  layui.use(['form', 'jquery', 'element', 'layer', 'table', 'laydate', 'upload', 'layedit'], function () {
    var table = layui.table, element = layui.element, form = layui.form, jquery = layui.jquery;
    var layer = layui.layer, laydate = layui.laydate, upload = layui.upload, layedit = layui.layedit;

    /*时间*/
    laydate.render({
      elem: '#time', //指定元素
    });

    //富文本编译器
    var index = layedit.build('aboutUs', {
      height: 200, //设置编辑器高度
      tool: [
        'strong' //加粗
        , 'italic' //斜体
        , 'underline' //下划线
        , 'del' //删除线

        , '|' //分割线

        , 'left' //左对齐
        , 'center' //居中对齐
        , 'right' //右对齐
        , 'link' //超链接
        , 'unlink' //清除链接
        , 'face' //表情
        , 'help' //帮助
      ]
    });

    //富文本编译器
    var indexs = layedit.build('ourTeam', {
      height: 200, //设置编辑器高度
      tool: [
        'strong' //加粗
        , 'italic' //斜体
        , 'underline' //下划线
        , 'del' //删除线

        , '|' //分割线

        , 'left' //左对齐
        , 'center' //居中对齐
        , 'right' //右对齐
        , 'link' //超链接
        , 'unlink' //清除链接
        , 'face' //表情
        , 'help' //帮助
      ]
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

    //自定义验证规则
    form.verify({
      content: function (value) {
        return layedit.sync(index);
      },
      contents: function (value) {
        return layedit.sync(indexs);
      },
    })


    //普通图片上传
    var uploadInst = upload.render({
      elem: '#test2'
      , method: 'POST'
      , url: '/main/addImg.action'
      , before: function (obj) {
        //预读本地文件示例，不支持ie8
        obj.preview(function (index, file, result) {
          $('#demo2').attr('src', result); //图片链接（base64）
        });
      }
      , done: function (res) {
        //如果上传失败
        if (res.code == 0) {
          uploads = res.data;
          $("#imgUrls").val(res.data);
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
        url: "/information/update.action",
        data: JSON.stringify(data.field),
        contentType: 'application/json',
        type: "POST",
        dataType: "json",
        success: function (map) {
          if (map.code == 1) {
            layer.msg(map.msg, {icon: 6})
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
