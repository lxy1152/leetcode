package main

// 697. 数组的度
func findShortestSubArray1(nums []int) int {
	leng := len(nums)
	left := make(map[int]int, 0)
	right := make(map[int]int, 0)
	count := make([]int, 50001)
	max := 0
	min := 0
	Max := func(a, b int) int {
		if a > b {
			return a
		} else {
			return b
		}

	}
	Min := func(a, b int) int {
		if a > b {
			return b
		} else {
			return a
		}

	}
	for i := 0; i < leng; i++ {
		count[nums[i]]++
		max = Max(max, count[nums[i]])
		if _, exist := left[nums[i]]; !exist {
			left[nums[i]] = i
		} else {
			right[nums[i]] = i
		}
		min = Min(right[nums[i]]-left[nums[i]]+1, min)

	}

	return min
}
