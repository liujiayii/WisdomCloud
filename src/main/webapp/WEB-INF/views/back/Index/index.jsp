<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.layui-layout-admin .layui-body{
		bottom:10px !important;
	}
	.admin-logo-box img{
		margin-top: 10px !important;
	}
	.top-nav{margin-top: 8px !important}
</style>
<jsp:include page="../Inheritance/nav.jsp"></jsp:include>
		    	<!-- 内容主体区域 -->
		    	<div class="layui-body-top">
					<span class="layui-breadcrumb">
					  	<a href=""><cite><i class="layui-icon" style="margin-right: 5px;">&#xe68e;</i>智莱云</cite></a>
					  	<a href="">首页</a>
					</span>
		    	</div>
		    	<div class="layui-body-content" style="border: none;">
		    		<div class="contTop">
		    			<div class="checkNumber">
		    				<p><span id="spans"></span>次</p>
		    				<p><a>查看次数</a></p>
		    				<img src="/img/back/blue.png" class="Imsgs">
		    			</div>
		    			<div class="checkNumber">
		    				<p><span id="spanes"></span>次</p>
		    				<p><a>留言数量</a></p>
		    				<img src="/img/back/blue.png" class="Imsgs">
		    			</div>
		    			<div class="checkNumber">
		    				<p><span id="spanNums"></span>%</p>
		    				<p><a>转化率</a></p>
		    				<img src="/img/back/blue.png" class="Imsgs">
		    			</div>
		    		</div>
		    		<div class="echartsArea">
		    			<p class="echartsP"><a href="javascript:;" class="echartsA echartsSelect" onclick="clickEcharts($(this))" title="1">当日</a><a class="echartsA" href="javascript:;" onclick="clickEcharts($(this))" title="2">近7天</a><a class="echartsA" href="javascript:;" onclick="clickEcharts($(this))" title="3">近30天</a></p>
		    			<div class="echartsCate" id="mains">
		    			</div>
		    			<div class="echartsItem" id="maines">
		    			</div>
		    		</div>
		    		<!-- <div class="tabArea">
		    			<p class="contDom-p"><a>用户留言</a><a>留言排序</a></p>
		    			<table id="demos"  lay-filter="test"></table>
		    		</div> -->
		      </div> 
