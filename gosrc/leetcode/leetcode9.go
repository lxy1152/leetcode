package main

// 9. 回文数
// 一个堆栈存储逆序的x 一边出栈一边比较。
func isPalindrome(x int) bool {
	if x < 0 {
		return false
	}
	a := x
	stack := make([]int, 0)
	for x > 0 {
		stack = append(stack, x%10)
		x /= 10
	}
	i := 0
	for a > 0 && i <= len(stack)/2 {
		if !(stack[len(stack)-1] == a%10) {
			return false
		}
		a /= 10
		stack = stack[:len(stack)-1]
	}
	return true
}

func main() {
	print(isPalindrome(0))
}
