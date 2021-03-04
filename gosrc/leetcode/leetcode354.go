package main

import (
	"sort"
)

// 354. 俄罗斯套娃信封问题

func maxEnvelopes(envelopes [][]int) int {
	compare := func(input [][]int) {
		sort.Slice(input, func(i, j int) bool {
			a, b := input[i][0], input[j][0]
			if a > b || a == b && input[i][1] < input[j][1] {
				return false
			} else {
				return true
			}
		})

	}
	compare(envelopes)
	res := 0
	max := func(i, j int) int {
		if i > j {
			return i
		}
		return j
	}
	dp := make([]int, len(envelopes))
	for i := 0; i < len(envelopes); i++ {
		for j := 0; j < i; j++ {
			if envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1] {
				dp[i] = max(dp[j]+1, dp[i])

			}
			res = max(dp[i], res)
		}

	}
	return res + 1
}
func main() {
	print(maxEnvelopes([][]int{{1, 1}, {1, 1}, {1, 1}, {1, 1}}))
}
