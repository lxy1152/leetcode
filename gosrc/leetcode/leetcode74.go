package main

/*
74. 搜索二维矩阵
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。


示例 1：


输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
输出：true
示例 2：


输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
输出：false


提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
*/

// 初看觉得是二分查找的 二维形式。
func searchMatrix(matrix [][]int, target int) bool {
	m, n := len(matrix), len(matrix[0])
	i := 0
	j := m * n
	for i < j {
		mid := int(uint(j+i) >> 1)
		if matrix[mid/n][mid%n] < target {
			i = mid + 1
		} else {
			j = mid
		}
	}
	return i < m*n && matrix[i/n][i%n] == target

}
