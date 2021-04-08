package main

/*
83. 删除排序链表中的重复元素
存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。

返回同样按升序排列的结果链表。



示例 1：


输入：head = [1,1,2]
输出：[1,2]
示例 2：


输入：head = [1,1,2,3,3]
输出：[1,2,3]


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

	if head == nil {
		return nil
	}

	cur := &ListNode{
		-101, nil,
	}
	next := head

	for next != nil {
		if cur.Val == next.Val {
			cur.Next = next.Next
			next = next.Next
		} else {
			// 之前因为没加else 所以对于重复的多位数字没办法正常的进行计算，
			// 因为没有考虑到其实在进行前面if的裁剪之后，实际上当前还是需要继续和下一个进行比较的。 如果直接赋值到next会出问题。
			cur = next
			next = next.Next
		}

	}

	return head

}

func main() {
	b := ListNode{Val: 2}
	a := ListNode{Val: 1, Next: &b}

}
