package main

// leetcode 896
func isMonotonic(A []int) bool {
	compare := func(A []int) int {
		if A[0] > A[len(A)-1] {
			return 0
		}
		return len(A) - 1
	}
	start := compare(A)
	if start != 0 {
		for i := start; i > 0; i-- {
			if A[i]-A[i-1] < 0 {
				return false
			}
		}
	} else {
		for i := start; i < len(A)-1; i++ {
			if A[i]-A[i+1] < 0 {
				return false
			}
		}
	}
	return true
}

func main() {
	print(isMonotonic([]int{1, 3, 2}))
}
