package main

/*
面试题 17.21. 直方图的水量
给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
*/

/*
 两遍遍历数组， 一遍存储大于当前位置 左边的最大值， 一遍存储大于当前位置右边的最大值，
求解之后可以得到，
0 位置和leng-1 位置分别是左边的墙壁和右边的墙壁，肯定不能放水的，所以不计，只统计其柱子高度即可

*/
func trap(height []int) int {
	leng := len(height)
	left := make([]int, leng)
	right := make([]int, leng)
	left[0] = height[0]
	for i := 1; i < leng; i++ {

		left[i] = max(height[i], left[i-1])

	}
	right[leng-1] = height[leng-1]
	for i := leng - 2; i >= 0; i-- {
		right[i] = max(height[i], right[i+1])
	}
	res := 0

	//l:=0
	//r:=leng-1

	for i := range height {
		res += min(left[i], right[i]) - height[i]
	}
	return res
}

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
func min(a, b int) int {
	if a > b {
		return b
	} else {
		return a
	}
}

func main() {
	print(trap([]int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}))
}
