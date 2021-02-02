package main

// 两数之和，用一个hash表存储已经读过的数的值，key 为下标
func twoSum(nums []int, target int) []int {

	dict := map[int]int{}
	for index, i := range nums {
		num, exist := dict[target-i]
		if exist {
			return []int{num, index}
		} else {
			dict[i] = index
		}

	}
	return nil

}
