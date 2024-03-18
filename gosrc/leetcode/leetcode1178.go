package main

// 1178. 猜字谜
import "math/bits"

func findNumOfValidWords(words []string, puzzles []string) []int {
	const puzzleLength = 7
	cnt := map[int]int{}
	for _, s := range words {
		mask := 0
		// 二进制位存储 或运算进行计算
		for _, ch := range s {
			mask |= 1 << (ch - 'a')
		}
		// 如果mask 中 1 的数量小于谜题说明可以找到谜底
		if bits.OnesCount(uint(mask)) <= puzzleLength {
			cnt[mask]++
		}
	}

	ans := make([]int, len(puzzles))
	for i, s := range puzzles {
		first := 1 << (s[0] - 'a')

		// 枚举子集方法二
		mask := 0
		for _, ch := range s[1:] {
			mask |= 1 << (ch - 'a')
		}
		subset := mask
		for {
			//如果 subset + first 能够在cnt中找到的话， 说明以谜底找到了
			ans[i] += cnt[subset|first]
			// 枚举二进制子集
			subset = (subset - 1) & mask
			if subset == mask {
				break
			}
		}
	}
	return ans
}
