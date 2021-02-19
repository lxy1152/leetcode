package main

// 1004. 最大连续1的个数 III
//

func longestOnes(A []int, K int) int {
	leng := len(A)
	res, left := 0, 0
	for i := 0; i < leng; i++ {
		if A[i] == 0 {
			K--
		}
		// 注意这个地方，只要K 的取值小于0 就代表 超出了可变化的， 需要将left移动，如果移动完之后还是0的话K就++ 说明之前在这个位置上变动过， 现在解除变动。
		for K < 0 {
			if A[left] == 0 {
				K++
			}
			left++
		}
		res = max8(res, i-left+1)

	}
	return res
}

func max8(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func main() {
	print(longestOnes([]int{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3))
}
