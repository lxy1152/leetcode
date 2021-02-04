package main

func findMaxAverage(nums []int, k int) float64 {

	sum := 0

	for _, v := range nums[:k] {
		sum += v
	}
	res := sum
	for i := k; i < len(nums); i++ {
		sum += nums[i]
		sum = sum - nums[i-k]
		res = max(res, sum)

	}
	return float64(res) / float64(k)
}
func max1(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func main() {
	print(findMaxAverage([]int{5}, 1))
}
