package main

import "sort"

// 561. 数组拆分 I

// 如果要得到最小数对的最大和值， 那么我们只要让数对之差尽可能小，就可以得到比较大的和值。

func arrayPairSum(nums []int) int {
	sort.Ints(nums)
	res := 0
	for i := 0; i < len(nums); i = i + 2 {
		res += min(nums[i], nums[i+1])
	}
	return res
}

func min(a, b int) int {
	if a > b {
		return b
	} else {
		return a
	}
}
