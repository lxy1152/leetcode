package main

import "strings"

func calculate2(s string) int {
	stack := make([]int, 0)

	res := 0
	// 利用初始状态保存第一位数字， 因为题目给出了所有整数都是非负整数，
	pre_flag := '+'
	s = strings.Replace(s, " ", "", -1)

	for i := range s {
		if !strings.Contains("-+*/", string(s[i])) {
			res *= 10
			res += int(s[i] - '0')
		}
		if (strings.Contains("-+*/", string(s[i]))) || (i == len(s)-1) {
			switch pre_flag {
			case '+':
				{
					stack = append(stack, res*1)
					res = 0
					break
				}
			case '-':
				{
					stack = append(stack, res*-1)
					res = 0
					break

				}
			case '*':
				{
					temp := stack[len(stack)-1]
					stack = stack[:len(stack)-1]
					stack = append(stack, temp*res)
					res = 0
					break

				}
			case '/':
				{
					temp := stack[len(stack)-1]
					stack = stack[:len(stack)-1]
					stack = append(stack, temp/res)
					res = 0
					break

				}

			}
			pre_flag = rune(s[i])
			res = 0
		}

	}
	sum := func(a []int) (res int) {
		for _, i := range a {
			res += i
		}
		return
	}
	return sum(stack)
}

func main() {
	print(calculate2("0-2147483647"))
}
