<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
  <link rel="icon" href="${s2001}" type="img/x-ico"/>
  <title>${s101}</title>
  <meta content="${s1037}" name="Keywords">
  <meta name="description" content="${s1038}">
  <link rel="stylesheet" href="../../../css/style.css"/>
  <link rel="stylesheet" type="text/css" href="../../../css/currency.css"/>
  <link rel="stylesheet" type="text/css" href="../../../js/layui/css/layui.css"/>
  <link rel="stylesheet" href="../../../css/index.css"/>
  <link rel="stylesheet" href="../../../dist/css/swiper.min.css">
  <script type="text/javascript" src="../../../js/jquery1.11.3-jquery.min.js"></script>
  <script type="text/javascript" src="../../../js/inheritance.js"></script>
  <script type="text/javascript" src="../../../js/layui/layui.js"></script>
  <script src="../../../dist/js/swiper.min.js"></script>
  <script src="//cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
  <script src="//cdn.jsdelivr.net/npm/element-ui@2/lib/index.min.js"></script>
  <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/element-ui@2/lib/theme-chalk/index.min.css">
  <style>
    .search {
      width: 100%;
      overflow: hidden;
      padding-bottom: 40px;
      position: relative;
      z-index: 99;
      margin-top: 90px;
    }

    .search-bar {
      width: 508px;
      height: 34px;
      border-radius: 34px;
      border: 1px solid #dee6fe;
      margin: 15px auto;
      overflow: hidden;
    }

    .search-bar > input {
      width: 400px;
      height: 100%;
      border: none;
      padding-left: 20px;
      outline: none;
      float: left;
    }

    .search-bar > button, .searchfind button {
      border: none;
      font-size: 18px;
      color: #f60;
      font-weight: bold;
      background-color: transparent;
      float: right;
      margin-right: 12px;
      height: 100%;
      cursor: pointer;
      outline: none;
    }

    .searchfind button {
      float: none;
    }

    .searchfind input {
      width: 100px;
      height: 36px;
      border-radius: 34px;
      border: 1px solid #dee6fe;
      outline: none;
      padding: 0 10px;
    }

    .searchfind {
      border-top: #d2d9f2 solid 1px;
      text-align: center;
      font-size: 14px;
      color: #59689f;
      line-height: 36px;
      padding: 20px 0;
    }

    .searchfind span.list {
      display: inline-block;
      height: 36px;
      vertical-align: top;
    }

    .searchfind-box,
    .color-box {
      display: inline-block;
      width: 85%;
      text-align: left;
      vertical-align: top;
    }

    .searchfind-box a.active,
    .color-box a.all.active {
      background: #f60;
      color: #fff;
    }

    .searchfind-box a,
    .color-box a.all {
      display: inline-block;
      margin: 0 10px;
      border: none;
      outline: none;
      cursor: pointer;
      padding: 0 2px;
      color: #7f8bb2;
      height: 24px;
      line-height: 24px;
      font-size: 14px;
      min-width: 36px;
      text-align: center;
    }

    .color-box a {
      font-size: 0;
      margin-left: 20px;
      display: inline-block;
      width: 28px;
      height: 10px;
      margin-top: 5px;
      vertical-align: middle;
      cursor: pointer;
      position: relative;
    }

    .color-box a:first-child:before {
      display: none;
    }

    .color-box a.active:before {
      border-color: #f60;
    }

    .color-box a:before {
      content: "";
      border: #cbcbcb solid 1px;
      width: 36px;
      height: 18px;
      top: -4.5px;
      left: -4px;
      display: block;
      position: absolute;
    }

    .searchfind-line {
      border-bottom: #d2d9f2 solid 1px;
    }

    .li-box {
      min-height: 300px;
      position: relative;
    }

    .no-record {
      position: absolute;
      width: 100%;
      text-align: center;
      color: #333;
      font-size: 20px;
      top: 50%;
      margin-top: -40px;
    }

    .list-box {
      overflow: hidden;
      text-align: center;
    }

    .list-box.site li {
      margin: 3% 1%;
      height: auto;
      width: 30%;
      background: none;
      min-width: 330px;
    }

    .list-box li {
      margin: 45px 20px;
      display: inline-block;
      width: 266px;
      height: 488px;
      background-size: 100% 100%;
      position: relative;
      cursor: pointer;
      -webkit-animation: slideUp 1s;
      -o-animation: slideUp 1s;
      animation: slideUp 1s;
      vertical-align: top;
    }

    .site .it-pic {
      width: 450px;
      width: 100%;
      height: 291px;
      height: auto;
      background: url(../img/font/site_bg.png) no-repeat;
      background-size: 100% 100%;
      padding-top: 15px;
      padding: 3.3% 0 11.5%;
    }

    .it-pic .it-img {
      width: 345px;
      width: 76%;
      height: 222px;
      height: auto;
      display: block;
      overflow: hidden;
      margin: 0 auto;
      position: relative;
    }

    .it-pic .it-img > img {
      width: 100%;
      height: 100%;
      height: auto;
    }

    .site .item-cn {
      top: 225px;
    }

    .item-cn {
      width: 100%;
      height: 100%;
      position: absolute;
      top: 340px;
      background-color: rgba(0, 0, 0, .8);
      -webkit-transition: top .3s ease-in-out;
      -moz-transition: top .3s ease-in-out;
      -ms-transition: top .3s ease-in-out;
      -o-transition: top .3s ease-in-out;
      transition: top .3s ease-in-out;
    }

    .tbn {
      overflow: hidden;
      width: 100%;
      position: absolute;
      bottom: 20px;
      /*  padding: 0 20px; */
    }

    .tbn > a {
      width: 130px;
      height: 35px;
      line-height: 35px;
      border-radius: 15px;
      color: #fff;
      cursor: pointer;
      border: none;
      font-size: 18px;
    }

    .lbtn {
      background-color: #03ae5b;
      margin: 0 auto;
      display: block;
    }

    .rbtn {
      float: right;
      background-color: #ff5a00;
      display: none;
    }

    .list-box li:hover .item-cn {
      top: 0;
    }

    .site .it-info {
      white-space: nowrap;
      width: 100%;
      padding: 0 50px;
      padding: 0 10% 0 7%;
      overflow: hidden;
    }

    .site .it-info .list {
      line-height: 26px;
    }

    .site .it-info > span {
      color: #919191;
      font-size: 14px;
      float: left;
      margin-left: 15px;
    }

    .site .it-info > em {
      color: #ff592d;
      font-style: normal;
      font-size: 14px;
      float: right;
    }

    .page {
      display: flex;
      justify-content: center;
    }
  </style>
