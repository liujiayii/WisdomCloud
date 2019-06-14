<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
<!-- 内容主体区域 -->
<div class="layui-body-top">
					<span class="layui-breadcrumb">
					  	<a href=""><cite><i class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a>
					  	<a href="">招聘信息</a>
					  	<a href="">招聘添加</a>
					</span>
</div>
<div class="layui-body-content">
  <p class="ContP"><img src="/img/back/dataSj.png">招聘添加</p>
  <div class="ContDom ContForm">
    <form action="" method="post" class="layui-form addForm">
      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">招聘岗位</label>
          <div class="layui-input-inline">
            <input type="text" value="" name="job" class="layui-input" lay-verify="required"/>
          </div>
          <div class="layui-form-mid layui-word-aux">1-20个字符</div>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">招聘人数</label>
          <div class="layui-input-inline">
            <input type="text" value="" name="wantNumber" class="layui-input" lay-verify="required"/>
          </div>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">学历要求</label>
          <div class="layui-input-inline">
            <input type="text" value="" name="education" class="layui-input" lay-verify="required"/>
          </div>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">专业要求</label>
          <div class="layui-input-inline">
            <input type="text" value="" name="major" class="layui-input" lay-verify="required"/>
          </div>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">工作地点</label>
          <div class="layui-input-inline">
            <input type="text" value="" name="workplace" class="layui-input" lay-verify="required"/>
          </div>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">工作详情</label>
          <div class="layui-input-inline" style="width: 1000px">
            <textarea class="layui-textarea" id="remark" style="display: none;" name="remark"
                      lay-verify="content"></textarea>
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
          <input type="button" name="" onclick="javascript:history.back(-1);" class="layui-btn buts resets" value="取消"/>
        </div>
      </div>
    </form>
  </div>
</div>
<jsp:include page="../Inheritance/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
  nacSelect(8);
  layui.use(['form', 'jquery', 'element', 'layer', 'table', 'laydate', 'upload', 'layedit'], function () {
    var table = layui.table, element = layui.element, form = layui.form, jquery = layui.jquery;
    var layer = layui.layer, laydate = layui.laydate, upload = layui.upload, layedit = layui.layedit;

    //富文本编译器
    var index = layedit.build('remark', {
      height: 125, //设置编辑器高度
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

    //自定义验证规则
    form.verify({
      content: function (value) {
        return layedit.sync(index);
      }
    })

    form.on('submit(add-member-submit)', function (data) {
      delete data.field.file;
      $.ajax({
        url: "/wanted/saveWanted.action",
        data: JSON.stringify(data.field),
        contentType: 'application/json',
        type: "POST",
        dataType: "json",
        success: function (map) {
          if (map.code == 0) {
            window.location.href = "/wanted/list.action";
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
