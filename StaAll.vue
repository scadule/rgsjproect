<template>
  <div class="pro_info">
    <div class="top">
      <div class="left">
        <div class="kuang1" id="1">
          <div style="align-content: center">
            部门人员统计
          </div>
        </div>
      </div>
      <div class="right">
        <div class="kuang2" id="2">
          <div style="align-content: center">
            员工最高学历统计
          </div>
        </div>
      </div>
    </div>
    <div class="bottom">
      <div class="left">
        <div class="kuang3" id="3">
          <div style="align-content: center">
            员工户籍统计
          </div>
        </div>
      </div>
      <div class="right">
        <div class="kuang4" id="4">
          <div style="align-content: center">
            员工职称统计
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import * as echarts from 'echarts'
// Vue.prototype.$echarts = echarts

// import $ from "jquery"



    export default {
        name: "StaAll",
      components: {},

      data(){
          return{
            list1:[],
            arrx1:[],
            arry1:[],

            pie1:[],
            list2:[],
            arrx2:[],
            arry2:[],

            pie2:[],
            list3:[],
            arrx3:[],
            arry3:[],

            pie3:[],
            list4:[],
            arrx4:[],
            arry4:[]
          }
      },
      mounted() {

        console.log('class',document.getElementById('1'));
        // 基于准备好的dom，初始化echarts实例
        this.draw1();

        console.log('class',document.getElementById('2'));
        // 基于准备好的dom，初始化echarts实例
        this.draw2();

        console.log('class',document.getElementById('3'));
        // 基于准备好的dom，初始化echarts实例
        this.draw3();

        console.log('class',document.getElementById('4'));
        // 基于准备好的dom，初始化echarts实例
        this.draw4();


      },


      methods:{
        draw1(){
          this.getRequest('statistics/generalmsg/department').then(resp=>{
            if(resp){
              this.list1=resp;
              this.list1.forEach(ele =>{
                this.arrx1.push(ele.name)
                this.arry1.push(ele.number)
              });

              var myChart = echarts.init(document.getElementById('1'));
              // 绘制图表
              myChart.setOption({
                title: {
                  text: '部门人员统计',
                  left: 'center'
                },
                tooltip: {},
                toolbox: {
                  feature: {
                    saveAsImage: {}
                  }
                },
                xAxis: {
                  data: this.arrx1,
                  axisTick: {
                    alignWithLabel:true
                  },
                  axisLabel: {
                        interval:0,
                        rotate:-30  //倾斜的程度
                      }

                },
                yAxis: {},
                series: [
                  {
                    name: '人数',
                    type: 'bar',
                    center: ['50%','90%'],
                    data: this.arry1,
                    showBackground: true,
                    backgroundStyle: {
                      color: 'rgba(240,248,255,0.45)'
                    },
                    emphasis: {
                      itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                      }
                    },
                    itemStyle: {
                      normal: {
                        //这里是重点
                        color: function(params) {
                          //注意，如果颜色太少的话，后面颜色不会自动循环，最好多定义几个颜色
                          var colorList = ['#c23531','#2f4554', '#61a0a8', '#d48265', '#91c7ae','#749f83', '#ca8622','#838B83','#61a0a8','#d48265','#91c7ae'];
                          return colorList[params.dataIndex]
                          if (params.dataIndex >= colorList.length) {
                            index = params.dataIndex - colorList.length;
                          }
                        }
                      }
                    }
                  }
                ]
              });
            }
          })

        },
        draw2(){
          this.getRequest('statistics/generalmsg/degree').then(resp=>{
            if(resp) {
              this.list2 = resp;

                this.list2.forEach(ele => {
                // this.arrx2.push(ele.name)
                // this.arry2.push(ele.number)
                  let obj = {};
                  obj.name =ele.name;
                  obj.value=ele.number;
                  this.pie1.push(obj)
              });
              var myChart = echarts.init(document.getElementById('2'));
// 绘制图表
              myChart.setOption({

                title: {
                  text: '最高学历统计',
                  left: 'center'
                },
                tooltip: {
                  trigger: 'item'
                },
                toolbox: {
                  feature: {
                    saveAsImage: {}
                  }
                },
                legend: {
                  orient: 'vertical',
                  // left: 'left',
                  x: 'left',
                  y: 'center',
                  itemGap: 25
                },

                series: [
                  {
                    name: '',
                    type: 'pie',
                    radius: '80%',
                    data: this.pie1,
                    label: {
                      normal: {
                        position: 'inner',
                        show: false
                      }
                    },
                    itemStyle: {
                      normal: {
                        //这里是重点
                        color: function(params) {
                          //注意，如果颜色太少的话，后面颜色不会自动循环，最好多定义几个颜色
                          var colorList = ['#c23531','#2f4554', '#61a0a8', '#d48265', '#91c7ae','#749f83', '#ca8622','#838B83','#61a0a8','#d48265','#91c7ae','#c23531', '#91c7ae','#838B83'];
                          return colorList[params.dataIndex]
                          if (params.dataIndex >= colorList.length) {
                            index = params.dataIndex - colorList.length;
                          }
                        }
                      }
                    },
                    emphasis: {
                      itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                      }
                    }
                  }
                ]
              });
            }
            })
        },
        draw3(){
          this.getRequest('statistics/generalmsg/gender').then(resp=>{
            if(resp) {
              this.list3 = resp;

              this.list3.forEach(ele => {
                let obj = {};
                obj.name = ele.name;
                obj.value = ele.number;
                this.pie2.push(obj)
              });
              var myChart = echarts.init(document.getElementById('3'));
// 绘制图表
              myChart.setOption({
                title: {
                  text: '员工男女比例',
                  left: 'center'
                },
                tooltip: {
                  trigger: 'item'
                },
                toolbox: {
                  feature: {
                    saveAsImage: {}
                  }
                },
                legend: {
                  orient: 'vertical',
                  // left: 'left',
                  x: 'left',
                  y: 'center',
                  itemGap: 25
                },

                series: [
                  {
                    name: '',
                    type: 'pie',
                    radius: '80%',
                    data: this.pie2,
                    itemStyle: {
                      normal: {
                        //这里是重点
                        color: function(params) {
                          //注意，如果颜色太少的话，后面颜色不会自动循环，最好多定义几个颜色
                          var colorList = ['#d48265','#91c7ae'];
                          return colorList[params.dataIndex]
                          if (params.dataIndex >= colorList.length) {
                            index = params.dataIndex - colorList.length;
                          }
                        }
                      }
                    },
                    label: {
                      normal: {
                        position: 'inner',
                        show: false
                      }
                    },
                    emphasis: {
                      itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                      }
                    }
                  }
                ]
              });
            }
            })
        },
        draw4(){
              this.getRequest('statistics/generalmsg/position').then(resp=> {
                if (resp) {
                  this.list4 = resp;

                  this.list4.forEach(ele => {
                    let obj = {};
                    obj.name = ele.name;
                    obj.value = ele.number;
                    this.pie3.push(obj)
                  });
                }
                var myChart = echarts.init(document.getElementById('4'));
// 绘制图表
                myChart.setOption({
                  title: {
                    text: '员工职位统计',
                    left: 'center'
                  },
                  tooltip: {
                    trigger: 'item'
                  },
                  toolbox: {
                    feature: {
                      saveAsImage: {}
                    }
                  },
                  legend: {
                    orient: 'vertical',
                    // left: 'left',
                    x: 'left',
                    y: 'center',
                    itemGap: 18
                  },

                  series: [
                    {
                      name: '',
                      type: 'pie',
                      radius: '80%',
                      data: this.pie3,
                      label: {
                        normal: {
                          position: 'inner',
                          show: false
                        }
                      },
                      itemStyle: {
                        normal: {
                          //这里是重点
                          color: function(params) {
                            //注意，如果颜色太少的话，后面颜色不会自动循环，最好多定义几个颜色
                            var colorList = ['#c23531','#2f4554', '#61a0a8', '#d48265', '#91c7ae','#749f83', '#ca8622','#838B83','#61a0a8','#d48265','#91c7ae'];
                            return colorList[params.dataIndex]
                            if (params.dataIndex >= colorList.length) {
                              index = params.dataIndex - colorList.length;
                            }
                          }
                        }
                      },
                      emphasis: {
                        itemStyle: {
                          shadowBlur: 10,
                          shadowOffsetX: 0,
                          shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                      }
                    }
                  ]
                });
              })
        }
      }
    }
</script>

<style scoped>
.pro_info {
  /*position: absolute;*/
  width: 100%;
  height: 100%;
}
.pro_info .top {
  width: 100%;
  height: 50%;
  /*background-color: yellow;*/
}
.pro_info .bottom {
  /*background: #d9c666;*/
  width: 100%;
  height: 50%;
}

.left {
  width: 50%;
  height: 100%;
  float: left;
}

.top .left {
  /*background-color: black;*/
}
.top .right {
  /*background-color: black;*/
}

.right {
  float: left;
  width: 50%;
  height: 100%;
}

.bottom.left {
  /*background-color: black;*/
}

.bottom.right {
  /*background-color: black;*/
}
.kuang1{
  background-color:#E0E0E0;
  width: 96%;
  height: 96%;
  margin: 1%;
  border-radius: 10px;
}
.kuang2{
  background-color:#E0E0E0;
  width: 96%;
  height: 96%;
  margin: 1%;
  border-radius: 10px;
}
.kuang3{
  background-color:#E0E0E0;
  width: 96%;
  height: 96%;
  margin: 1%;
  border-radius: 10px;
}
.kuang4{
  background-color:#E0E0E0;
  width: 96%;
  height: 96%;
  margin: 1%;
  border-radius: 10px;
}
</style>