</head>
<body>
<div>
  <div class="navs navas">
    <div class="nav-content">
      <img src="${s2002}" class="logoimg"/>
      <ul class="nav-list">
        <a href="/main/index.action">
          <li>首页</li>
        </a>
        <a href="/main/about.action">
          <li>关于</li>
        </a>
        <a href="/case/case.action">
          <li>案例</li>
        </a>
        <a href="/main/model.action">
          <li class="liSelected">模版</li>
        </a>
        <a href="/main/advantage.action">
          <li>优势</li>
        </a>
        <a href="/main/team.action">
          <li>团队</li>
        </a>
        <a href="/main/employeePage.action">
          <li>招聘</li>
        </a>
        <a href="/main/contactUs.action">
          <li>联系我们</li>
        </a>
      </ul>
    </div>
  </div>
</div>
<div id="app" style="margin: 150px 0 100px">
  <div class="search">
    <div class="search-bar">
      <input type="text" placeholder="输入关键词进行搜索" v-model="search.modelName">
      <button @click="getAllMould()">搜 索</button>
    </div>
    <div class="searchfind">
      <span class="list">分类：</span>
      <div class="searchfind-box hy">
        <a href="javascript:;" :class="search.typeId===''?'active':'tipbtn'" @click="goSearch('typeId','')">全部</a>
        <template v-for="item of type">
          <em>|</em>
          <a href="javascript:;" :class="search.typeId===item.id?'active':'tipbtn'" @click="goSearch('typeId',item.id)">{{item.typeName}}</a>
        </template>
      </div>
    </div>
    <div class="searchfind">
      <span class="list">行业：</span>
      <div class="searchfind-box hy">
        <a href="javascript:;" :class="search.tradeId===''?'active':'tipbtn'" @click="goSearch('tradeId','')">全部</a>
        <template v-for="item of trade">
          <em>|</em>
          <a href="javascript:;" :class="search.tradeId===item.id?'active':'tipbtn'"
             @click="goSearch('tradeId',item.id)">{{item.tradeName}}</a>
        </template>
      </div>
    </div>
    <div class="searchfind">
      <span class="list">颜色：</span>
      <div class="color-box cl">
        <a href="javascript:;" class="all" :class="search.colorId===''?'active':''"
           @click="goSearch('colorId','')">全部</a>
        <a v-for="item of color" href="javascript:;" :style="{backgroundColor:item.remark}"
           :class="search.colorId===item.id?'active':''"
           @click="goSearch('colorId',item.id)">{{item.colorName}}</a>
      </div>
    </div>
    <div class="searchfind searchfind-line">
      <span class="list">价格：</span>
      <div class="searchfind-box pc">
        <a href="javascript:;" @click="clearPrice"
           :class="(search.modelLowPrice===''&&search.modelHighPrice==='') ?'active':''">全部</a>
        <em>|</em>
        <em>价格区间:</em>
        <input type="text" placeholder="最低价格" v-model="search.modelLowPrice">
        <em>-</em>
        <input type="text" placeholder="最高价格" v-model="search.modelHighPrice">
        <button @click="getAllMould()">搜 索</button>
      </div>
    </div>
  </div>
  <div class="li-box">
    <div class="no-record" v-if="mould.length===0"> =.= 抱歉，您的搜索暂无数据</div>
    <template v-else>
      <ul class="list-box site">
        <li v-for="item of mould" :key="item.id">
          <div class="it-pic">
            <div class="it-img">
              <img :src="item.image" :alt="item.modelName">
              <div class="item-cn">
                <div class="tbn">
                  <a href="javascript:;" class="lbtn" @click="watch(item.id)">查看实例</a>
                  <a href="javascript:;" class="rbtn">查看详情</a></div>
              </div>
            </div>
          </div>
          <div class="it-info">
            <div class="list">{{item.modelName}}</div>
            <span>编号：<b>{{item.modelNum}}</b></span><span>版本：<b>{{item.version}}</b></span><em>{{item.modelPrice}}元</em>
          </div>
        </li>
      </ul>
      <div class="page">
        <el-pagination background layout="prev, pager, next,jumper,sizes,total" :total="pagination.total"
                       @current-change="changePage" @size-change="sizeChange"></el-pagination>
      </div>
    </template>
    <el-dialog :visible.sync="dialogVisible">
      <div class="no-record" v-if="slide.length===0"> =.= 抱歉，暂无数据</div>
      <el-carousel height="300px" v-else>
        <el-carousel-item v-for="item of slide" :key="item.id">
          <img :src="item.images" alt="" style="width: 100%">
        </el-carousel-item>
      </el-carousel>
    </el-dialog>
  </div>
