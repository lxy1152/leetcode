package main

/**
169. 多数元素
已解答
简单
相关标签
相关企业
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。



示例 1：

输入：nums = [3,2,3]
输出：3
示例 2：

输入：nums = [2,2,1,1,1,2,2]
输出：2


提示：
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109


进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
*/

// 摩尔投票法  之前是这样 ，但是三年过去了 已经忘得差不多了

func majorityElement(nums []int) int {
	//
	cur := nums[0]
	count := 1
	// 扫描整个数组  如果超过半数 则说明 肯定count 大于1/2
	for i := 1; i < len(nums); i++ {
		//  如果count 减到0  则说明需要更换 当前数字了
		if count == 0 {
			cur = nums[i]
		}
		// 是当前数字则++ 不是则--  就算选到错误的也会重新选
		if nums[i] == cur {
			count++
		} else {
			count--
		}

	}
	return cur
}
