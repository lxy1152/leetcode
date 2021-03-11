package main

import "strings"

// 224. 基本计算器
func calculate(s string) int {
	s = strings.Replace(s, " ", "", -1)
	stack := make([]int, 0)
	res := 0
	num := 0
	sign := 1
	for i := range s {
		if s[i] >= '0' && s[i] <= '9' {
			num *= 10
			num += int(s[i] - '0')
		} else {
			switch s[i] {
			case '+':
				res += num * sign
				sign = 1
				break
			case '-':
				res += num * sign
				sign = -1
				break
			case '(':
				stack = append(stack, res)
				stack = append(stack, sign)
				res = 0
				sign = 1
				break
			case ')':
				res += sign * num
				res *= stack[len(stack)-1]
				res += stack[len(stack)-2]
				stack = stack[:len(stack)-2]
				break
			}
			num = 0
		}

	}
	res += num * sign

	return res
}

func main() {
	print(calculate(" 30 "))
}