</div>
<div class="address-footer">
  <img src="../../../img/font/tel.jpg"/>${information.companyPhone }
  <img src="../../../img/font/address.png"/>${information.companyAddress}
</div>
<jsp:include page="../nav/footer.jsp"></jsp:include>
<script type="text/javascript">
  Vue.use(ELEMENT)
  let vm = new Vue({
    el: '#app',
    data: {
      color: [],
      trade: [],
      type: [],
      mould: [],
      search: {
        colorId: '',
        tradeId: '',
        typeId: '',
        modelLowPrice: '',
        modelHighPrice: '',
        modelName: ''
      },
      pagination: {
        total: 0,
        page: 1,
        limit: 10,
        state: 0
      },
      dialogVisible: false,
      slide: []
    },
    methods: {
      getColor() {
        $.ajax({
          url: "/color/showAllColor.action",
          type: "POST",
          dataType: "json",
          success: (res) => {
            console.log(res)
            if (res.code === 0) {
              this.color = res.data
            }
          }
        });
      },
      getTrade() {
        $.ajax({
          url: "/trade/showAllTrade.action",
          type: "POST",
          dataType: "json",
          success: (res) => {
            console.log(res)
            if (res.code === 0) {
              this.trade = res.data
            }
          }
        });
      },
      getType() {
        $.ajax({
          url: "/type/showAllType.action",
          type: "POST",
          contentType: 'application/json',
          dataType: "json",
          success: (res) => {
            console.log(res)
            if (res.code === 0) {
              this.type = res.data
            }
          }
        });
      },
      getAllMould() {
        $.ajax({
          url: "/model/listModelByOption.action",
          type: "POST",
          data: {...this.pagination, ...this.search},
          dataType: "json",
          success: (res) => {
            console.log(res)
            if (res.code === 0) {
              this.mould = res.data.list
              this.pagination.total = res.data.count
            }
          }
        });
      },
      clearPrice() {
        this.search.modelLowPrice = ''
        this.search.modelHighPrice = ''
      },
      goSearch(type, key) {
        this.search[type] = key
        this.getAllMould()
      },
      changePage(page) {
        this.pagination.page = page
        this.getAllMould()
      },
      sizeChange(limit) {
        this.pagination.limit = limit
        this.getAllMould()
      },
      watch(modelId) {
        $.ajax({
          url: "/bannerImage/listBannerImageByModelId.action",
          type: "POST",
          data: {modelId},
          dataType: "json",
          success: (res) => {
            console.log(res)
            if (res.code === 0) {
              this.slide = res.data.list
              this.dialogVisible = true
            }
          }
        });
      }
    },
    mounted() {
      this.getColor()
      this.getTrade()
      this.getType()
      this.getAllMould()
    }
  })
</script>
</body>
</html>
