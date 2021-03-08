package main

// 132. 分割回文串 II
// 昨天分割回文串的升级版。但是看输入数据的规模，如果回溯加剪枝暴力解法应该会超时。
// 动态规划 ， 利用求最长子序列的思想， 如果 后半串是一个回文串，当前的最小划分次数等于前一个串的最小加一，或者是当前dp 位置的原先值 ， 两者取小的哪个
func minCut(s string) int {

	n := len(s)
	f := make([][]bool, n)
	// 二维数组存储 减小判断回文串的代价。
	for i := range f {
		f[i] = make([]bool, n)
		for j := range f[i] {
			f[i][j] = true
		}
	}
	for i := n - 1; i >= 0; i-- {
		for j := i + 1; j < n; j++ {
			f[i][j] = s[i] == s[j] && f[i+1][j-1]
		}
	}
	min := func(a, b int) int {
		if a > b {
			return b
		}
		return a
	}
	dp := make([]int, n)
	for i := range dp {
		dp[i] = 2001
	}
	for i := 0; i < n; i++ {
		if f[0][i] {
			dp[i] = 0
		}
		for j := 0; j < i; j++ {
			if f[j+1][i] {
				dp[i] = min(dp[i], dp[j]+1)
			}

		}
	}

	return dp[len(dp)-1]
}

func main() {
	print(minCut("ab"))
}
