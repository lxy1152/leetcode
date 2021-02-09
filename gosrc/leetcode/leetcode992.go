package main

// 优秀题解 https://leetcode-cn.com/problems/subarrays-with-k-different-integers/solution/cong-zui-jian-dan-de-wen-ti-yi-bu-bu-tuo-7f4v/

// 992. K 个不同整数的子数组

func subarraysWithKDistinct(A []int, K int) int {
	// 由 K-（K-1） 这种思想可以轻松的解决这个hard 题。
	return doDeal(A, K) - doDeal(A, K-1)
}

// 一个滑动窗口的模板。 将筛选最长子数组改为筛选 K个不同整数组成的子数组的个数。
/*
对于题目的例子：对于 A = [1,2,1,2,3], K = 2，我们运行上面的代码过程中，会得到的两个满足题意的子数组 [1, 2, 1, 2]和[2, 3]。

对于子数组[1, 2, 1, 2]，它的所有子数组都是满足题意的，共有 1 + 2 + 3 + 4 = 10 个子数组。

以第一个 1 为右端点的满足题意的子数组为 [1];
以第一个 2 为右端点的满足题意的子数组为 [1,2], [2];
以第二个 1 为右端点的满足题意的子数组为 [1,2,1],[2,1], [1];
以第二个 2 为右端点的满足题意的子数组为 [1,2,1,2], [2,1,2],[1,2], [2];
对于子数组[2, 3]，它的所有子数组都满足题意，共有 3 个子数组。

以 2 为右端点的满足题意的子数组，在上面已经统计过了，因此不要重复统计。
以 3 为右端点的满足题意的子数组为[2, 3], [3]。
所以 res = right -left +1 +res
*/
func doDeal(A []int, K int) int {
	left, right := 0, 0
	leng := len(A)
	record := make([]int, 20001)
	distinct := 0
	res := 0
	for right < leng {
		if record[A[right]] == 0 {
			distinct++
		}
		record[A[right]]++
		for distinct > K {
			record[A[left]]--
			if record[A[left]] == 0 {
				distinct--
			}
			left++
		}
		res += right - left + 1
		right++
	}

	return res
}
