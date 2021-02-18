package main

//  995. K 连续位的最小翻转次数

// 位置 ii 现在的状态，和它被前面 K - 1个元素翻转的次数（奇偶性）有关。
// 我们使用队列模拟滑动窗口，该滑动窗口的含义是前面 K - 1 个元素中，以哪些位置起始的 子区间 进行了翻转。该滑动窗口从左向右滑动，
//如果当前位置 ii 需要翻转，则把该位置存储到队列中。遍历到新位置 j (j < i + K)j(j<i+K) 时，
//队列中元素的个数代表了 ii 被前面 K - 1 个元素翻转的次数。
//
//当 A[i]A[i] 为 0，如果 ii 位置被翻转了偶数次，那么翻转后仍是 0，当前元素需要翻转；
//当 A[i]A[i] 为 1，如果 ii 位置被翻转了奇数次，那么翻转后变成 0，当前元素需要翻转。
//综合上面两点，我们得到一个结论，如果 len(arr) % 2 == A[i] 时，当前元素需要翻转。
//
//当 i + K > Ni+K>N 时，说明需要翻转大小为 K 的子区间，但是后面剩余的元素不到 K 个了，所以返回 -1。

func minKBitFlips(A []int, K int) int {
	leng := len(A)
	// 双端队列模拟滑动窗口
	arr := make([]int, 0)
	res := 0
	for i, _ := range A {
		// 如果
		if len(arr) > 0 && i >= arr[0]+K {
			arr = arr[1:]
		}
		if len(arr)%2 == A[i] {
			if i+K > leng {
				return -1
			}
			arr = append(arr, i)
			res++
		}

	}
	return res

}

func main() {
	print(minKBitFlips([]int{0, 1, 1}, 2))
}
