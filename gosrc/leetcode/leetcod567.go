package main

// 今天注意到了go语言的值拷贝，
// 目前这种方式肯定还有着很大的优化空间
// 567. 字符串的排列

func checkInclusion(s1 string, s2 string) bool {
	left, right := 0, 0
	lengS := len(s1)
	dict := make(map[rune]int, lengS+1)
	for right < lengS {
		dict[rune(s1[right])] += 1
		right++
	}
	right--
	for right < len(s2) {

		if verify(dict, s2[left:right+1]) {
			return true
		}
		left++
		right++
	}
	return false
}

func verify(m1 map[rune]int, string2 string) bool {
	m2 := map[rune]int{}
	for _, foo := range string2 {
		m2[foo] += 1
	}

	for k, _ := range string2 {
		if m1[rune(string2[k])] != m2[rune(string2[k])] {
			return false
		}
	}

	return true
}

// 优化方法存在问题 待继续修改

func checkInclusion_todo(s1 string, s2 string) bool {
	left, right := 0, 0
	lengS := len(s1)
	dict := make(map[rune]int, lengS+1)
	m2 := map[rune]int{}
	for right < lengS {
		dict[rune(s1[right])] += 1
		m2[rune(s2[right])] += 1
		right++
	}
	if right == lengS && verify1(dict, m2) {
		return true
	}
	// 记录s1 字符串字符的数目
	for right < len(s2) {
		nowl, nowr := s2[left], s2[right]
		m2[rune(nowl)]--
		m2[rune(nowr)]--
		left++
		right++
		if dict[rune(nowl)] == m2[rune(nowl)] && dict[rune(nowr)] == m2[rune(nowr)] && verify1(dict, m2) {
			return true
		}
		m2[rune(s2[right])]++
		m2[rune(s2[left])]++

	}
	return false
}

func verify1(m1, m2 map[rune]int) bool {
	for k, _ := range m1 {
		if m1[k] != m2[k] {
			return false
		}
	}
	return true
}

func main() {
	print(checkInclusion("ab", "bcba"))
}
