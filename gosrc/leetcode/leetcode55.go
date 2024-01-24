package main

/**
55. 跳跃游戏
已解答
中等
相关标签
相关企业
给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。



示例 1：

输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
示例 2：

输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。


提示：

1 <= nums.length <= 104
0 <= nums[i] <= 105
*/

// 贪心算法
func canJump(nums []int) bool {

	if nums[0] == 0 && len(nums) > 1 {
		return false
	}
	if nums[0] == 0 || len(nums) == 1 {
		return true
	}
	most := 0
	// 第一次 这时是没有考虑断路操作的  需要加上most>=i 如果提前出现0 进行断路也可以处理
	for i := 0; i < len(nums)-1 && most >= i; i++ {
		// 具体贪心的步骤， 每次只计算最远能到达的距离
		most = max(nums[i]+i, most)
	}

	return most >= len(nums)-1
}
func main() {
	println(canJump([]int{1, 0, 1, 0}))
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
