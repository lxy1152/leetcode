package main

import (
	"math"
	"strings"
)

// 8. 字符串转换整数 (atoi)

func myAtoi(s string) int {
	s = strings.TrimLeft(s, " ")
	flag := 1
	var res int64
	if len(s) < 1 {
		return 0
	}
	if s[0] == '-' {
		flag = -1
		s = s[1:]
	} else if s[0] == '+' {
		flag = 1
		s = s[1:]
	} else if s[0] > '9' || s[0] < '0' {
		return 0
	}
	for i := range s {

		if s[i] <= '9' && s[i] >= '0' {
			res *= 10
			res += int64(s[i]-'0') * int64(flag)
		} else {
			break
		}
		if res >= math.MaxInt32 {
			res = math.MaxInt32
			break
		}
		if res <= math.MinInt32 {
			res = math.MinInt32
			break
		}
	}
	return int(res)
}
func main() {
	print(myAtoi("-52"))
}
