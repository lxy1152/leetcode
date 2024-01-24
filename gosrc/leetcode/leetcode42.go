package main

/**
42. 接雨水
已解答
困难
相关标签
相关企业
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



示例 1：



输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：

输入：height = [4,2,0,3,2,5]
输出：9


提示：

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/

func trap(height []int) int {
	l, r := make([]int, len(height)), make([]int, len(height))
	l[0] = height[0]
	r[len(r)-1] = height[len(height)-1]
	// 两轮遍历 遍历出当前位置左边最高和右边最高， 取他俩之中最低的一个 然后减去当前位置的高度 就是当前位置能接受的雨水数量
	for i := 1; i < len(height); i++ {
		l[i] = max(l[i-1], height[i])
	}
	for i := len(height) - 2; i >= 0; i-- {
		r[i] = max(r[i+1], height[i])
	}

	res := 0
	for i := 0; i < len(height)-1; i++ {
		res += min(r[i], l[i]) - height[i]
	}
	return res
}
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
func main() {
	print(trap([]int{4, 2, 0, 3, 2, 5}))
}
