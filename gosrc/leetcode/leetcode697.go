package main

// 697. 数组的度
func findShortestSubArray(nums []int) int {
	leng := len(nums)
	left := make(map[int]int, 0)
	right := make(map[int]int, 0)
	count := make(map[int]int, 0)
	max := 0
	min := 50001
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
			right[nums[i]] = i
		} else {
			right[nums[i]] = i
		}

	}
	for k, v := range count {
		if v == max {
			min = Min(right[k]-left[k]+1, min)
		}

	}

	return min
}

func main() {
	print(findShortestSubArray([]int{1, 2, 2, 3, 1, 4, 2}))

}
