<template>
  <div class="container">
    <el-container>
      <el-header style="background:linear-gradient(to right,#f8f9f9,#05d43c); display: flex; align-items: center;">
        <img src="../assets/hzau.jpg" style="height: 60px;">
        <h1 style="margin-left: 10px;color: greenyellow;">狮山有我->盲盒信条</h1>
      </el-header>
      <el-main class="main-container">
        <!-- 使用 CSS 控制背景图片 -->
        <div class="background-image"></div>
        <!-- 按钮组 -->
        <div class="button-container">
          <el-button type="primary" @click="putInPaper">放入纸条</el-button>
          <el-button type="success" @click="putOutPaper">抽取纸条</el-button>
          <el-button type="primary" round @click="findputInPaper">查看我投入的纸条</el-button>
          <el-button type="success" round @click="findputOutPaper">查看我抽取的纸条</el-button>
        </div>
      </el-main>
      <el-footer>
        <h6></h6>
      </el-footer>
      <el-dialog v-model="inVisible" title="添加盲盒纸条" width="500" >
    <el-form :model="form" label-width="auto" style="max-width: 600px" z.index:1>
    <el-form-item label="昵称">
      <el-input v-model="form.name" />
    </el-form-item>
    <el-form-item label="性别">
      <el-radio-group v-model="form.sex">
        <el-radio value="男">男</el-radio>
        <el-radio value="女">女</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="地区">
      <el-select v-model="form.area" placeholder="请选择你的地区">
        <el-option label="河北" value="河北" />
        <el-option label="山西" value="山西" />
        <el-option label="辽宁" value="辽宁" />
        <el-option label="吉林" value="吉林" />
        <el-option label="黑龙江" value="黑龙江" />
        <el-option label="江苏" value="江苏" />
        <el-option label="浙江" value="浙江" />
        <el-option label="安徽" value="安徽" />
        <el-option label="福建" value="福建" />
        <el-option label="江西" value="江西" />
        <el-option label="山东" value="山东" />
        <el-option label="河南" value="河南" />
        <el-option label="湖北" value="湖北" />
        <el-option label="广东" value="广东" />
        <el-option label="海南" value="海南" />
        <el-option label="四川" value="四川" />
        <el-option label="贵州" value="贵州" />
        <el-option label="云南" value="云南" />
        <el-option label="陕西" value="陕西" />
        <el-option label="甘肃" value="甘肃" />
        <el-option label="青海" value="青海" />
        <el-option label="台湾" value="台湾" />
        <el-option label="内蒙古" value="内蒙古" />
        <el-option label="广西" value="广西" />
        <el-option label="西藏" value="西藏" />
        <el-option label="宁夏" value="宁夏" />
        <el-option label="新疆" value="新疆" />
        <el-option label="北京" value="北京" />
        <el-option label="天津" value="天津" />
        <el-option label="上海" value="上海" />
        <el-option label="重庆" value="重庆" />
        <el-option label="香港" value="香港" />
        <el-option label="澳门" value="澳门" />
      </el-select>
    </el-form-item>
    <el-form-item label="星座">
      <el-select v-model="form.sign" placeholder="请选择你的星座">
        <el-option label="白羊座" value="白羊座" />
        <el-option label="金牛座" value="金牛座" />
        <el-option label="双子座" value="双子座" />
        <el-option label="巨蟹座" value="巨蟹座" />
        <el-option label="狮子座" value="狮子座" />
        <el-option label="处女座" value="处女座" />
        <el-option label="天秤座" value="天秤座" />
        <el-option label="天蝎座" value="天蝎座" />
        <el-option label="射手座" value="射手座" />
        <el-option label="摩羯座" value="摩羯座" />
        <el-option label="水瓶座" value="水瓶座" />
        <el-option label="双鱼座" value="双鱼座" />
      </el-select>
    </el-form-item>
    <el-form-item label="vx">
      <el-input v-model="form.vx" />
    </el-form-item>
    <el-form-item label="内容">
      <el-input v-model="form.text" type="textarea" />
    </el-form-item>
  </el-form>
        <template #footer>
          <div class="dialog-footer">
            <el-button @click="cancelIn">取消</el-button>
            <el-button type="primary" @click="confirmIn">提交</el-button>
          </div>
        </template>
      </el-dialog>

      <el-dialog v-model="inoutVisible" title="抽取盲盒信条" width="400">
        <el-form :model="form" label-width="100px">
          <el-form-item label="性别">
      <el-radio-group v-model="formout.sex">
        <el-radio value="男">男</el-radio>
        <el-radio value="女">女</el-radio>
        <el-radio value="">不限</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="地区">
      <el-select v-model="formout.area" placeholder="请选择你想要的地区">
        <el-option label="不限" value="" />
        <el-option label="河北" value="河北" />
        <el-option label="山西" value="山西" />
        <el-option label="辽宁" value="辽宁" />
        <el-option label="吉林" value="吉林" />
        <el-option label="黑龙江" value="黑龙江" />
        <el-option label="江苏" value="江苏" />
        <el-option label="浙江" value="浙江" />
        <el-option label="安徽" value="安徽" />
        <el-option label="福建" value="福建" />
        <el-option label="江西" value="江西" />
        <el-option label="山东" value="山东" />
        <el-option label="河南" value="河南" />
        <el-option label="湖北" value="湖北" />
        <el-option label="广东" value="广东" />
        <el-option label="海南" value="海南" />
        <el-option label="四川" value="四川" />
        <el-option label="贵州" value="贵州" />
        <el-option label="云南" value="云南" />
        <el-option label="陕西" value="陕西" />
        <el-option label="甘肃" value="甘肃" />
        <el-option label="青海" value="青海" />
        <el-option label="台湾" value="台湾" />
        <el-option label="内蒙古" value="内蒙古" />
        <el-option label="广西" value="广西" />
        <el-option label="西藏" value="西藏" />
        <el-option label="宁夏" value="宁夏" />
        <el-option label="新疆" value="新疆" />
        <el-option label="北京" value="北京" />
        <el-option label="天津" value="天津" />
        <el-option label="上海" value="上海" />
        <el-option label="重庆" value="重庆" />
        <el-option label="香港" value="香港" />
        <el-option label="澳门" value="澳门" />
      </el-select>
    </el-form-item>
    <el-form-item label="星座">
      <el-select v-model="formout.sign" placeholder="请选择你想要的对方星座">
        <el-option label="不限" value="" />
        <el-option label="白羊座" value="白羊座" />
        <el-option label="金牛座" value="金牛座" />
        <el-option label="双子座" value="双子座" />
        <el-option label="巨蟹座" value="巨蟹座" />
        <el-option label="狮子座" value="狮子座" />
        <el-option label="处女座" value="处女座" />
        <el-option label="天秤座" value="天秤座" />
        <el-option label="天蝎座" value="天蝎座" />
        <el-option label="射手座" value="射手座" />
        <el-option label="摩羯座" value="摩羯座" />
        <el-option label="水瓶座" value="水瓶座" />
        <el-option label="双鱼座" value="双鱼座" />
      </el-select>
    </el-form-item>
        </el-form>
        <template #footer>
          <div class="dialog-footer">
            <el-button @click="cancelInOut">取消</el-button>
            <el-button type="primary" @click="confirmInOut">提交</el-button>
          </div>
        </template>
      </el-dialog>

      <el-dialog v-model="outVisible" title="抽取盲盒纸条" width="500">
    <el-descriptions
      :column="1">
    <el-descriptions-item label="发送者:">{{ formout.username }}</el-descriptions-item>
    <el-descriptions-item label="性别:">
      <el-tag size="small">{{formout.sex}}</el-tag>
    </el-descriptions-item>
    <el-descriptions-item label="地区:" :span="2">{{formout.area}}</el-descriptions-item>
    <el-descriptions-item label="星座:">
      <el-tag>{{formout.sign}}</el-tag>
    </el-descriptions-item>
    <el-descriptions-item label="微信号:" :span="2">{{formout.vx}}</el-descriptions-item>
    <el-descriptions-item label="内容:">
    </el-descriptions-item>
    <el-descriptions-item>
      {{formout.text}}
    </el-descriptions-item>
  </el-descriptions>
        <template #footer>
          <div class="dialog-footer">
            <el-button type="primary" @click="confirmOut">确定</el-button>
          </div>
        </template>
      </el-dialog>

