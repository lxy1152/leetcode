package main

/*
*
167. 两数之和 II - 输入有序数组
中等
相关标签
相关企业
给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。

以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。

你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。

你所设计的解决方案必须只使用常量级的额外空间。

示例 1：

输入：numbers = [2,7,11,15], target = 9
输出：[1,2]
解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
示例 2：

输入：numbers = [2,3,4], target = 6
输出：[1,3]
解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
示例 3：

输入：numbers = [-1,0], target = -1
输出：[1,2]
解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。

提示：

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers 按 非递减顺序 排列
-1000 <= target <= 1000
仅存在一个有效答案
*/
func twoSum(numbers []int, target int) []int {
	for i := 0; i < len(numbers); i++ {
		num := target - numbers[i]
		// 这里le 应该是 从 当前 的下一位开始数， 因为如果刚好又等于本身的话就会有可能选到自己
		le, ri := i+1, len(numbers)-1
		for le <= ri {
			mid := (le + ri) / 2
			if numbers[mid] == num {
				return []int{i + 1, mid + 1}
			}
			if numbers[mid] > num {
				ri = mid - 1
			} else {
				le = mid + 1
			}
		}
	}
	return []int{0, 0}
}
func main() {
	twoSum([]int{5, 25, 75}, 100)
}
