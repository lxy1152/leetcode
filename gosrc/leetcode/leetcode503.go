package main

// 503. 下一个更大元素 II

// 单调栈的应用。
func nextGreaterElements(nums []int) []int {
	leng := len(nums)
	ans := make([]int, leng)
	for i := 0; i < leng; i++ {
		ans[i] = -1
	}
	stack := []int{}
	for i := 0; i < leng*2-1; i++ {
		//
		for len(stack) > 0 && nums[stack[len(stack)-1]] < nums[i%leng] {
			ans[stack[len(stack)-1]] = nums[i%leng]
			stack = stack[:len(stack)-1]

		}
		// 因为在前面已经把比  nums[i%leng] 小的都出栈了，所以目前栈内
		stack = append(stack, i%(leng))

	}
	return ans
}

func main() {

}
