<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
<!-- 内容主体区域 -->
<div class="layui-body-top">
					<span class="layui-breadcrumb">
					  	<a href=""><cite><i class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a>
					  	<a href="">合作伙伴管理</a>
					</span>
</div>
<div class="layui-body-content">
  <p class="ContP"><img src="/img/back/dataSj.png">合作伙伴管理<a href="/partner/add.action" class="contp_a"><i
    class="layui-icon">&#xe608;</i>添加</a></p>
  <div class="ContDom">
    <table id="demo" lay-filter="test"></table>
  </div>
</div>
<jsp:include page="../Inheritance/footer.jsp"></jsp:include>
<script type="text/html" id="imgsTpl">
  <img src="{{d.image}}">
</script>
<script type="text/html" id="openTpl">
  {{#  if(d.url_open_type == 0){}}
  <span style="color: #29a672;">是</span>
  {{#  }else if(d.url_open_type == 1){}}
  <span style="color: #29a672;">否</span>
  {{#    }  }}
</script>
<script type="text/html" id="barDemo">
  <a class="layui-btnA" lay-event="edit"><i class="layui-icon">&#xe642;</i></a>
  {{#  if(d.status == 0){}}
  <a lay-event="detail"><img src="/img/back/la.png"></a>
  {{#  }else if(d.status == 1){}}
  <a lay-event="detail"><img src="/img/back/top.png"></a>
  {{#    }  }}
  <a class="layui-btnA" lay-event="del"><i class="layui-icon">&#xe640;</i></a>
</script>
<script type="text/javascript">
  nacSelect(7);
  var cols = [{field: "id", title: "编号", align: "center", unresize: true},
    {field: "partnerName", title: "合作伙伴名称", align: "center", unresize: true},
    {field: "image", title: "合作伙伴公司图片", align: "center", unresize: true, toolbar: "#imgsTpl"},
    {field: "url", title: "公司域名", align: "center", unresize: true},
    {
      field: "sortTime", title: "排序时间", align: "center", unresize: true, templet: function (d) {
        return formatDateTime(d.sortTime)
      }
    },
    {title: "操作", toolbar: '#barDemo', align: "center", unresize: true}
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
      url: "/partner/listAll.action",
      method: 'POST',
      page: {theme: '#73b1fe'}, //是否显示分页
      defaultToolba: ['filter', 'print'],
      parseData: function (res) { // res 即为原始返回的数据
        return {
          "code": res.code, // 解析接口状态
          "msg": res.msg, // 解析提示文本
          "count": res.count, // 解析数据长度
          "data": res.listPartner
          // 解析数据列表
        };
      },
      response: {statusCode: 1},//规定成功的状态码，默认：0
      even: true,
      limit: 15, //每页默认显示的数量
      limits: [15, 30, 45],
      loading: false,//请求数据时，是否显示loading
      done: function (res, curr, count) {
        $('thead tr').css({'background-color': '#73b1fe', 'color': '#fff'});
      }
    });
    table.on('tool(test)', function (obj) {
      var data = obj.data;
      if (obj.event === 'del') {
        layer.confirm('真的删除吗', function (index) {
          obj.del();
          $.post('/partner/delete.action', {'partnerId': data.id}, function () {
          }, 'json');
          closeDialog();
        })
      } else if (obj.event === 'edit') {
        window.location.href = "/partner/create.action?id=" + data.id;
      }
    });

  })

  function closeDialog() {
    window.parent.location.reload();
    parent.layer.close();
  }
</script>
</body>
</html>
