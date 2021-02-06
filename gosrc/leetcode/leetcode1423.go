package main

// 可以遍历出所有的情况， 比如取三个 可以从前取0 后取3 前取1 后取2 前取2后取1  前取3 后取1 这些是很容易进行遍历的
func maxScore(cardPoints []int, k int) int {
	leng := len(cardPoints)

	res := 0
	preSum := make([]int, leng+1)
	sum, cur := 0, 0
	for index, foo := range cardPoints {
		sum += foo
		preSum[index+1] = sum

	}
	if k > leng {
		return sum
	}

	for i := 0; i <= k; i++ {
		cur = preSum[leng-(k-i)] - preSum[i]
		res = max3(sum-cur, res)

	}

	return res
}

// 滑动窗口 只需要让滑动窗口内的数字之和最小，那么取出的自然就是最大了
func maxScore1(cardPoints []int, k int) int {
	leng := len(cardPoints)

	sum, cur := 0, 0
	for index, foo := range cardPoints {
		sum += foo
		if index < leng-k {
			cur = sum
		}
	}
	res := sum - cur
	if k > leng {
		return sum
	}

	for i := leng - k; i < leng; i++ {
		cur = cur - cardPoints[i-leng+k] + cardPoints[i]
		res = max3(res, sum-cur)
	}

	return res
}

func max3(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func main() {
	print(maxScore1([]int{100, 40, 17, 9, 73, 75}, 3))
}
