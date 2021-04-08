package main

/*

90. 子集 II
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。



示例 1：

输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
示例 2：

输入：nums = [0]
输出：[[],[0]]


提示：

1 <= nums.length <= 10
-10 <= nums[i] <= 10
*/

// 看起来似乎是字典树。
func subsetsWithDup(nums []int) [][]int {
	tree := make([][]int, 22)
	color := make([]bool, 464)
	tag := 0
	for i := range tree {
		tree[i] = make([]int, 22)
	}
	for j := 0; j < len(nums); j++ {
		count := 0
		for i := range nums {
			if tree[count][nums[i]+11] == 0 {
				tree[count][nums[i]+11] = tag
				tag++
			}
			count = tree[count][nums[i]+11]
		}
		color[count] = true
	}

	res := make([][]int, 0)

	for i := range color {
		cur := make([]int, 0)
		if color[i] {

			for k >= 0 {
				cur = append(cur, tree[j][k])
			}
		}
		res = append(res, cur)

	}

	return res
}

func subsetsWithDup1(nums []int) [][]int {
	res

	return res
}

func main() {
	subsetsWithDup([]int{1, 2, 2})
}
