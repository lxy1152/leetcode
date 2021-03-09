package main

import "strings"

//  1047. 删除字符串中的所有相邻重复项

//  栈的考察
func removeDuplicates(S string) string {
	stack := make([]string, 0)
	for i := range S {
		stack = append(stack, string(S[i]))
		for len(stack) > 1 && stack[len(stack)-1] == stack[len(stack)-2] {
			stack = stack[:len(stack)-2]
		}
	}
	return strings.Join(stack, "")
}
func main() {
	removeDuplicates("abbaca")
}
