<template>
    <div>
        <div style="text-align: center">
            <span style="width: 200px" id="weather-view-he"></span>
        </div>
        <el-input v-model="userName" placeholder="请输入用户名">
            <template slot="prepend">用户名</template>
        </el-input>
        <el-input v-model="myDate" placeholder="请输入想要旅行的日期">
            <template slot="prepend">出发时间</template>
        </el-input>
        <div style="text-align: center">
            <el-button type="primary" @click="getAdvise">获取推荐</el-button>
        </div>
        <!--推荐信息-->
        <div>
            为您推荐：{{recommand}}✨🎉
        </div>
    </div>
</template>

<script>
    export default {
        name: "Journey",
        data() {
            return {
                userName: "",
                myDate: "",
                saving: 0,
                weather: null,
                recommand: "",

            }
        },
        methods: {
            getAdvise() {
                this.axios.get("http://localhost:8080/advise/" + this.userName + "/" + this.myDate).then(response => {
                    this.saving = parseInt(response.data);
                    this.axios.get("https://free-api.heweather.net/s6/weather/forecast?location=CN101190101&key=f3485ad252994834a1a40c96786fddff").then(response => {
                        this.weather = response.data;
                        //如果存款小于100，建议居家
                        if (this.saving <= 100) {
                            this.recommand = "存款小于100，建议居家";
                        } else if (this.weather.HeWeather6[0].daily_forecast[1].cond_code_d != "100"
                            && this.weather.HeWeather6[0].daily_forecast[2].cond_code_d != "100") {
                            this.recommand = "后两天天气不好，建议居家";
                        } else {
                            //存款在100-500，建议去西湖
                            if (this.saving <= 500) {
                                this.recommand = "明后两天，天气晴好，存款在100-500，建议去西湖";
                            } else {
                                //存款在>500，建议去南极看极光
                                this.recommand = "存款在>500，建议去南极看极光";
                            }
                        }
                    })
                })
            }
        },
        mounted() {

        }
    }
</script>

<style scoped>
    div {
        padding: 10px;
    }
</style>