package main

// 94. 二叉树的中序遍历
func inorderTraversal(root *TreeNode) []int {
	res := make([]int, 0)
	var deal func(root *TreeNode)
	deal = func(root *TreeNode) {
		if root == nil {
			return
		}
		deal(root.Left)
		res = append(res, root.Val)
		deal(root.Right)

	}
	deal(root)

	return res

}
