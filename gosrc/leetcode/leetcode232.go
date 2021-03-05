package main

import "fmt"

type MyQueue struct {
	stack1 []int
	stack2 []int
}

// 232. 用栈实现队列
// 刚开始想到的是在push的时候就进行调换，但是这样时间复杂度很高，所以不如只在制定一个输入栈 一个输出栈， 如果 输出栈不为空， 就从输出栈输出， 如果输出栈空了， 就从输入栈里拿值。

/** Initialize your data structure here. */
func Constructor2() MyQueue {
	return MyQueue{
		stack1: make([]int, 0),
		stack2: make([]int, 0),
	}
}

/** Push element x to the back of queue. */
func (this *MyQueue) Push(x int) {
	this.stack1 = append([]int{x}, this.stack1...)

}

/** Removes the element from in front of queue and returns that element. */
func (this *MyQueue) Pop() (res int) {
	if len(this.stack2) > 0 {
		res = this.stack2[0]
		this.stack2 = this.stack2[1:]
	} else {
		for len(this.stack1) > 0 {
			this.stack2 = append([]int{this.stack1[0]}, this.stack2...)
			this.stack1 = this.stack1[1:]
		}
		res = this.stack2[0]
		this.stack2 = this.stack2[1:]
	}
	return
}

/** Get the front element. */
func (this *MyQueue) Peek() (res int) {
	if len(this.stack2) > 0 {
		res = this.stack2[0]
	} else {
		for len(this.stack1) > 0 {
			this.stack2 = append([]int{this.stack1[0]}, this.stack2...)
			this.stack1 = this.stack1[1:]
		}
		res = this.stack2[0]
	}
	return

}

/** Returns whether the queue is empty. */
func (this *MyQueue) Empty() bool {
	return len(this.stack1) == 0 && len(this.stack2) == 0
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Peek();
 * param_4 := obj.Empty();
 */

func main() {
	my := Constructor2()
	my.Push(1)
	my.Push(2)
	my.Push(3)
	my.Push(4)
	c := my.Pop()
	my.Push(5)
	b := my.Peek()
	fmt.Printf("%d,%d", c, b)
}
