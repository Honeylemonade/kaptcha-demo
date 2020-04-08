<template>
    <div>
        <div style="font-weight: lighter;font-size: 40px;text-align: center">
            信息查询服务
        </div>
        <div style="color: #a4a4a4;font-size: 14px;text-align: center">
            根据输入的手机号，查询相关信息
        </div>
        <el-input v-model="phoneNumber" placeholder="请输入手机号">
            <template slot="prepend">手机号</template>
        </el-input>
        <el-input v-model="value" placeholder="请输入验证码">
            <template slot="prepend">验证码</template>
        </el-input>
        <div style="text-align: center">
            <img width="100" height="30"
                 :src="picSrc"/>
        </div>
        <div style="text-align: center">
            <el-button type="primary" style="width: 100%" @click="findInfo">查询信息</el-button>
        </div>
        <div v-show="show">
            <ul>
                <li>手机号: {{msg}}</li>
                <li>今日天气：晴</li>
                <li>乘坐列车：K965</li>
                <li>手机归属地：江苏省 镇江市</li>
                <li>邮政编码：210034</li>
            </ul>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Information",
        data() {
            return {
                phoneNumber: "",
                key: "",
                value: "",
                picSrc: "",
                msg: "",
                show: false,
            }
        },
        mounted() {
            //初始化key和pic
            this.axios.get("http://localhost:8095/init").then(response => {
                console.log();
                this.picSrc = "data:image/jpg;base64," + response.data.picBase64;
                this.key = response.data.key;
            })
        },
        methods: {
            findInfo() {
                this.axios.get("http://localhost:8095/info/" + this.key + "/" + this.value + "/" + this.phoneNumber).then(response => {
                    if (response.data != null) {
                        this.msg = response.data;
                        this.show = true;
                    }
                })
            }
        }
    }
</script>

<style scoped>
    div {
        padding: 10px;
    }
</style>