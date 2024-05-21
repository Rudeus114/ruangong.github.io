<template>
  <div class="container">
    <el-container>
      <el-header style="background:linear-gradient(to right,#f8f9f9,#05d43c); display: flex; align-items: center;">
        <img src="@/assets/hzau.jpg" style="height: 60px;">
        <h1 style="margin-left: 10px; color: greenyellow;">狮山有我->找搭子</h1>
      </el-header>
      <el-main>
        <div v-for="post in posts.slice().reverse()" :key="post.id" class="post" style="background:linear-gradient(to right,#f8f9f9, #B3A5FC);" @click="goToPost(post.id)">
          <h2 class="post-title">{{ post.title }}</h2>
          <p class="post-content">{{ post.content }}</p>
          <h6 class="post-time">{{ post.time }}</h6>
        </div>
      </el-main>
      <img src="@/assets/write.jpg" width="50px" @click="write">
      <el-dialog v-model="dialogVisible" title="找搭子" width="500" :before-close="handleBeforeClose">
        <el-form :model="form" label-width="120px">
          <el-form-item label="标题">
            <el-input v-model="form.title" placeholder="请输入标题" autocomplete="off" />
          </el-form-item>
          <el-form-item label="正文内容">
            <el-input type="textarea" v-model="form.content" placeholder="请输入内容" :rows="5">
            </el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <div class="dialog-footer">
            <el-button @click="cancelDialog">取消</el-button>
            <el-button type="primary" @click="confirmDialog">提交</el-button>
          </div>
        </template>
      </el-dialog>
    </el-container>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { ElMessage } from 'element-plus';

const dialogVisible = ref(false);
const form = ref({
  id: '',
  title: '',
  content: '',
  posttime: '',
});

const posts = ref([]);

// 在页面加载时获取后端帖子数据
onMounted(() => {
  fetchPosts();
});

function fetchPosts() {
  axios.get('http://localhost:8090/choice3')
    .then(response => {
      // 检查后端返回的数据结构
      console.log('Received response:', response.data);

      // 确保数据正确解构
      const responseData = response.data;
      if (responseData && responseData.data && Array.isArray(responseData.data)) {
        // 将后端返回的帖子数组赋值给 posts.value
        posts.value = responseData.data;
        console.log('Received posts:', posts.value);
      } else {
        console.error('Invalid response format:', responseData);
      }
    })
    .catch(error => {
      console.error('Error fetching posts:', error);
    });
}
function write() {
  dialogVisible.value = true;
}

function cancelDialog() {
  form.value.title = '';
  form.value.content = '';
  dialogVisible.value = false;
}

function confirmDialog() {
  const currentDate = new Date();
  const year = currentDate.getFullYear();
  const month = String(currentDate.getMonth() + 1).padStart(2, '0');
  const day = String(currentDate.getDate()).padStart(2, '0');
  const formattedDate = `${year}-${month}-${day}`;

  form.value.posttime = formattedDate;
  console.log('Form data:', form.value);

  if (!form.value.title || !form.value.content) {
    alert("标题和内容不能为空", "提示", { confirmButtonText: "确定" });
  }
  else{
  axios.post('http://localhost:8090/choice3', {
    title: form.value.title,
    content: form.value.content,
    time: form.value.posttime
  })
  .then(response => {
    console.log('Response:', response.data); // 处理后端返回的数据
    ElMessage.success('帖子添加成功！');
  })
  .catch(error => {
    console.error('Error:', error);
  });
  dialogVisible.value = false;
  form.value.title = '';
  form.value.content = '';
  form.value.posttime = '';
  }
}

function handleBeforeClose() {
  form.value.title = '';
  form.value.content = '';
  dialogVisible.value = false;
}

function goToPost(postId) {
  console.log('跳转到帖子页面，帖子ID为：', postId);
  // 实现跳转逻辑
}
</script>

<style scoped>
.container {
  height: 100vh;
  display: flex;
  margin: 0 auto;
  max-width: 80%;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.8);
}

.post {
  position: relative;
  background-color: #ffffff;
  padding: 20px;
  margin-bottom: 20px;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.8);
}

.post-title {
  font-size: 36px;
  color: #63c4c6;
}

.post-content {
  color: #000000;
}
.post-time {
  position: absolute;
  bottom: 0px;
  right: 10px;
  font-size: 12px;
  color: #999;
}
</style>
