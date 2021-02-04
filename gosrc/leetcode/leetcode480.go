package main

import (
	"container/heap"
)

// 在这一节中需要深刻认识到go 语言继承之间的关系， 在第一版的代码中，只是简单的
type intHeap []int

type intminHeap struct {
	intHeap
}
type intmaxHeap struct {
	intHeap
}

//对顶堆的应用。
func (h intHeap) Len() int           { return len(h) }
func (h intHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h intHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
func (h intHeap) Top() int           { return h[0] }
func (h intHeap) Find(n int) int {
	for index, i := range h {
		if i == n {
			return index
		}
	}
	return -1
}
func (h intminHeap) Less(i, j int) bool { return h.intHeap[i] < h.intHeap[j] }
func (h intmaxHeap) Less(i, j int) bool { return h.intHeap[j] < h.intHeap[i] }
func (h *intHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *intHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func medianSlidingWindow(nums []int, k int) []float64 {
	// 初始化一个大根堆一个小根堆，大根堆在左边，小根堆在右边
	left := &intmaxHeap{}
	right := &intminHeap{}

	heap.Init(left)
	heap.Init(right)
	// 如果k 为偶数的话 做特殊处理
	getMedian := func(k int) float64 {
		if k%2 == 1 {
			return float64(right.Top())
		}
		// 第一处坑 要注意转换
		return float64((float64((left.Top() + right.Top())) / 2))
	}
	K := k
	// 先把窗口内的元素都添加到右边的小根堆中
	for i := 0; i < K; i++ {
		//right.Push(nums[i])
		heap.Push(right, nums[i])
	}
	//再从右边的小根堆拿出元素 放到左边的大根堆中
	for i := 0; i < K/2; i++ {
		//left.Push(right.Top())
		//right.Pop()
		heap.Push(left, right.Top())
		heap.Pop(right)

	}
	// 创建结果数组
	res := make([]float64, 0)
	// 进行第一次的分堆并且获取中位数
	res = append(res, getMedian(K))
	// 直接从初始化状态进行下一次的移动滑动窗口
	for i := K; i < len(nums); i++ {
		x, y := nums[i], nums[i-K]
		if x >= right.Top() {
			heap.Push(right, x)
		} else {
			heap.Push(left, nums[i])
		}
		// 如果滑动窗口最左边的数大于右边堆的最小值，则在右边堆中，否则在左边堆中，找到并去除。
		if y >= right.Top() {
			heap.Remove(right, right.Find(y))
		} else {
			heap.Remove(left, left.Find(y))
		}
		// 如果左边堆的大小大于右边大小，则把左边最大移到右边
		for left.Len() > right.Len() {
			heap.Push(right, left.Top())
			heap.Pop(left)
		}
		// 如果右边堆大小大于左边加一，则把右边最小移到左边堆中
		for right.Len() > left.Len()+1 {
			heap.Push(left, right.Top())
			heap.Pop(right)
		}
		// 结果集中添加当前得到的中位数。
		res = append(res, getMedian(K))
	}

	return res
}

func main() {
	print(medianSlidingWindow([]int{1, 4, 2, 3}, 4)[0])
}
