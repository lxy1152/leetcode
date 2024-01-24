package main

func lengthOfLastWord(s string) int {
	res := 0
	for i := len(s) - 1; i >= 0; i-- {
		if res != 0 && s[i] == ' ' {
			return res
		}
		if res == 0 && s[i] == ' ' {
			continue
		} else {
			res++
		}
	}
	return res
}
