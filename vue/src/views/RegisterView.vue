<template>
    <div class="background">
      <el-container class="box">
        <h1 class="register-title">注册</h1>
        <div class="register-box">
          <div class="input-group">
            <h3 class="w1">账号</h3>
            <el-input v-model="account" style="width: 240px;height:50px" placeholder="输入账号"/>
          </div>
          <div class="input-group">
            <h3 class="w1">密码</h3>
            <el-input v-model="password" style="width: 240px;height: 50px" type="password" placeholder="输入密码" show-password/>
          </div>
          <div class="input-group">
            <h3 class="w1">重复密码</h3>
            <el-input v-model="copypassword" style="width: 240px;height: 50px" type="password" placeholder="重新确定密码" show-password/>
          </div>
          <div class="input-group">
            <h3 class="w1">昵称</h3>
            <el-input v-model="username" style="width: 240px;height: 50px" placeholder="输入昵称"/>
          </div>
          <div class="button-group">
            <el-button @click="handleRegister" type="primary" round style="width: 100px;height: 40px">确定</el-button>
            <el-button @click="handleBack" type="primary" round style="width: 100px;height: 40px">返回</el-button>
          </div>
        </div>
      </el-container>
    </div>
  </template>
  
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
    height: 60%; /* 或者根据需要设置高度 */
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.8);
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  .register-title {
    font-size: 36px; /* 放大字体 */
    color: aqua; /* 字体颜色蓝色 */
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* 描边 */
    margin-bottom: 20px; /* 调整标题与输入框之间的距离 */
  }
  .register-box {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  .input-group {
    margin-bottom: 20px;
    display: flex;
    align-items: center;
  }
  .w1 {
    margin-right: 10px;
    font-size: 18px;
    width: 80px; /* 调整标签宽度 */
    text-align: left; /* 文字右对齐 */
  }
  .button-group {
    display: flex;
    justify-content: space-around; /* 按钮均分空间 */
    width: 100%; /* 按钮组占满整个宽度 */
  }
  </style>
  
  <script>
  import axios from 'axios';
  export default {
    name: "RegisterView",
    data() {
      return {
        account: "", //账号
        password: "", //密码
        copypassword: "", //确定密码
        username: "", //昵称
      };
    },
    methods: {
      handleRegister() {
        if (!this.account || !this.password || !this.copypassword || !this.username) {
          this.$alert("均不能为空", "提示", {
            confirmButtonText: "确定",
          });
        } else if (this.password != this.copypassword) {
          this.$alert("重复密码不正确", "提示", { confirmButtonText: "确定" });
        } else {
          // 注册逻辑
          // 向后端发送注册请求等
          axios.get("http://localhost:8090/register", {
            params: {
              username: this.account,
            }
          }).then((result) => {
            if (result.data.code == 1) {
              axios.post('http://localhost:8090/register', {
                  // 在这里添加你要发送的数据
                  // 例如：
                  username: this.account,
                  password: this.password,
                  name: this.username,
                  // 其他数据
                })
                .then(response => {
                  console.log(response.data); // 如果需要，处理后端返回的数据
                })
                .catch(error => {
                  console.error('Error:', error);
                });
              this.$alert("注册成功", { confirmButtonText: "确定", });
              this.$router.push("/");
            } else { //账号已经存在
              this.account = '', //账号
                this.password = '', //密码
                this.copypassword = '', //确定密码
                this.username = '', //昵称
                this.$alert("账号已存在", "提示", { confirmButtonText: "确定", });
            }
            //回调函数
            console.log(result);
          }).catch(err => {
            console.log(err);
            //异常
          })
        }
      },
      handleBack() {
        this.$router.push("/");
      }
    },
  
  }
  </script>
  