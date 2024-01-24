package main

import "sort"

/**
189. 轮转数组
中等
相关标签
相关企业
提示
给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。



示例 1:

输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右轮转 1 步: [7,1,2,3,4,5,6]
向右轮转 2 步: [6,7,1,2,3,4,5]
向右轮转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释:
向右轮转 1 步: [99,-1,-100,3]
向右轮转 2 步: [3,99,-1,-100]


提示：

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105


进阶：

尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
*/
// 1  0(1) 的算法 只能想到模拟了 时间复杂度会很高、

func rotate(nums []int, k int) {
	leng := len(nums)
	if len(nums) == 1 {
		return
	}
	for i := 0; i < k; i++ {
		nums[]
	}
}

// 非  0(1) 的算法  直接用切片拼接
func rotate1(nums []int, k int) {
	leng := len(nums)
	k = k % leng
	if len(nums) == 1 {
		return
	}
	ptrNums := &nums
	copy(*(ptrNums), append(nums[leng-k:], nums[:leng-k]...))
}

// 非  0(1) 的算法  直接用切片拼接
func rotate2(nums []int, k int) {

	revert := func(nums  []int){
		for i := 0; i < len(nums)/2; i++ {
			nums[i],nums[len(nums)-i-1] = nums[len(nums)-i-1],nums[i]
		}
	}
	// 先翻转整个数组
	revert(nums)
	// 然后对前K 个 即 初始的最后K个元素进行翻转  7654 变成 4567
	revert(nums[:k])
	// 然后对 剩余的进行 翻转  321 变成 123
	revert(nums[k:])
}

func main() {
	temp := []int{1, 2, 3, 4, 5, 6, 7}
	rotate1(temp, 3)
}
