package main

func characterReplacement(s string, k int) int {
	res := 0
	var c rune
	// 因为只有26个字符，所以我们可以对每个字符进行一遍遍历，统计每个字符最大长度，然后比较
	for c = 'A'; c <= 'Z'; c++ {
		i, j, cnt := 0, 0, 0
		// 对于每一次遍历来说，如果当前字符等于遍历字符，则加加，如果不等于则判断可更改的字符数是否超过限度，如果不超过则继续
		// 如果超过了则移动左边指针 如果左边指针对应的字符是遍历字符，则数量--，
		for ; i < len(s); i++ {
			if rune(s[i]) == c {
				cnt++
			}
			for i-j+1-cnt > k {
				if rune(s[j]) == c {
					cnt--
				}
				j++
			}
			// 每次遍历的结果与之前做比较
			res = max(res, i-j+1)
		}
	}

	return res
}
func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
