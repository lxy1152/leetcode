package main

import "strings"

func isValidSerialization(preorder string) bool {
	stack := make([]string, 0)

	for _, i := range strings.Split(preorder, ",") {
		stack = append(stack, i)
		for len(stack) >= 3 && stack[len(stack)-1] == stack[len(stack)-2] && stack[len(stack)-2] == "#" && stack[len(stack)-3] != "#" {
			stack = stack[:len(stack)-3]
			stack = append(stack, "#")
		}
	}
	return len(stack) == 1 && stack[len(stack)-1] == "#"
}
