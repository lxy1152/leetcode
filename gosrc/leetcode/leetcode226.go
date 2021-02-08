package main

// 226. 翻转二叉树

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func invertTree(root *TreeNode) *TreeNode {
	bianli(root)
	return root
}

func bianli(node *TreeNode) *TreeNode {
	if node == nil {
		return nil
	}
	var left, right *TreeNode
	if node.Left != nil {
		left = bianli(node.Left)
	}
	if node.Right != nil {
		right = bianli(node.Right)
	}
	node.Right, node.Left = left, right
	return node
}
