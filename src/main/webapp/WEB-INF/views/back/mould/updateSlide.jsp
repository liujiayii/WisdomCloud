<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
<!-- 内容主体区域 -->
<div class="layui-body-top">
	<span class="layui-breadcrumb">
		<a href="/amount/list.action"><cite><i class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a>
		<a href="/model/list.action">模版信息</a>
		<a href="/model/getModelById.action">模版轮播图修改</a>
	</span>
</div>
<div class="layui-body-content" id="app">
  <div class="ContP"><img src="/img/back/dataSj.png">模版轮播图修改
    <el-button style="float: right" @click="dialogFormVisible=true">新增</el-button>
  </div>
  <div>
    <el-table :data="tableData">
      <el-table-column prop="modelId" label="模块ID"></el-table-column>
      <el-table-column prop="images" label="图片">
        <template slot-scope="scope">
          <img :src="scope.row.images" alt="" width="100" height="100">
        </template>
      </el-table-column>
      <el-table-column prop="priority" label="优先级"></el-table-column>
      <el-table-column fixed="right" label="操作">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">编辑</el-button>
          <el-button @click="handleDelete(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="轮播图" :visible.sync="dialogFormVisible" :modal-append-to-body="false" @closed="()=>form={}">
      <el-form :model="form">
        <el-upload action="/main/addImg.action" :on-success="upload" :show-file-list="false">
          <el-button size="small" type="primary">点击上传</el-button>
          <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
          <img :src="form.images" alt="" width="100" height="100">
        </el-upload>
        <el-form-item label="优先级">
          <el-input v-model="form.priority" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="submit">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</div>
<jsp:include page="../Inheritance/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
  nacSelect(14);
  Vue.use(ELEMENT)
  let vm = new Vue({
    el: '#app',
    data: {
      tableData: [],
      dialogFormVisible: false,
      form: {}
    },
    methods: {
      getTable() {
        $.ajax({
          url: '/bannerImage/listBannerImageByModelId.action',
          type: 'post',
          dataType: 'json',
          data: {modelId: getHrefParam('id'), page: 1, limit: 100},
          success: (res) => {
            console.log(res)
            if (res.code === 0) {
              this.tableData = res.data.list
              console.log(res.data.list)
              console.log(this.tableData)
            }
          }
        });
      },
      upload(response, file, fileList) {
        console.log(response)
        this.form.images = response.data
      },
      handleClick(e) {
        this.dialogFormVisible = true
        this.form = JSON.parse(JSON.stringify(e))
      },
      handleDelete(e) {
        console.log(e)
        this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          $.ajax({
            url: '/bannerImage/removeBannerImage.action',
            type: 'post',
            dataType: 'json',
            data: {id: e.id},
            success: (res) => {
              console.log(res)
              if (res.code === 0) {
                this.$message({
                  type: 'success',
                  message: '删除成功!'
                });
                this.getTable()
              } else {
                this.$message(res.msg)
              }
            }
          });

        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      submit() {
        $.ajax({
          url: this.form.id ? '/bannerImage/updateBannerImage.action' : '/bannerImage/saveBannerImage.action',
          type: 'post',
          dataType: 'json',
          data: {modelId: getHrefParam('id'), ...this.form},
          success: (res) => {
            console.log(res)
            if (res.code === 0) {
              this.dialogFormVisible = false
              this.$message(res.msg)
              this.getTable()
            } else {
              this.$message(res.msg)
            }
          }
        });
      }
    },
    mounted() {
      this.getTable()
    }
  })

  layui.use(['form', 'jquery', 'element', 'layer', 'table', 'laydate', 'upload', 'layedit'], function () {
    var table = layui.table, element = layui.element, form = layui.form, jquery = layui.jquery;
    var layer = layui.layer, laydate = layui.laydate, upload = layui.upload, layedit = layui.layedit;
  })
</script>

</html>