<el-dialog v-model="findIn" title="查找我投入的纸条" width="800">
        <el-table :data="InData"  style="width: 100%">
          <el-table-column prop="username" label="名字" width="100" />
          <el-table-column prop="sex" label="性别" width="100" />
          <el-table-column prop="area" label="地区" width="100" />
          <el-table-column prop="sign" label="星座" width="100" />
          <el-table-column prop="vx" label="微信号" width="100" />
          <el-table-column prop="text" label="内容" />
        </el-table>
        <template #footer>
          <div class="dialog-footer">
            <el-button type="primary" @click="confirmfindIn">返回</el-button>
          </div>
        </template>
</el-dialog>

 <el-dialog v-model="findOut" title="查找我抽取的纸条" width="800">
  <el-table :data="OutData"  style="width: 100%">
          <el-table-column prop="username" label="发布人" width="100" />
          <el-table-column prop="sex" label="性别" width="100" />
          <el-table-column prop="area" label="地区" width="100" />
          <el-table-column prop="sign" label="星座" width="100" />
          <el-table-column prop="vx" label="微信号" width="100" />
          <el-table-column prop="text" label="内容" />
        </el-table>
        <template #footer>
          <div class="dialog-footer">
            <el-button type="primary" @click="confirmfindOut">返回</el-button>
          </div>
        </template>
      </el-dialog>     
    </el-container>
  </div>
