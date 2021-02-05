package main

func equalSubstring(s string, t string, maxCost int) int {
	lenth := len(s)
	left := 0
	res := 0
	cost := 0

	for i := 0; i < lenth; i++ {
		cost += sub1(int(s[i]), int(t[i]))
		if cost > maxCost {
			cost -= sub1(int(s[left]), int(t[left]))
			left++
		}
		res = max2(res, i-left+1)
	}

	return res
}

func sub1(a, b int) int {
	if a > b {
		return a - b
	} else {
		return b - a
	}
}
func max2(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}

}

func main() {
	print(equalSubstring("ab", "ba", 1))
}
