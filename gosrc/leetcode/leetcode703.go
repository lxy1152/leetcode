package main

import "container/heap"

// 703. 数据流中的第 K 大元素
type intHeap1 []int

func (h intHeap1) Len() int           { return len(h) }
func (h intHeap1) Less(i, j int) bool { return h[i] < h[j] }
func (h intHeap1) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *intHeap1) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h KthLargest) top() int {
	return h.intHeap1[0]
}

func (h *intHeap1) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

type KthLargest struct {
	intHeap1
	k int
}

func Constructor(k int, nums []int) KthLargest {

	Heap := &intHeap1{}
	heap.Init(Heap)
	for _, foo := range nums {
		heap.Push(Heap, foo)
	}

	kthLargest := KthLargest{}
	kthLargest.intHeap1 = *Heap
	kthLargest.k = k
	return kthLargest

}

func (this *KthLargest) Add(val int) int {
	heap.Push(this, val)

	for this.Len() > this.k {
		heap.Pop(this)
	}
	return this.top()
}

func main() {
	i := Constructor(3, []int{4, 5, 8, 2})
	i.Add(1000)
	i.Add(2000)
}
