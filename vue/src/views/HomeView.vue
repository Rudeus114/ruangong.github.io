<template>
  <div class="container">
    <el-container>
      <el-header style="background: linear-gradient(to right, #f8f9f9, #05d43c); display: flex; align-items: center;">
        <img src="../assets/hzau.jpg" style="height: 60px;">
        <h1 style="margin-left: 10px; color: greenyellow;">狮山有我</h1>
      </el-header>
      <el-main class="main-container">
        <!-- 使用 CSS 控制背景图片 -->
        <div class="background-image"></div>
        <!-- 使用 flex 布局 -->
        <div class="main-content" style="display: flex;">
          <!-- 左侧走马灯 -->
          <div class="carousel-container" style="flex: 1; margin-right: 20px;">
            <!-- 设置走马灯容器的宽度 -->
            <el-carousel height="360px" indicator-position="none" arrow="always" style="width: 130%;">
              <el-carousel-item v-for="item in imgList" :key="item">
                <img :src="item.url" class="carousel-item-image" />
              </el-carousel-item>
            </el-carousel>
          </div>
          <!-- 右侧内容 -->
          <div style="flex: 2;">
            <!-- 标题和内容 -->
            <div style="margin-bottom: 20px;margin-left: 200px;">
              <!-- 调整标题样式 -->
              <h1>新闻快讯:</h1>
              <p>
                <a href="https://news.hzau.edu.cn/2024/0504/69624.shtml">【新华社】习近平向全国广大青年致以节日祝贺和诚挚问候</a>。
              </p>
              <p>
                <a href="https://news.hzau.edu.cn/2024/0510/69677.shtml">学校举办党纪学习教育专题读书班</a>。
              </p>
              <p>
                <a href="https://news.hzau.edu.cn/2024/0509/69651.shtml">张启发院士一行访问乌兹别克斯坦多所科研教育单位</a>。
              </p>
              <p>
                <a href="https://news.hzau.edu.cn/2024/0504/69624.shtml">高翅检查指导党纪学习教育等工作</a>。
              </p>
              <p>
                <a href="https://news.hzau.edu.cn/2024/0510/69661.shtml">最新成果：“植物疫苗”成功应用于小麦</a>。
              </p>
              <p>
                <a href="https://news.hzau.edu.cn/2024/0503/69619.shtml">学校召开新一轮第一批巡察工作总结暨2024年巡察工作动员培训会</a>。
              </p>
              <p>
                <a href="https://www.hzau.edu.cn/info/1062/21072.htm">文明的星球——2024狮山读书节</a>。
              </p>
              <p>
                <a href="https://news.hzau.edu.cn/2024/0415/69446.shtml">读秒绝杀：经济管理学院本科生男足捧起2024“狮子山杯”</a>。
              </p>
        
            </div>
          </div>
        </div>
        <!-- 底部快捷入口 -->
        <div class="f-imgs">
          <img class="f-img" src="../assets/choice_1.png" @click="enterChoice1"/>
          <img class="f-img" src="../assets/choice_2.png" @click="enterChoice2"/>
          <img class="f-img" src="../assets/choice_3.png" @click="enterChoice3"/>
        </div>
        <div class="f-imgs">
         <a href="https://h5.ele.me/">
          <img class="f-img" src="../assets/choice_4.png" />
        </a>
        <a href="https://www.kuaidi100.com/">
          <img class="f-img" src="../assets/choice_5.png" />
        </a>
        <a href="https://www.gougoujp.com/">
          <img class="f-img" src="../assets/choice_6.png" />
        </a>
        </div>
      </el-main>
      <el-footer style="background-color: aliceblue;">
        <h6></h6>
      </el-footer>
    </el-container>
  </div>
</template>


  <style scoped>
  .container {
    height: 100vh;
    display: flex;
    margin: 0 auto; /* 居中 */
    max-width: 80%; /* 设置最大宽度 */
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.8);
  }
  
  .main-container {
  position: relative;
}

.background-image {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-image: url('../assets/home.jpg');
  background-size: cover;
  opacity: 0.5;
  z-index: -1;
}

  .carousel-container {
    margin: 0 0 0; /* 上下居中，左右自动间距 */
    width: 618.75px;
  }
  .carousel-item-image{
    max-height: 100%;
    margin:0;
    
  }
  
  .f-imgs {
    display: flex;
    justify-content: center;
  }
  
  .f-img {
    margin: 100px 100px; /* 按钮之间的间距 */
    width: 160px;
    box-shadow: 5px 5px 5px  rgba(66, 109, 183, 0.5);
  }
  </style>
  
<script>
  export default {
  data() {
    return {
      imgList: [
        {
          id: '1',
          url: require('../assets/z1.jpg')
        },
        {
          id: '2',
          url: require('../assets/z2.jpg')
        },
        {
          id: '3',
          url: require('../assets/z3.jpg')
        },
        {
          id: '4',
          url: require('../assets/z4.jpg')
        }
      ]
    }
  },
  methods:{
    enterChoice1(){
      this.$router.push("/choice1");
    },
    enterChoice2(){
      this.$router.push("/choice2");
    },
    enterChoice3(){
      this.$router.push("/choice3");
    }
  }
}
</script>
