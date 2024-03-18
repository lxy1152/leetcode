package main

/*
530. 二叉搜索树的最小绝对差
给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。



示例：

输入：

   1
    \
     3
    /
   2

输出：
1

解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
*/

// 这道题可以使用儿二叉搜索树的性质，即 二叉树的左子节点全部小于根节点， 右子节点全部大于根节点，
// 所以和当前节点最近的节点一定是其所有左子节点中最右的那个，或者所有右子节点中最左的那个
// 简单的问题复杂化的经典案例哈哈哈哈哈哈。 明明遍历一遍就好了。
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func getMinimumDifference(root *TreeNode) int {
	a := 10000000
	b := 10000000
	if root.Right != nil {
		a = min(abs(root.Val-root.Right.Val), abs(root.Val-findLeft(root.Right)))
		temp := getMinimumDifference(root.Right)
		a = min(a, temp)
	}
	if root.Left != nil {
		b = min(abs(root.Val-root.Left.Val), abs(root.Val-findRight(root.Left)))
		temp := getMinimumDifference(root.Left)
		b = min(b, temp)
	}
	return min(a, b)

}
func findLeft(root *TreeNode) int {
	val := 0
	if root.Left == nil {
		return root.Val
	}
	val = findLeft(root.Left)
	return val
}
func findRight(root *TreeNode) int {
	val := 0
	if root.Right == nil {
		return root.Val
	}
	val = findRight(root.Right)

	return val
}
func abs(a int) int {
	if a > 0 {
		return a
	}
	return -a
}

func min(a, b int) int {
	if a > b {
		return b
	} else {
		return a
	}
}
func main() {
	a := &TreeNode{4406, nil, nil}
	b := &TreeNode{2917, nil, a}
	c := &TreeNode{1329, nil, b}
	d := &TreeNode{4443, c, nil}
	e := &TreeNode{Val: 2, Right: d}
	print(getMinimumDifference(e))
}
