<template>
    <div class="background">
      <el-container class="box">
        <div class="image-container">
          <img src="../assets/login.jpg" alt="" class="login-image" />
        </div>
        <div class="right">
          <h1 class="login-title">登录</h1>
          <el-input v-model="sharedData.account" style="width: 240px; height: 50px;" placeholder="输入账号"/>
          <p></p>
          <el-input v-model="sharedData.password" style="width: 240px; height: 50px;" type="password" placeholder="输入密码" show-password/>
          <p></p>
          <el-button @click="handleLogin" type="primary" round style="width: 120px; height: 40px;">登录</el-button>
          <p></p>
          <el-button @click="handleRegister" type="success" round style="width: 120px; height: 40px;">注册</el-button>
        </div>
      </el-container>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  import sharedData from './sharedData'; // 引入共享数据对象
  
  export default {
    name: "LoginView",
    data() {
      return {
        sharedData // 直接使用引入的 sharedData
      };
    },
    methods: {
      handleLogin() {
        const { account, password } = this.sharedData;
        if (!account || !password) {
          this.$alert("账号或密码不能为空", "提示", { confirmButtonText: "确定" });
        } else {
          // 登录逻辑
          axios.get("http://localhost:8090/", {
            params: {
              username: account,
              password: password
            }
          }).then((result) => {
            if (result.data.code === 1) {
              this.$router.push("/home");
            } else {
              this.$alert("账号或密码错误", "提示", { confirmButtonText: "确定" });
            }
          }).catch(err => {
            console.log(err);
          });
        }
      },
      handleRegister() {
        this.$router.push("/register");
      }
    }
  };
  </script>
  
<style>
    body {
        height: 100%;
        margin: 0;
    }
</style>
<style scoped>
.background{
  background: linear-gradient(to right, #65CBF7, #B3A5FC);
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
.box {
    position: fixed; /* 或者使用 absolute，根据需求选择 */
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 60%; /* 或者根据需要设置宽度 */
  height: auto; /* 或者根据需要设置高度 */
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.8);
}
.left {
    width: 65px;
}

.right {
    padding: 20px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.image-container {
    margin-bottom: 0px;
}

.login-image {
    max-width: 100%; /* Adjust the maximum width of the image */
    height: 100%; /* Maintain the aspect ratio */
}
.login-title {
    font-size: 36px; /* 放大字体 */
    color: aqua; /* 字体颜色蓝色 */
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* 描边 */
}
</style>
