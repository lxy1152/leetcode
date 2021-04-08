package main

func romanToInt(s string) int {
	a := map[rune]int{'M': 1000, 'D': 500, 'C': 100, 'L': 50, 'X': 10, 'V': 5, 'I': 1}
	res := 0
	for i := 0; i < len(s); i++ {
		switch rune(s[i]) {
		case 'C':
			if i < len(s)-1 && s[i+1] == 'D' {
				res += 400
				i++
			} else if i < len(s)-1 && s[i+1] == 'M' {
				res += 900
				i++
			} else {
				res += 100
			}
		case 'X':
			if i < len(s)-1 && s[i+1] == 'L' {
				res += 40
				i++
			} else if i < len(s)-1 && s[i+1] == 'C' {
				res += 90
				i++
			} else {
				res += 10
			}
		case 'I':
			if i < len(s)-1 && s[i+1] == 'V' {
				res += 4
				i++
			} else if i < len(s)-1 && s[i+1] == 'X' {
				res += 9
				i++
			} else {
				res += 1
			}
		default:
			res += a[rune(s[i])]
		}
	}

	return res
}

func main() {
	romanToInt("LVIII")
}
