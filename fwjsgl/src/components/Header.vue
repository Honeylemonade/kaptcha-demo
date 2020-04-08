<template>
    <div>
        <el-menu
                :router=true
                mode="horizontal"
                background-color="#545c64"
                text-color="#fff"
                active-text-color="#ffd04b">
            <el-menu-item index="/Journey">旅行规划服务</el-menu-item>
            <el-menu-item index="/Information">信息查询服务</el-menu-item>

        </el-menu>
    </div>
</template>

<script>
    export default {
        name: "Header"
    }
</script>

<style scoped>

</style>