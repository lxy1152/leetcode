package main

import "sort"

/*
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。



示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
示例 2：

输入：nums = []
输出：[]
示例 3：

输入：nums = [0]
输出：[]


提示：

0 <= nums.length <= 3000
-105 <= nums[i] <= 105

*/

// 本来刚开始打算用双指针， 结果发现没办法正确的判断条件，所以 查看题解， 需要记录当前位置，
func threeSum(nums []int) [][]int {

	res := make([][]int, 0)
	sort.Ints(nums)

	for i := 0; i < len(nums); i++ {
		// 记录第一个数字  并且当成target
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		k := len(nums) - 1
		target := -nums[i]
		for j := i + 1; j < len(nums); j++ {
			if j > i+1 && nums[j] == nums[j-1] {
				continue
			}
			for j < k && nums[j]+nums[k] > target {
				k--
			}
			if k == j {
				break
			}
			if nums[j]+nums[k] == target {
				res = append(res, []int{nums[j], nums[k], -target})
			}
		}
	}

	return res
}

func main() {
	threeSum([]int{-1, 0, 1, 2, -1, -4})
}