</template>

<script>
import {ref,reactive } from 'vue';
import axios from 'axios';
import { ElMessage } from 'element-plus';
import sharedData from './sharedData'; // 引入共享数据对象

export default {
  name: "Choice1View",
  setup() {
    const inVisible = ref(false); // 放入纸条的对话框显示状态
    const outVisible = ref(false);// 取出纸条的第二个对话框显示状态
    const inoutVisible = ref(false);// 取出纸条的第一个对话框显示状态
    const findIn = ref(false);// 查找我放入的纸条对话框显示状态
    const findOut = ref(false);// 查找我抽取的纸条对话框显示状态
    const form = reactive({
    name: '',
    sex: '',
    area: '',
    sign: '',
    vx: '',
    text: '',
  })

   const formout = reactive({
     username: '',
     sex: '',
     area: '',
     sign: '',
     vx: '',
     text: '',
   })
   const InData = ref([]);
   const OutData = ref([]);

    // 放入纸条方法
    const putInPaper = () => {
      // 显示对话框
      inVisible.value = true;

      // 这里可以使用 sharedData.value.account 和 sharedData.value.password 访问共享数据
      // 这里是模拟发送数据到后端
      //const text = `账号：${sharedData.value.account}`;
    };

    const cancelIn = () => {
      form.name = '';
      form.sex = '';
      form.area = '';
      form.sign = '';
      form.vx = '';
      form.text = '';
      inVisible.value = false; // 关闭对话框
    };

    const confirmIn = () => {
      // 处理对话框提交逻辑，这里可以根据实际需求进行处理
      

      if (!sharedData.account & !form.text) {
        alert("标题和内容不能为空", "提示", { confirmButtonText: "确定" });
      }
      else{
      axios.post('http://localhost:8090/choice1', {
        sex:form.sex,
        username:sharedData.account,
        area:form.area,
        sign:form.sign,
        text:form.text,
        vx:form.vx
      })
      .then(response => {
        console.log('Response:', response.data); // 处理后端返回的数据
        ElMessage.success('添加成功！');
      })
      .catch(error => {
        console.error('Error:', error);
      });
      inVisible.value = false;
      form.name = '';
      form.sex = '';
      form.area = '';
      form.sign = '';
      form.vx = '';
      form.text = '';
    }
  };

  //取出纸条
   const putOutPaper = () => {
      // 显示对话框
      inoutVisible.value = true;
    };

    const cancelInOut = () => {
      inoutVisible.value = false; // 关闭对话框
      formout.sex = '';
      formout.area = '';
      formout.sign = '';
    };

    const confirmInOut = () => {
      inoutVisible.value = false; // 关闭对话框
      outVisible.value=true;

      axios.get("http://localhost:8090/choice1", {
  params: {
    sex: formout.sex,
    area: formout.area,
    sign: formout.sign,
  }
}).then((response) => {
  console.log('Received response:', response.data);

  // 获取后端返回的数据
  const responseData = response.data;

  // 确保 responseData 中有正确的数据结构
  if (responseData) {
    // 更新 formout 对象的属性
    formout.username = responseData.data.username;
    formout.sex = responseData.data.sex;
    formout.area = responseData.data.area;
    formout.sign = responseData.data.sign;
    formout.vx = responseData.data.vx;
    formout.text = responseData.data.text;
    console.log('Updated formout:', formout);
  }
}).catch(err => {
  console.log('Error:', err);
});


    };
      // 处理对话框提交逻辑，这里可以根据实际需求进行处理
      
    const confirmOut = () => {  
      inoutVisible.value = false; // 关闭对话框
      outVisible.value=false;
      
    //表格数据回归清空
     formout.username= '';
     formout.sex= '';
     formout.area='';
     formout.sign= '';
     formout.vx='';
     formout.text= '';
  };

  const findputInPaper = () => {
  // 显示查找我投入的纸条的对话框
  findIn.value = true;

  // 发起 HTTP GET 请求
  axios.get('http://localhost:8090/searchSend', {
    params: {
      username: sharedData.account
    }
  })
  .then(response => {
    // 更新组件中的数据，确保使用 this.InData
    InData.value = response.data.data; // 假设响应数据是一个对象数组
    console.log('响应数据:', InData);
  })
  .catch(error => {
    console.error('请求数据时发生错误:', error);
  });
};


  const confirmfindIn = () => {
      // 关闭对话框
      findIn.value = false;
    };

    const findputOutPaper = () => {
      // 显示查找我抽取的纸条的对话框
      findOut.value = true;

      axios.get('http://localhost:8090/searchOwn', {
    params: {
      username: sharedData.account
    }
  })
  .then(response => {
    console.log('响应数据111:', sharedData.account);
    console.log('响应数据:', response.data);
    // 更新组件中的数据，确保使用 this.InData
    OutData.value = response.data.data; // 假设响应数据是一个对象数组
  })
  .catch(error => {
    console.error('请求数据时发生错误:', error);
  });

    };

    const confirmfindOut = () => {
      // 关闭对话框
      findOut.value = false;

    };


    return {
      inoutVisible,//点击抽取纸条按钮的第一个dialog框的可视度
      inVisible,//点击放入纸条按钮的dialog框的可视状态
      form,//点击放入纸条按钮中dialog框中的表格信息存储数组
      formout,//点击抽取纸条按钮的第一个dialog框的表格信息存储数组,同时作为第二步展示的所需要数组存储
      findIn,//点击查找放入纸条按钮的dialog框的可视度
      findOut,//点击查找抽取纸条按钮的dialog框的可视度
      putInPaper,//点击放入纸条按钮的点击事件
      cancelIn,//点击放入纸条按钮的对话框的取消按钮
      confirmIn,//点击放入纸条按钮的对话框的确定按钮
      confirmfindIn,//点击点击查找放入纸条按钮
      confirmfindOut,//点击查找抽取纸条按钮
      outVisible,//点击抽取纸条按钮的对话框中点击确定按钮后的第二个对话框的可视状态
      putOutPaper,//点击抽取纸条按钮的点击事件
      confirmOut, //点击抽取纸条后的第二个对话框的确定按钮
      cancelInOut,//点击抽取纸条后的第一个对话框的取消按钮
      confirmInOut, //点击抽取纸条后的第一个对话框的确定按钮
      findputInPaper,
      findputOutPaper,
      InData,
      OutData
    };
  }
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

.main-container {
  position: relative;
}

.background-image {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-image: url('../assets/box.jpg');
  background-size: cover;
  opacity: 0.5;
  z-index: -1;
}

.button-container {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 1;
  display: flex;
  justify-content: center;
  align-items: center;
}
.el-descriptions {
  margin-top: 20px;
}
</style>