package main

// 485. 最大连续 1 的个数
func findMaxConsecutiveOnes(nums []int) int {
	max, res := 0, 0
	for index, _ := range nums {
		if nums[index] == 1 {
			max++
		} else {
			max = 0
		}
		res = max7(res, max)

	}
	return res
}

func max7(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}

}
func main() {
	print(findMaxConsecutiveOnes([]int{1, 1, 0, 1, 1, 1}))
}
