package main

// 300. 最长递增子序列
// 动态规划， 忘得差不多了，
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

func lengthOfLIS1(nums []int) int {
	max := func(i, j int) int {
		if i > j {
			return i
		}
		return j
	}
	dp := make([]int, len(nums)+1)
	for i := 0; i < len(nums)+1; i++ {
		dp[i] = 1
	}
	// 最短也是1  就是当前位数
	res := 1
	for i := 0; i < len(nums); i++ {
		for j := i; j < len(nums); j++ {
			if nums[j] > nums[i] {
				dp[j+1] = max(dp[i+1]+1, dp[j+1])
				// dp 数组里存储的不是上一个状态   不知道这是否算是动态规划的一种  状态转移的很奇怪 ，  终态不一定来源于上一个最大的状态 所以 需要手动取最大值
				res = max(res, dp[j+1])
			}
		}
	}
	return res
}
func main() {
	println(lengthOfLIS1([]int{1, 3, 6, 7, 9, 4, 10, 5, 6}))
}
