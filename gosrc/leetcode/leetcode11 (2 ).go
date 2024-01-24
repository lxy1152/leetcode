package main

/**
11. 盛最多水的容器
已解答
中等
相关标签
相关企业
提示
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。



示例 1：



输入：[1,8,6,2,5,4,8,3,7]
输出：49
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
示例 2：

输入：height = [1,1]
输出：1


提示：

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*/

/*
*
暴力解
*/
func maxArea(height []int) int {
	res := 0
	for i := 0; i < len(height); i++ {
		for j := 0; j < len(height); j++ {
			res = max(res, (j-i)*min(height[j], height[i]))

		}
	}
	return res
}

// 双指针解法
func maxArea(height []int) int {
	l, r := 0, len(height)-1
	res := 0
	for l < r {
		// 这道题一开始走进误区了， 先进行了下面的缩进步骤 再求解了，实际上这样对于刚好在 0 和  len -1 位置的两个数就直接跳过了，所以肯定错误， 而且对于 1,1 这种情况也没法处理  搞得把res:=1 设出来 又多错一次
		res = max(res, (r-l)*min(height[r], height[l]))

		if height[l] > height[r] {
			r--
		} else {
			l++
		}

	}
	return res
}
