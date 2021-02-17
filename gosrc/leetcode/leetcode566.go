package main

// 566. 重塑矩阵

func matrixReshape(nums [][]int, r int, c int) [][]int {
	n, m := len(nums), len(nums[0])
	if n*m != r*c {
		return nums
	}
	ans := make([][]int, r)
	for i := range ans {
		ans[i] = make([]int, c)
	}
	for i := 0; i < n*m; i++ {
		ans[i/c][i%c] = nums[i/m][i%m]
	}
	return ans
}
