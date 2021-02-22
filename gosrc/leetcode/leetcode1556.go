package main

import (
	"fmt"
)

func thousandSeparator(n int) string {

	res := ""
	for {
		cur := n % 1000
		n /= 1000
		if n > 0 {
			res = fmt.Sprintf(".%03d", cur) + res
		} else {
			res = fmt.Sprintf("%d", cur) + res
			break
		}
	}

	return res
}

func main() {
	print(thousandSeparator(51040))
}
