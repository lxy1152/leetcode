package main

import (
	"strings"
)

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

func romanToInt1(s string) int {
	hash := make(map[string]int)
	hash["IV"] = 4
	hash["IX"] = 9
	hash["XL"] = 40
	hash["XC"] = 90
	hash["CD"] = 400
	hash["CM"] = 900
	hash["I"] = 1
	hash["V"] = 5
	hash["X"] = 10
	hash["L"] = 50
	hash["C"] = 100
	hash["D"] = 500
	hash["M"] = 1000
	res := 0
	for i := 0; i < len(s); i++ {
		if (s[i] == 'I' || s[i] == 'X' || s[i] == 'C') && i < len(s)-1 {
			buffer := strings.Builder{}
			buffer.WriteString(string(s[i]))
			buffer.WriteString(string(s[i+1]))

			if x, exist := hash[buffer.String()]; exist {
				res += x
				i++
				continue
			}
		} else {
			res += hash[string(s[i])]
		}
	}
	return res
}
func main() {
	romanToInt1("LVIII")
}
