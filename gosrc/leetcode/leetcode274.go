package main

import "sort"

/*
*
274. H 指数
中等
相关标签
相关企业
提示
给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。

根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次。如果 h 有多种可能的值，h 指数 是其中最大的那个。

示例 1：

输入：citations = [3,0,6,1,5]
输出：3
解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。

	由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。

示例 2：

输入：citations = [1,3,1]
输出：1

提示：

n == citations.length
1 <= n <= 5000
0 <= citations[i] <= 1000
*/

func hIndex(citations []int) int {
	// 先进行排序， 然后进行二分查找，  查找当找到某一篇论文，它的引用数大于等于 index 右侧元素个数之和时， 并且它左侧的引用数小于  右侧元素个数之和时
	sort.Ints(citations)
	l, r := 0, len(citations)-1
	res := 0
	for l < r {
		mid := (l + r) / 2

		if citations[mid] >= len(citations)-mid {
			r = mid
			res = max(len(citations)-mid, res)
		} else {
			l = mid + 1
		}

	}
	return res
}
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func main() {
	print(hIndex([]int{1, 3, 1}))
}
