package main

/*
82. 删除排序链表中的重复元素 II
存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。

返回同样按升序排列的结果链表。



示例 1：


输入：head = [1,2,3,3,4,4,5]
输出：[1,2,5]
示例 2：


输入：head = [1,1,1,2,3]
输出：[2,3]


提示：

链表中节点数目在范围 [0, 300] 内
-100 <= Node.val <= 100
题目数据保证链表已经按升序排列

*/

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteDuplicates(head *ListNode) *ListNode {
	dummy := &ListNode{Val: 0, Next: nil}
	p := head
	pre := dummy
	cur := 0
	if head == nil {
		return nil
	}
	if head.Next == nil {
		return head
	}
	for p != nil && p.Next != nil {
		if p.Val == p.Next.Val {
			cur = p.Val
			pre.Next = p.Next.Next
			p = p.Next.Next
		} else if cur == p.Val {
			pre.Next = p.Next
			p = p.Next
		} else {
			pre.Next = p
			pre = p
			p = p.Next

		}

	}
	return dummy.Next
}

func main() {
	//f:=ListNode{Val: 5}
	//e:=ListNode{Val: 5,Next: &f}
	//d:=ListNode{Val: 4,Next: &e}
	//c:=ListNode{Val: 2,Next: &d}
	b := ListNode{Val: 1}
	a := ListNode{Val: 1, Next: &b}
	t := ListNode{Val: 1, Next: &a}
	deleteDuplicates(&t)
}
