package main

import "strings"

// 224. 基本计算器
func calculate(s string) int {
	s = strings.Trim(s, " ")
	stack := make([]rune, 0)
	count := 0
	res := 0

	for i := range s {
		if s[i] == '(' {
			count++
		}
		if s[i] == ')' && count > 0 {
			cur := 0
			flag := 0
			anothorcur := 0
			for stack[len(stack)-1] != '(' {
				if stack[len(stack)-1] >= '0' && stack[len(stack)-1] <= '9' && flag == 0 {
					cur *= 10
					cur += int(stack[len(stack)-1] - '0')
				} else if stack[len(stack)-1] >= '+' || stack[len(stack)-1] >= '-' || flag != 0 {
					switch stack[len(stack)-1] {
					case '+':
						flag = 1
						break

					case '-':
						flag = -1
						break

					default:
						anothorcur *= 10
						anothorcur += int(stack[len(stack)-1] - '0')
					}

				}
			}
		}
	}
	return res
}

//  喝醉了  偷懒 cv 一下、
func calculate1(s string) (ans int) {
	ops := []int{1}
	sign := 1
	n := len(s)
	for i := 0; i < n; {
		switch s[i] {
		case ' ':
			i++
		case '+':
			sign = ops[len(ops)-1]
			i++
		case '-':
			sign = -ops[len(ops)-1]
			i++
		case '(':
			ops = append(ops, sign)
			i++
		case ')':
			ops = ops[:len(ops)-1]
			i++
		default:
			num := 0
			for ; i < n && '0' <= s[i] && s[i] <= '9'; i++ {
				num = num*10 + int(s[i]-'0')
			}
			ans += sign * num
		}
	}
	return
}
