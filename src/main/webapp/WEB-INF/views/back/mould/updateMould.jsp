<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
<!-- 内容主体区域 -->
<div class="layui-body-top">
	<span class="layui-breadcrumb">
		<a href="/amount/list.action"><cite><i class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a>
		<a href="/model/list.action">模版信息</a>
		<a href="/model/getModelById.action">模版信息修改</a>
	</span>
</div>
<div class="layui-body-content">
  <p class="ContP"><img src="/img/back/dataSj.png">模版信息修改</p>
  <div class="ContDom ContForm">
    <div class="formDemo">
      <form action="" method="post" class="layui-form addForm" lay-filter="formTest">
        <input type="hidden" value="${model.id }" name="id">
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">模版名称</label>
            <div class="layui-input-inline">
              <input type="text" value="${model.modelName }" name="modelName" class="layui-input"
                     lay-verify="required"/>
            </div>
            <div class="layui-form-mid layui-word-aux">请输入模版名称</div>
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">模版价格</label>
            <div class="layui-input-inline">
              <input type="text" value="${model.modelPrice }" name="modelPrice" class="layui-input"
                     lay-verify="required"/>
            </div>
            <div class="layui-form-mid layui-word-aux">请输入模版价格</div>
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">色系名称</label>
            <div class="layui-input-inline">
              <select name="colorId" id="colorId" lay-verify="required">
                <c:forEach items="${allColor}" var="color">
                  <option value="${color.id}">${color.colorName}</option>
                </c:forEach>
              </select>
            </div>
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">行业名称</label>
            <div class="layui-input-inline">
              <select name="tradeId" id="tradeId" lay-verify="required">
                <c:forEach items="${allTrade}" var="trade">
                  <option value="${trade.id}">${trade.tradeName}</option>
                </c:forEach>
              </select>
            </div>
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">分类名称</label>
            <div class="layui-input-inline">
              <select name="typeId" id="typeId" lay-verify="required">
                <c:forEach items="${allType}" var="type">
                  <option value="${type.id}">${type.typeName}</option>
                </c:forEach>
              </select>
            </div>
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">版本</label>
            <div class="layui-input-inline">
              <input type="text" value="${model.version }" name="version" class="layui-input" lay-verify="required"/>
            </div>
            <div class="layui-form-mid layui-word-aux">请输入模版版本</div>
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">展示图片</label>
            <input type="hidden" value="${model.image }" name="image" id="imgUrl"/>
            <div class="layui-upload-list">
              <img class="layui-upload-img" id="demo1" src="" alt="选择图片" title="图片"
                   onerror="this.src='/img/back/delete.png'">
              <p id="demoText"></p>
            </div>
            <div class="layui-input-block imageArea">
              <p id="test1">本地上传</p>
              <p>400*300,jpg/png,大小不超过2M</p>
            </div>
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-inline">
              <select name="state" class="layui-select" lay-verify="required" lay-search>
                <option value="0">上架</option>
                <option value="1">下架</option>
              </select>
            </div>
          </div>
        </div>
        <div class="layui-form-item ">
          <div class="layui-inline  form-submit">
            <input type="button" name="" class="layui-btn buts" lay-submit value="保存" lay-filter="add-member-submit"/>
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
  nacSelect(14);
  $(function () {
    // 详情页面加载执行
    layui.use(['form', 'jquery', 'element', 'layer', 'table', 'laydate', 'upload'], function () {
      var table = layui.table, element = layui.element, form = layui.form, jquery = layui.jquery;
      var layer = layui.layer, laydate = layui.laydate, upload = layui.upload;
      $.ajax({
        url: '/model/getModelById.action',
        type: 'post',
        dataType: 'json',
        data: {id: getHrefParam(name)},
        success: function (result) {
          console.log(result)
          if (result.code == 0) {
            $("#demo1").attr("src", result.data.image);
            $("#imgUrl").val(result.data.image)
            // 表单初始赋值
            form.val('formTest', result.data)
            form.render()
          }
        }
      });
    })
  })

  layui.use(['form', 'jquery', 'element', 'layer', 'table', 'laydate', 'upload', 'layedit'], function () {
    var table = layui.table, element = layui.element, form = layui.form, jquery = layui.jquery;
    var layer = layui.layer, laydate = layui.laydate, upload = layui.upload, layedit = layui.layedit;
    //自定义验证规则
    form.verify({
      content: function (value) {
        return layedit.sync(index);
      }
    })

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
      console.log(data.field)
      $.ajax({
        url: "/model/updateModel.action",
        data: JSON.stringify(data.field),
        contentType: 'application/json',
        type: "POST",
        dataType: "json",
        success: function (map) {
          if (map.code == 0) {
            window.location.href = "/model/list.action";
          } else {
            layer.msg(map.msg, {icon: 5})
          }
        },
        error: function (map) {
          window.wxc.xcConfirm("抱歉！出了一点小问题", window.wxc.xcConfirm.typeEnum.error);
        }
      });
    })
  })
</script>

</html>
