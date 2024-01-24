package main

/*
48. 旋转图像
中等
1.5K
相关企业
给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。



示例 1：


输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[[7,4,1],[8,5,2],[9,6,3]]
示例 2：


输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]


提示：

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000

*/

func rotate(matrix [][]int) {
	lena := len(matrix)
	le := 0
	if lena%2 == 0 {
		le = lena / 2
	} else {
		le = lena/2 + 1
	}
	// 简单模拟 可以在脑子里想一下3-5 阶的都是怎么变化的 ，首先要覆盖半数的行 另外一半靠赋值
	// 并且逐行遍历的上限是依赖 j 这个变量 (否则无法向里缩圈)
	for j := 0; j < le; j++ {
		for i := j; i < lena-j-1; i++ {
			temp1 := matrix[i][lena-1-j]
			matrix[i][lena-1-j] = matrix[j][i]
			temp2 := matrix[lena-1-j][lena-1-i]
			matrix[lena-1-j][lena-1-i] = temp1
			temp1 = matrix[lena-i-1][j]
			matrix[lena-i-1][j] = temp2
			matrix[j][i] = temp1
		}
	}
}
