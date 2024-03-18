package main

import "sort"

// 解法1 超时！ 在第59个答案时超时  输入数据规模太大， 因为在我们每次遍历b-s>limit的时候都有可能去getNext中寻找。 这个函数包含了一个sort 最快的时间复杂度也是o nlogn 所以时间复杂度很高！
func longestSubarray(nums []int, limit int) int {
	leng := len(nums)
	left, res := 0, 0
	Max := func(a, b int) int {
		if a > b {
			return a
		} else {
			return b
		}

	}
	b, s := 0, 10000000
	arr := make(map[int]int, 1)
	for i := 0; i < leng; i++ {
		if nums[i] > b {
			b = nums[i]
		}
		if nums[i] < s {
			s = nums[i]
		}
		arr[nums[i]]++
		for b-s > limit && left < i {
			arr[nums[left]]--
			if arr[nums[left]] == 0 {
				delete(arr, nums[left])
			}
			if nums[left] == s {
				s = getNext(arr, 1)
			} else {
				b = getNext(arr, 0)
			}
			left++
		}
		res = Max(i-left+1, res)
	}
	return res
}
func getNext(m map[int]int, flag int) int {
	key := []int{}
	for k := range m {
		key = append(key, k)
	}
	sort.Ints(key)
	if flag == 0 {
		return key[len(key)-1]
	} else {
		return key[0]

	}
}

// 在最初并没有想到去除已被删除的元素的很好的方法 例如  42224 或 12221  最初用数组存储的时候没有想过4要怎么进行删除， 其实是很简单的时， 既然读到后面连续两个二了，说明之前的4肯定被淘汰掉， 因为 次小一定是我们第二次加入的2
func longestSubarray1(nums []int, limit int) int {
	leng := len(nums)
	left, res := 0, 0
	Max := func(a, b int) int {
		if a > b {
			return a
		} else {
			return b
		}

	}
	max := make([]int, 1)
	min := make([]int, 1)
	max[0] = 0
	min[0] = 100000000
	for i := 0; i < leng; i++ {

		/*
			在这里 进行了次大或者次小的元素的淘汰，每当遇到一个足够小的就加入，替换掉哪些比较大的。
		*/
		for len(max) > 0 && nums[i] > max[len(max)-1] {
			max = max[:len(max)-1]
		}
		//if len(max)>0&&nums[i]>max[0]{
		//	max=append([]int{nums[i]},max...)
		//}
		max = append(max, nums[i])
		for len(min) > 0 && nums[i] < min[len(min)-1] {
			min = min[:len(min)-1]
		}
		//if len(min)>0&&nums[i]<min[0]{
		//	min=append([]int{nums[i]},min...)
		//
		//}
		min = append(min, nums[i])

		for len(min) > 0 && len(max) > 0 && max[0]-min[0] > limit {
			if nums[left] == max[0] {
				max = max[1:]
			}
			if nums[left] == min[0] {
				min = min[1:]
			}
			left++
		}
		res = Max(i-left+1, res)
	}
	return res
}
func main() {
	print(longestSubarray1([]int{4, 2, 2, 2, 4, 4, 2, 2}, 0))
}
