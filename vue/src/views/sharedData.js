import { reactive } from 'vue'; // 引入 reactive 函数

// 使用 reactive 函数创建响应式数据对象
const sharedData = reactive({
  account: "", // 账号
  password: "", // 密码
});

export default sharedData;
