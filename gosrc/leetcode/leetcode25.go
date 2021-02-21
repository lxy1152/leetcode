package main

// 25. K 个一组翻转链表
type ListNode struct {
	Val  int
	Next *ListNode
}

func reverse(node *ListNode, k int) (res *ListNode) {
	if k == 1 {
		return node
	}
	res = reverse(node.Next, k-1)
	node.Next.Next = node
	node.Next = nil
	return res
}
func reverseKGroup(head *ListNode, k int) *ListNode {
	count := 0
	p := head
	for p != nil && count < k {
		count++
		p = p.Next
	}
	if count < k {
		return head
	}
	newHead := reverse(head, k)
	head.Next = reverseKGroup(p, k)
	return newHead
}
