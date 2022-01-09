<template>
    <svg>
        <g v-for="(animationInfo, index) in animationInfos">
            <g>
                <rect v-if="animationInfo.shape.shapeName === 'rect'" :width="animationInfo.shape.width"
                      :height="animationInfo.shape.height" :x="animationInfo.shape.x" :y="animationInfo.shape.y"
                      :style="animationInfo.shape.style" :id="animationInfo.shape.shapeName+index"/>
            </g>
        </g>
    </svg>

    <el-button type="primary" :onClick="play">播放动画</el-button>
    <el-button type="primary" :onClick="reverse">反转动画</el-button>
</template>

<script>
import {gsap} from "gsap"
import axios from "axios"
import {ElMessage} from "element-plus"

let timeline = gsap.timeline({paused: true})

export default {
    name: "Animation",
    props: {
        animationName: {
            type: String,
            required: true
        }
    },
    data: function () {
        return {
            animationInfos: Array
        }
    },
    mounted: function () {
        this.loadAnimation()
    },
    methods: {
        loadAnimation: function () {
            const url = "http://127.0.0.1:8080/animation?name=" + this.animationName;

            axios.get(url).then(
                response => {
                    let errorCode = response.data.errorCode;

                    if (errorCode !== 0) {
                        ElMessage.error("加载" + this.animationName + "动画失败，" + response.data.errorMessage)
                        return
                    }

                    let responseData = response.data.data
                    this.animationInfos = responseData

                    this.$nextTick(function () {
                        for (let i = 0; i < responseData.length; i++) {
                            let shape = responseData[i].shape;
                            if (Object.keys(shape).length === 0 || !shape.hasOwnProperty("shapeName")) {
                                continue;
                            }

                            for (let j = 0; j < responseData[i].frames.length; j++) {
                                let frame = responseData[i].frames[j];
                                if (frame.animationType === 'to') {
                                    timeline.to(["#" + shape.shapeName + i], JSON.parse(frame.vars), frame.time);
                                }
                            }
                        }
                    })
                }
            ).catch(
                response => {
                    ElMessage.error("加载\"" + this.animationName + "\"动画失败，" + response.data.errorMessage)
                }
            )
        },
        play: function () {
            timeline.play()
        },
        reverse: function () {
            timeline.reverse()
        }
    }
}
</script>

<style scoped>
svg {
    height: 200px;
    display: block;
}
</style>
