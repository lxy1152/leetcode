package main

/*
92. 反转链表 II
给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。


示例 1：


输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
示例 2：

输入：head = [5], left = 1, right = 1
输出：[5]


提示：

链表中节点数目为 n
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n


进阶： 你可以使用一趟扫描完成反转吗？
*/
type ListNode struct {
	Val  int
	Next *ListNode
}

// 想通过 反转链表的递归方式结果没有实现
func reverseBetween(head *ListNode, left int, right int) *ListNode {

	if left == right || head.Next == nil {
		return head
	}
	x := &ListNode{
		Val:  -1,
		Next: head,
	}
	count := 0
	p := x
	cur := x
	after := x
	for count < left {
		cur = p
		p = p.Next
		count++
	}
	cur.Next, after = doReserver(cur, right-left+1)
	p = head
	count = 0
	//  如果 left 等于1
	for count < right-1 && left != 1 {
		p = p.Next
		count++
	}
	p.Next = after
	return x.Next
}

func doReserver(head *ListNode, ll int) (*ListNode, *ListNode) {
	var cur *ListNode
	var after *ListNode

	if ll > 0 && head.Next != nil {
		cur, after = doReserver(head.Next, ll-1)
	} else {
		after = head.Next
		return head, after
	}
	head.Next.Next = head
	head.Next = nil
	return cur, after
}

// 十分巧妙的三指针解法。
func reverseBetween1(head *ListNode, left int, right int) *ListNode {
	if left == right || head.Next == nil {
		return head
	}
	x := &ListNode{
		Val:  -1,
		Next: head,
	}
	pre := x
	cur := x.Next
	next := x.Next.Next
	count := 1
	for count < left {
		pre = pre.Next
		cur = cur.Next
		next = next.Next
		count++
	}
	tail := cur
	for left <= right {
		next = cur.Next
		cur.Next = pre.Next
		pre.Next = cur
		tail.Next = next
		cur = next
		left++
	}

	return x.Next

}

func main() {

	b := ListNode{Val: 2}
	a := ListNode{Val: 1, Next: &b}

	reverseBetween(&a, 1, 2)

}
