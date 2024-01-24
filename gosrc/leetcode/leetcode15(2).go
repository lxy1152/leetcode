package main

import "sort"

/*
*15. 三数之和
已解答
中等
相关标签
相关企业
提示
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
示例 2：

输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
示例 3：

输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。

提示：

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/
func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	res := make([][]int, 0)
	// 应该先进行大循环  再 进行 l 和 r的双指针位移   这样很容易遍历完  之前想错了 把 l<r放在最外层循环了， 这样 对于里层的循环不好处理了
	for i := 0; i < len(nums)-1 && nums[i] <= 0; i++ {
		for i > 0 && i < len(nums)-1 && nums[i] == nums[i-1] {
			i++
		}
		l, r := i+1, len(nums)-1
		for l < r {

			if nums[l]+nums[r]+nums[i] == 0 {
				// 针对于 -2 0 0 2 2 这种情况做特殊处理， 即 已存在相同情况， r-- l++ 完还是上一种  符合的话什么也不做
				if l > i+1 && nums[l] == nums[l-1] && r < len(nums)-1 && nums[r] == nums[r+1] {

				} else {
					res = append(res, []int{nums[i], nums[l], nums[r]})

				}
				r--
				l++
			} else if nums[l]+nums[r]+nums[i] < 0 {
				l++
			} else if nums[l]+nums[r]+nums[i] > 0 {
				r--
			}
		}
	}
	return res
}
