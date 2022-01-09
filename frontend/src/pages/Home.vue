<template>
    <div class="common-layout">
        <el-container>
            <el-header>
                <div>
                    LeetCode刷题笔记
                </div>
            </el-header>
            <el-container>
                <el-aside width="200px">Aside</el-aside>
                <el-main>
                    <el-scrollbar>
                        <el-tabs v-model="activeName" @tab-click="handleClick">
                            <el-tab-pane :label="item.name" :name="index" v-for="(item, index) in datas">
                                {{ item.number }}, {{ item.amount }}

                                <Animation animation-name="123"/>
                            </el-tab-pane>
                        </el-tabs>
                    </el-scrollbar>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import {gsap} from "gsap"
import Animation from "@/components/Animation";

let timeline = gsap.timeline({
    paused: true
})

export default {
    name: "Home",
    components: {
        Animation
    },
    data: function () {
        return {
            datas: [],
            activeName: 0
        }
    },
    mounted: function () {
        this.showData()
        this.loading()
    },
    methods: {
        showData: function () {
            this.datas = [{"name": "hello1", "number": 1, "amount": 10}, {"name": "hello2", "number": 2, "amount": 20}]
        },
        addData: function () {
            let a = this.datas.length + 1;
            this.datas.push({"name": "hello" + a, "number": a, "amount": a * 10})
        },
        handleClick: function (tab, event) {
            console.log(tab, event)
        },
        loading: function () {
            // timeline.to(["#rect-1", "#text-1"], {x: 69, fill: "green"}, 0)
            // timeline.fromTo(["#rect-2", "#text-2"], {x: 0}, {x: -69}, 0)
        },
        play: function () {
            timeline.play();
        },
        reverse: function () {
            timeline.reverse()
        }
    }
}
</script>

<style scoped lang="scss">
.common-layout {
    .el-header {
        background-color: white;
        color: var(--el-text-color-primary);
        line-height: 60px;
    }

    .el-footer {
        line-height: 60px;
    }

    .el-aside {
        background-color: #d3dce6;
        color: var(--el-text-color-primary);
        text-align: center;
        line-height: 200px;
    }

    .el-main {
        background-color: #e9eef3;
        color: var(--el-text-color-primary);
    }

    body > .el-container {
        margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }

    .loader-1 {
        background-color: black;
        color: white;
        width: 300px;
    }

    .loader-2 {
        background-color: black;
        color: white;
        width: 300px;
    }
}
</style>
