<template>
  <div id="china_map_box">
    <div id="china_map">员工户籍分布</div>
  </div>
</template>

<script>
import * as echarts from 'echarts'
import 'echarts/map/js/china.js'
export default {
  data() {
    return {
      //echart 配制option
      options: {
        tooltip: {
          triggerOn: "mousemove",   //mousemove、click
          padding:8,
          borderWidth:1,
          borderColor:'#409eff',
          backgroundColor:'rgba(255,255,255,0.7)',
          textStyle:{
            color:'#000000',
            fontSize:13
          },
          formatter: function(e, t, n) {
            let data = e.data;
            //模拟数据
            data.specialImportant = Math.random()*1000 | 0;
            data.import = Math.random()*1000 | 0;
            data.compare = Math.random()*1000 | 0;
            data.common = Math.random()*1000 | 0;
            data.specail = Math.random()*1000 | 0;

            let context = `
               <div>
                   <p><b style="font-size:15px;">${data.name}</b></p>
                   <p class="tooltip_style"><span class="tooltip_left">人数</span><span class="tooltip_right">${data.value}</span></p>

            `
            return context;
          }
        },
        visualMap: {
          show:true,
          left: 26,
          bottom: 40,
          showLabel:true,
          pieces: [
            {
              gte: 100,
              label: ">= 100",
              color: "#1f307b"
            },
            {
              gte: 50,
              lt: 99,
              label: "50 - 99",
              color: "#3c57ce"
            },
            {
              gte: 30,
              lt:49,
              label: "30 - 49",
              color: "#6f83db"
            },
            {
              gte: 10,
              lt: 29,
              label: "10 - 29",
              color: "#9face7"
            },
            {
              lt:10,
              label:'<10',
              color: "#bcc5ee"
            }
          ]
        },
        geo: {
          map: "china",
          scaleLimit: {
            min: 1,
            max: 2
          },
          zoom: 1,
          // top: 120,
          label: {
            normal: {
              show:true,
              fontSize: "14",
              color: "rgba(0,0,0,0.7)"
            }
          },
          itemStyle: {
            normal: {
              //shadowBlur: 50,
              //shadowColor: 'rgba(0, 0, 0, 0.2)',
              borderColor: "rgba(0, 0, 0, 0.2)"
            },
            emphasis: {
              areaColor: "#f2d5ad",
              shadowOffsetX: 0,
              shadowOffsetY: 0,
              borderWidth: 0
            }
          }
        },
        series: [
          {
            name: "",
            type: "map",
            geoIndex: 0,
            data:[]
          }
        ]
      },
      //echart data
      dataList: [
        {
          name: "南海诸岛",
          value: 0,
          eventTotal:100,
          specialImportant:10,
          import:10,
          compare:10,
          common:40,
          specail:20
        },
        {
          name: "北京",
          value: 25
        },
        {
          name: "天津",
          value: 13
        },
        {
          name: "上海",
          value: 116
        },
        {
          name: "重庆",
          value: 18
        },
        {
          name: "河北",
          value: 78
        },
        {
          name: "河南",
          value: 13
        },
        {
          name: "云南",
          value: 39
        },
        {
          name: "辽宁",
          value: 29
        },
        {
          name: "黑龙江",
          value: 35
        },
        {
          name: "湖南",
          value: 45
        },
        {
          name: "安徽",
          value: 30
        },
        {
          name: "山东",
          value: 270
        },
        {
          name: "新疆",
          value: 9
        },
        {
          name: "江苏",
          value: 158
        },
        {
          name: "浙江",
          value: 104
        },
        {
          name: "江西",
          value: 36
        },
        {
          name: "湖北",
          value: 152
        },
        {
          name: "广西",
          value: 33
        },
        {
          name: "甘肃",
          value: 7
        },
        {
          name: "山西",
          value: 75
        },
        {
          name: "内蒙古",
          value: 11
        },
        {
          name: "陕西",
          value: 92
        },
        {
          name: "吉林",
          value: 41
        },
        {
          name: "福建",
          value: 18
        },
        {
          name: "贵州",
          value: 5
        },
        {
          name: "广东",
          value: 98
        },
        {
          name: "青海",
          value: 1
        },
        {
          name: "西藏",
          value: 0
        },
        {
          name: "四川",
          value: 44
        },
        {
          name: "宁夏",
          value: 4
        },
        {
          name: "海南",
          value: 22
        },
        {
          name: "台湾",
          value: 3
        },
        {
          name: "香港",
          value: 5
        },
        {
          name: "澳门",
          value: 25
        }
      ]
    };
  },
  methods: {
    //初始化中国地图
    initEchartMap() {
      this.getRequest('statistics/generalmsg/nativeplace').then(resp=> {
        if (resp) {
          this.list = resp;
          this.list.forEach(ele => {
            let obj = {};
            obj.name = ele.name;
            obj.value = ele.number;
            this.pie1.push(obj)
          });
        }
      })
      let mapDiv = document.getElementById('china_map');
      let myChart = echarts.init(mapDiv);
      myChart.setOption(this.options);


    },
    //修改echart配制
    setEchartOption(){
      this.options.series[0]['data'] = this.dataList;
    }
  },
  created() {
    this.setEchartOption();
  },
  mounted() {
    this.$nextTick(()=>{
      this.initEchartMap();
    })
  }
};


</script>

<style scoped>
#china_map_box {
  height: 100%;
  position: relative;
}
#china_map_box #china_map{
  height: 100%;
}
#china_map_box .china_map_logo{
  position: absolute;
  top: 0;
  left: 0;
  width:75px;
}
</style>
<style>
#china_map .tooltip_style{
  line-height:2.0;
  overflow: hidden;
}
#china_map .tooltip_left{
  float: left;
}
#china_map .tooltip_right{
  float: right;
}
</style>