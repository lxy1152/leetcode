package main

/**
238. 除自身以外数组的乘积
已解答
中等
相关标签
相关企业
给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。

题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

请 不要使用除法，且在 O(n) 时间复杂度内完成此题。



示例 1:

输入: nums = [1,2,3,4]
输出: [24,12,8,6]
示例 2:

输入: nums = [-1,1,0,-3,3]
输出: [0,0,9,0,0]


提示：

2 <= nums.length <= 105
-30 <= nums[i] <= 30
保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内


进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
*/

func productExceptSelf(nums []int) []int {

	// 计算出从前往后和从后往前的结果， 然后相乘就行
	one := make([]int, len(nums)+1)
	two := make([]int, len(nums)+1)
	one[0] = 1
	two[len(nums)] = 1
	for i := 0; i < len(nums); i++ {
		one[i+1] = one[i] * nums[i]
	}
	for i := len(nums) - 1; i >= 0; i-- {
		two[i] = two[i+1] * nums[i]
	}
	res := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		res[i] = one[i] * two[i+1]
	}
	return res
}

func main() {
	productExceptSelf([]int{1, 2, 3, 4})
}
