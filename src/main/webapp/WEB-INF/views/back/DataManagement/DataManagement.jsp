<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
<!-- 内容主体区域 -->
<div class="layui-body-top">
					<span class="layui-breadcrumb">
					  	<a href=""><cite><i class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a>
					  	<a href="">数据管理</a>
					</span>
</div>
<div class="layui-body-content">
  <p class="ContP"><img src="/img/back/dataSj.png">数据管理</p>
  <div class="ContDom">
    <table id="demo" lay-filter="test"></table>
  </div>
</div>
<jsp:include page="../Inheritance/footer.jsp"></jsp:include>
<script type="text/html" id="barDemo">
  {{#  if(d.status == 0){}}
  <a lay-event="detail" title="未查看"><img style="width:25px" src="/img/back/see.png"></a>
  {{#  }else if(d.status == 1){}}
  <a lay-event="detail" title="已查看"><img style="width:25px" src="/img/back/nosee.png"></a>
  {{#    }  }}
</script>
<script type="text/javascript">
  nacSelect(6);
  var cols = [{field: "id", title: "id", hide: true},
    {field: "name", title: "姓名", align: "center", unresize: true},
    {field: "phone", title: "联系方式", align: "center", unresize: true},
    {field: "type", title: "项目类型", align: "center", unresize: true},
    {field: "introduction", title: "项目简介", align: "center", unresize: true},
    {field: "status", title: "是否查看", align: "center", unresize: true, hide: true},
    {
      field: "time", title: "时间", align: "center", unresize: true, templet: function (d) {
        return formatDateTime(d.time)
      }
    },
    {field: "remark", title: "备注", align: "center", unresize: true},
    {title: "操作", align: "center", unresize: true, toolbar: '#barDemo'},
  ]
  layui.use(['form', 'jquery', 'element', 'layer', 'table'], function () {
    var table = layui.table, element = layui.element, form = layui.form, jquery = layui.jquery;
    var layer = layui.layer;


    /*数据表格*/
    table.render({
      elem: '#demo',
      cols: [
        cols
      ],
      id: 'testArea',
      skin: 'line',
      method: 'POST',
      url: "/message/listAll.action",
      page: {theme: '#73b1fe'}, //是否显示分页
      even: true,
      parseData: function (res) { // res 即为原始返回的数据
        return {
          "code": res.code, // 解析接口状态
          "msg": res.msg, // 解析提示文本
          "count": res.data.count, // 解析数据长度
          "data": res.data.list
          // 解析数据列表
        };
      },
      limit: 15, //每页默认显示的数量
      limits: [15, 30, 45],
      done: function (res, curr, count) {
        console.log(res);
        $('thead tr').css({'background-color': '#73b1fe', 'color': '#fff'});
      }

    });

    table.on('tool(test)', function (obj) {
      var data = obj.data;
      if (obj.event === 'detail') {
        var status = data.status;
        if (status == 0) {
          layer.confirm('确定要查看吗？', function (index) {
            $.ajax({
              url: '/message/update.action',
              contentType: 'application/json;charset=utf-8',
              data: JSON.stringify({'id': data.id, 'status': 1}),
              type: "POST",
              dataType: "json",
              success: function (map) {
                if (map.code == 0) {
                  window.location.reload();
                }
              },
              error: function (result) {
                window.wxc.xcConfirm("抱歉！出了一点小问题", window.wxc.xcConfirm.typeEnum.error);
              }
            })
          })
        }
      }

    });


  })


</script>
</body>
</html>
