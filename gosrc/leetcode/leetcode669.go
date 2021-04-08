package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/*
 题目已经提示是一个二叉搜索树， 所以可以直接得出需要中序遍历的结果， 所以我们只需要中序+剪枝 就可以做到了，
 如果 root.Val<low  那么他的左字数一定都小于low 不用去关注了， >high 的情况也同理。
*/
func trimBST(root *TreeNode, low int, high int) *TreeNode {

	return traverse(root, low, high)
}

func traverse(root *TreeNode, low int, high int) *TreeNode {

	if root.Val < low {
		if root.Right != nil {
			root = root.Right
			root = traverse(root, low, high)
		} else {
			root = nil
		}
	} else if root.Val > high {
		if root.Left != nil {
			root = root.Left
			root = traverse(root, low, high)
		} else {
			root = nil
		}
	} else {
		if root.Left != nil {
			root.Left = traverse(root.Left, low, high)
		}
		if root != nil && root.Right != nil {
			root.Right = traverse(root.Right, low, high)
		}
	}
	return root

}

func main() {
	node1 := TreeNode{
		Val: 1,
	}
	node2 := TreeNode{
		Val:  2,
		Left: &node1,
	}
	node0 := TreeNode{
		Val:   0,
		Right: &node2,
	}
	node4 := TreeNode{
		Val: 4,
	}
	node3 := TreeNode{
		Left:  &node0,
		Right: &node4,
		Val:   3,
	}
	x := trimBST(&node3, 1, 3)
	print(x)
}
