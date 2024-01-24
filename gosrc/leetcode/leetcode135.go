package main

/**
135. 分发糖果
困难
相关标签
相关企业
n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。

你需要按照以下要求，给这些孩子分发糖果：

每个孩子至少分配到 1 个糖果。
相邻两个孩子评分更高的孩子会获得更多的糖果。
请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。



示例 1：

输入：ratings = [1,0,2]
输出：5
解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
示例 2：

输入：ratings = [1,2,2]
输出：4
解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。


提示：

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104
*/

func candy(ratings []int) int {
	res := make([]int, len(ratings))
	for i := 0; i < len(res); i++ {
		res[i] = 1
	}
	// 先正序一遍， 将右边较大的数变成比左边大一 最后一个不用考虑 因为已经计算过了
	for i := 0; i < len(ratings)-1; i++ {
		if ratings[i] < ratings[i+1] {
			res[i+1] = res[i] + 1
		}
	}
	// 再 逆序一遍， 将左边较大的数变为比右边大一， 因为在前文已经计算出靠后一位的值了
	for i := len(ratings) - 1; i > 0; i-- {
		if ratings[i] < ratings[i-1] {
			res[i-1] = max(res[i]+1, res[i-1])
		}
	}
	r := 0
	for i := 0; i < len(res); i++ {
		r += res[i]
	}
	return r
}
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func main() {
	print(candy([]int{1}))
}
