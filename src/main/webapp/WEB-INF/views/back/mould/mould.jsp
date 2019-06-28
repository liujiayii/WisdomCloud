<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
<!-- 内容主体区域 -->
<div class="layui-body-top">
	<span class="layui-breadcrumb"> <a href="/amount/list.action"><cite><i
    class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a>
				<a href="/model/list.action">模版信息</a>
	</span>
</div>
<style>
  .search input {
    border: 1px solid #dee6fe;
    outline: none;
    background: none;
    height: 30px;
    border-radius: 18px;
    padding: 0 8px;
    margin-right: 6px;
  }
</style>
<div class="layui-body-content">
  <p class="ContP">
    <img src="/img/back/dataSj.png">模版信息<a href="/model/add.action" class="contp_a"><i class="layui-icon">&#xe608;</i>添加</a>
  </p>
  <div class="ContDom">
    <div class="search">
      <input type="text" id="modelName" placeholder="输入模版名称进行搜索">
      <form class="layui-form" action="" style="display: inline-block;height: 20px">
        <div class="layui-form-item">
          <div class="layui-input-inline">
            <select name="city" id="type">
              <option value="">请选择</option>
            </select>
          </div>
        </div>
      </form>
      <button id="search" class="layui-btn layui-btn-normal layui-btn-sm">搜索</button>
    </div>
    <table id="demo" lay-filter="test"></table>
  </div>
</div>
<jsp:include page="../Inheritance/footer.jsp"></jsp:include>
<script type="text/html" id="barDemo">
  <a class="layui-btnA" lay-event="edit"><i class="layui-icon">&#xe642;</i></a>
  <a class="layui-btnA" lay-event="slide" style="margin: 0 6px"><i class="layui-icon">&#xe64a;</i></a>
  {{#  if(d.state == 0){}}
  <a lay-event="detail"><img src="/img/back/la.png" title="下架"></a>
  {{#  }else if(d.state == 1){}}
  <a lay-event="detail"><img src="/img/back/top.png" title="上架"></a>
  {{#    }  }}
</script>
<script type="text/html" id="imgTpl">
  <img src="{{d.image}}">
</script>
<script type="text/html" id="stateName">
  {{# if(d.state == 0){}}
  <span style="color: #29a672;">上架中</span>
  {{# }else if(d.state == 1){}}
  <span style="color: #ccc;">下架中</span>
  {{#     }  }}
</script>
<script type="text/javascript">
  nacSelect(14);
  var cols = [{field: "id", title: "编号", align: "center", unresize: true, sort: true},
    {field: "modelNum", title: "模版编号", align: "center", unresize: true},
    {field: "modelName", title: "模版名称", align: "center", unresize: true},
    {field: "modelPrice", title: "模版价格", align: "center", unresize: true, sort: true},
    {field: "colorId", title: "色系id", align: "center", unresize: true, hide: true},
    {field: "colorName", title: "色系名称", align: "center", unresize: true},
    {field: "tradeId", title: "行业id", align: "center", unresize: true, hide: true},
    {field: "tradeName", title: "行业名称", align: "center", unresize: true},
    {field: "typeId", title: "分类id", align: "center", unresize: true, hide: true},
    {field: "typeName", title: "分类名称", align: "center", unresize: true},
    {field: "version", title: "版本", align: "center", unresize: true, sort: true},
    {field: "image", title: "展示图片", align: "center", unresize: true, toolbar: "#imgTpl"},
    {field: "state", title: "状态", align: "center", unresize: true, toolbar: "#stateName"},
    {title: "操作", toolbar: '#barDemo', align: "center", unresize: true}
  ]
  layui.use(['form', 'jquery', 'element', 'layer', 'table'], function () {
    var table = layui.table, element = layui.element, form = layui.form, jquery = layui.jquery;
    var layer = layui.layer;
    $.ajax({
      url: '/type/showAllType.action',
      data: {page: 1, limit: 100},
      type: "POST",
      dataType: "json",
      success: (res) => {
        if (res.code === 0) {
          for (let i = 0; i < res.data.length; i++) {
            $('#type').append('<option value="' + res.data[i].id + '">' + res.data[i].typeName + '</option>')
          }
          form.render()
        }
      },
    })
    /*数据表格*/
    table.render({
      elem: '#demo',
      cols: [
        cols
      ],
      enabledCurrCookie: true,//开启table页码缓存，意思是开启刷新页面保留在当前页面
      id: 'testArea',
      skin: 'line',
      method: 'POST',
      url: "/model/listModel.action",
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
      page: {
    	    groups: 10 //只显示 1 个连续页码
    	    ,layout: ['prev', 'page', 'next', 'count', 'skip'] //自定义分页布局
    	    ,theme: '#1E9FFF'
    	   
    	},
    	done: function (res, curr, count) {
        	console.log(res);
        	localStorage.setItem("data-page",curr);  //本地储存
        	$('thead tr').css({'background-color': '#73b1fe', 'color': '#fff'});
      }
    });
    
    table.reload('#demo', {
        page: {
          curr: localStorage.getItem("data-page") //重新从第 n 页开始
        }
    });
    
       
    /*搜索*/
    $('#search').click(function () {
      table.reload('testArea', {
        url: '/model/listModelByOption.action'
        , where: {modelName: $('#modelName').val(), typeId: $('#type').val()}
      })
    })
    table.on('tool(test)', function (obj) {
      var data = obj.data;
      if (obj.event === 'edit') {
        window.location.href = "/model/TZupdateModel.action?id=" + data.id;
      } else if (obj.event === 'detail') {
        var state = data.state;
        if (state == 0) {
          layer.confirm('确定要下架吗？', function (index) {
            $.ajax({
              url: '/model/removeModel.action',
              contentType: 'application/json;charset=utf-8',
              data: JSON.stringify({'id': data.id, 'state': 1}),
              type: "POST",
              dataType: "json",
              success: function (map) {
                if (map.code == 0) {
                  window.location.reload()
                }
              },
              error: function (result) {
                window.wxc.xcConfirm("抱歉！出了一点小问题", window.wxc.xcConfirm.typeEnum.error);
              }
            })
          })
        } else if (state == 1) {
          layer.confirm('确定要上架吗？', function (index) {
            $.ajax({
              url: '/model/removeModel.action',
              contentType: 'application/json;charset=utf-8',
              data: JSON.stringify({'id': data.id, 'state': 0}),
              type: "POST",
              dataType: "json",
              success: function (map) {
                if (map.code == 0) {
                  window.location.reload()
                }
              },
              error: function (result) {
                window.wxc.xcConfirm("抱歉！出了一点小问题", window.wxc.xcConfirm.typeEnum.error);
              }
            })
          })
        }
      } else if (obj.event === 'slide') {
        window.location.href = "/model/TZbannerImg.action?id=" + data.id;
      }
    });
  })

  function closeDialog() {
    window.parent.location.reload();
    parent.layer.close();
  }
 
</script>
<script type="text/javascript">

</script>
</body>
</html>
