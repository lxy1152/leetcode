package main

/**
45. 跳跃游戏 II

给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

0 <= j <= nums[i]
i + j < n
返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。



示例 1:

输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
示例 2:

输入: nums = [2,3,0,1,4]
输出: 2


提示:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
题目保证可以到达 nums[n-1]
*/

// 自顶向下 和 自底向上 两种动态规划
func jump1(nums []int) int {
	dp := make([]int, len(nums))
	dp[0] = 0
	for i := 1; i < len(dp); i++ {
		dp[i] = 10001
	}
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			if j-i <= nums[i] {
				dp[j] = min(dp[i]+1, dp[j])
			}
		}
	}
	return dp[len(nums)-1]
}
func jump(nums []int) int {
	memo := make([]int, len(nums))
	for i := 0; i < len(memo); i++ {
		memo[i] = 10002
	}
	return dp(nums, len(nums)-1, memo)
}

func dp(nums []int, n int, memo []int) int {
	if n == 0 {
		return 0
	}
	res := 10002
	if memo[n] < 10002 {
		return memo[n]
	}
	for j := n - 1; j >= 0; j-- {
		if nums[j] >= n-j {
			res = min(res, dp(nums, j, memo)+1)
			memo[n] = res
		}
	}
	return res
}
func main() {
	println(jump([]int{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5}))
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
