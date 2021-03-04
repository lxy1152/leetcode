package main

// 300. 最长递增子序列
// 动态规划， 忘得差不多了，
//
func lengthOfLIS(nums []int) int {
	dp := make([]int, len(nums))
	max := func(i, j int) int {
		if i > j {
			return i
		}
		return j
	}
	res := 0
	for i := 0; i < len(nums); i++ {
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] {
				dp[i] = max(dp[j]+1, dp[i])
				res = max(dp[i], res)
			}
		}
	}
	return res + 1
}
