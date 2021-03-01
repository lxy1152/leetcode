package main

type NumArray struct {
	nums1 []int
}

func constructor(nums []int) NumArray {
	numS := make([]int, len(nums)+1)
	numS[0] = 0
	for i := 1; i <= len(nums); i++ {
		numS[i] = nums[i-1] + numS[i-1]
	}

	return NumArray{nums1: numS}
}

func (this *NumArray) SumRange(i int, j int) int {
	return this.nums1[j+1] - this.nums1[i]
}

func main() {
	i := constructor([]int{-2, 0, 3, -5, 2, -1})
	print(i.nums1[3])
	print(i.nums1[2])
	print(i.SumRange(0, 5))
}
