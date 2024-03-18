package main

/*
61. 旋转链表
给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。



示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[4,5,1,2,3]
示例 2：


输入：head = [0,1,2], k = 4
输出：[2,0,1]


提示：

链表中节点的数目在范围 [0, 500] 内
-100 <= Node.val <= 100
0 <= k <= 2 * 109
*/

type ListNode struct {
	Val  int
	Next *ListNode
}

/*
这道题可能是刚好能过leetcode的不太严格的数据， 也可能是因为自己写的代码确实不兼容k刚好等于长度的整数倍；。
*/
func rotateRight(head *ListNode, k int) *ListNode {
	p := head
	count := 1
	if head == nil {
		return nil
	}

	for p.Next != nil {
		p = p.Next
		count++
	}
	if count == 1 || k == 0 || k == count {
		return head
	}
	k %= count
	k = count - k
	pre := head
	cur := head.Next
	for k > 1 {
		pre = cur
		cur = cur.Next
		k--
	}
	pre.Next = nil
	p.Next = head

	return cur
}

func main() {
	//e:=ListNode{Val: 5}
	//d:=ListNode{Val: 4,Next: &e}
	//c:=ListNode{Val: 3,Next: &d}
	b := ListNode{Val: 2}
	a := ListNode{Val: 1, Next: &b}

	rotateRight(&a, 0)
}