<jsp:include page="../Inheritance/footer.jsp"></jsp:include>
<script type="text/html" id="statusDemo">
		    {{#	if(d.status == 0){}}
				<a lay-event="detail" ><img style="width:25px" src="/img/back/see.png"></a>
		    {{#	}else if(d.status == 1){}}
				<a lay-event="detail" ><img style="width:25px" src="/img/back/nosee.png"></a>
		    {{#		}  }}
</script>
<script type="text/javascript">
layui.use([ 'form','jquery','element','layer','table'], function(){
    var table = layui.table,element = layui.element,form = layui.form,jquery = layui.jquery;
    var layer = layui.layer;
})
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('mains'));

	option = {
		title: {
        	text: '网页浏览统计'
    	},
    	legend : {
            data : [ "浏览量" ]
        //图例
        },
	    xAxis: {
	        type: 'category',
	        data: []
	    },
	    yAxis: {
	        type: 'value',
	        name : '数量',
	        axisLabel : {
                formatter : '{value} 个' //Y轴单位
            }
	    },
	    series: [{
	        data: [],
	        type: 'line',
	        smooth: true,
	        symbol: 'emptycircle',     //设定为实心点
            symbolSize: 10,   //设定实心点的大小
            itemStyle : { 
				normal : {
					color:'#59a3ff', //改变折线点的颜色
					lineStyle:{
						color:'#5962ff'} , //改变折线颜色
					label : {
                        show : true,
                        textStyle : {
                            color : '#00CD66'
                        },
                        position : 'botton',
                        //formatter : '\n{b}\n{c}（个）'
                    }
				} 
			},
	    }]
	};
	// 使用刚指定的配置项和数据显示图表。
  	myChart.setOption(option);

	var type =1;
	getDate(type);
	function clickEcharts($this){
		$this.addClass("echartsSelect");
		$this.siblings(".echartsA").removeClass("echartsSelect");
		var type = $this[0].title;
		getDate(type);
	}
	function getDate(type){
		 var option = myChart.getOption();           
         $.ajax({
             type : "post",
             async : false, //同步执行  
             url : "/amount/listAllByData.action",
             data : {
            	 dateType : type,
                 },
             dataType : "json", //返回数据形式为json  
             success : function(result) {
            	 console.log(result);	
                 if (result) {
                     option.xAxis[0].data = result.data.time;
                     option.series[0].data = result.data.data;
                     myChart.hideLoading();
                     myChart.setOption(option);
                     myChart.hideLoading();
                 }
             },
             error : function(errorMsg) {
                 alert("图表请求数据失败!");
                 //myChart.hideLoading();
                 myChart.showLoading();
             }
         });
	}
	$(function(){
		nacSelect(0);
		/* 浏览留言转化率 */
		$.ajax({
  			url:"/amount/total.action",
  			type:"POST",
  			dataType:"json",
  			async : false, //同步执行
  			success:function(result){
  				if(result){
  					 $("#spanes").text(result.data.message_total);
                     $("#spans").text(result.data.visit_total);
                     $("#spanNums").text(result.data.percent);
  				}
  			},
  			error: function(result) {
              	window.wxc.xcConfirm("抱歉！出了一点小问题", window.wxc.xcConfirm.typeEnum.error);
              }
  		});
		
		
		// 基于准备好的dom，初始化echarts实例
	    var myCharts = echarts.init(document.getElementById('maines'));
	    option2 = {
			    tooltip: {
			        trigger: 'item',
			        formatter: "{a} <br/>{b}: {c} ({d}%)"
			    },
			    legend: {
			        orient: 'vertical',
			        x: 'left',
			        data:['总浏览','已留言']
			    },
			    series: [
			        {
			            name:'访问来源',
			            type:'pie',
			            radius: ['50%', '70%'],
			            avoidLabelOverlap: false,
			            label: {
			                normal: {
			                    show: false,
			                    position: 'center'
			                },
			                emphasis: {
			                    show: true,
			                    textStyle: {
			                        fontSize: '30',
			                        fontWeight: 'bold'
			                    }
			                }
			            },
			            labelLine: {
			                normal: {
			                    show: false
			                }
			            },
			            
			            data:/*[{name:"已留言",value:55},{name:"总浏览",value:66}] dateType listAllByData.action*/
			            	(function(){
		                	  var arr=[];
		                	  $.ajax({
		              			url:"/amount/statistics.action",
		              			type:"POST",
		              			dataType:"json",
		              			async : false, //同步执行
		              			success:function(result){
		              				console.log(result);
		              				if(result){
		              					for(var i=0;i<result.data.length;i++){
		              						arr.push(result.data[i]); 
		              					}
		              				}
		              			},
		              			error: function(result) {
		              				alert("不好意思,图表请求数据失败啦!");
		              				myCharts.hideLoading();
		                          }
		              		});
		                	  return arr;
		                  })() 
			            ,
			            itemStyle: {
		                    emphasis: {
		                        shadowBlur: 10,
		                        shadowOffsetX: 0,
		                        shadowColor: 'rgba(0, 0, 0, 0.5)'
		                     },
		                    normal:{
		                        color:function(params) {
		                        //自定义颜色
		                        var colorList = [          
		                                '#ffc700', '#2d38ff',
		                            ];
		                            return colorList[params.dataIndex]
		                         }
		                    }
		              	}
			        }
			    ]
			};
		  // 使用刚指定的配置项和数据显示图表。
		  myCharts.setOption(option2);
		
	});
</script>
</body>
</html>