package main

// 前缀和技巧
func pivotIndex(nums []int) int {
	len:= len(nums)
	if len <=1{
		return -1
	}
	var sum =[]int{};
	sum[0]=nums[0]
	for index,foo:=range nums {
		sum[index]=foo+sum[index-1]
	}
	for index,foo:=range sum{
		if sum[len-1]-foo==foo-nums[index-1] {
			return index
		}
	}

	return -1
}