package main

import "strings"

// 395. 至少有 K 个重复字符的最长子串
func longestSubstring(s string, k int) int {
	if len(s) < k {
		return 0
	}
	count := make(map[rune]int)

	for i := 0; i < len(s); i++ {
		count[rune(s[i])]++
	}

	for key, v := range count {
		if v < k {
			res := 0
			for _, value := range strings.Split(s, string(key)) {
				max := func(a, b int) int {
					if a > b {
						return a
					}
					return b
				}
				//  分治法，对子串继续进行相同的判断，尽可能的选比较大的串
				res = max(res, longestSubstring(value, k))
			}
			return res
		}
	}
	return len(s)
}
