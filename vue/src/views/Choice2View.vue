<template>
  <div class="container">
    <el-container>
      <el-header style="background: linear-gradient(to right, #f8f9f9, #05d43c); display: flex; align-items: center;">
        <img src="../assets/hzau.jpg" style="height: 60px;">
        <h1 style="margin-left: 10px; color: greenyellow;">狮山有我->表白墙</h1>
      </el-header>
      <el-main class="main-container">
        <!-- 使用 CSS 控制背景图片 -->
        <div class="background-image"></div>
        <div class="wrap">
          <div ref="box" class="box">
            <div v-for="(text, index) in randomTexts" :key="index">
              {{ text.text }}
            </div>
            </div>
      
        </div>
      </el-main>
      <el-footer style="background-color: aliceblue; display: flex; justify-content: center; align-items: center;">
        <el-input v-model="inputText" style="width: 240px;" placeholder="请输入你想说的话"></el-input>
        <el-button type="primary" @click="submit">发送</el-button>
        <el-button @click="cancel">取消</el-button>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      timer: null,
      inputText: '',
      randomTexts: [],
    };
  },

  methods: {
  submit() {
    if (this.inputText.trim() !== '') {
      const text = this.inputText.trim();
      axios.post('http://localhost:8090/choice2', { text })
        .then(() => {
          // 请求成功后，重新获取随机文本
          this.getRandomText();
        })
        .catch((error) => {
          console.error('提交数据时出错', error);
        });
    }
    this.inputText = ''; // 清空输入框
  },
  getRandomText() {
    axios
      .get('http://localhost:8090/choice2')
      .then((response) => {
        const responseData = response.data;
        if (responseData && responseData.data) {
          this.randomTexts = responseData.data;
          console.log('获取到的随机文本', this.randomTexts);
          this.startText(); // 开始滚动动画
        }
      })
      .catch((error) => {
        console.error('请求后端数据出错', error);
      });
  },
  startText() {
    if (this.timer) return;

    const textWidth = 1000;
    let distance = 1300;

    this.timer = setInterval(() => {
      distance -= 2;
      if (distance <= -textWidth) {
        distance = 1300;
      }
      this.$refs.box.style.transform = `translateX(${distance}px)`;
    }, 10);
  },
  stopText() {
    clearInterval(this.timer);
    this.timer = null;
    this.$refs.box.style.transform = '';
  },
  startInterval() {
    // 首次立即执行一次 getRandomText
    this.getRandomText();

    // 设置定时器，每隔 10 秒调用一次 getRandomText
    setInterval(() => {
      // 在调用 getRandomText 前可以执行其他逻辑，例如显示加载状态
      console.log('准备获取随机文本...');
      this.getRandomText(); // 调用获取随机文本函数
    }, 10000); // 10000 毫秒 = 10 秒
  }
},

mounted() {
  this.startInterval(); // 在组件挂载后启动定时器
},
  
  beforeUnmount() {
    this.stopText();
  },
};
</script>

<style scoped>
.container {
  height: 100vh;
  display: flex;
  margin: 0 auto;
  max-width: 80%;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.8);
}

.wrap {
  width: 100%;
  overflow: hidden;
}

.box {
  width: 100%;
  position: relative;
  height: 82vh;
  overflow: hidden;
}

.text-item {
  position: absolute;
  white-space: nowrap;
  line-height: 20px;
  right: 0;
  transform: translateX(100%);
  font-size: 16px;
  color: #333;
  padding: 5px;
  background-color: #f0f0f0;
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
  background-image: url('../assets/qiang.jpg');
  background-size: cover;
  opacity: 0.5;
  z-index: -1;
}
</style>
