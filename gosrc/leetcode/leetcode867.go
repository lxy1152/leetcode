package main

// 867. 转置矩阵
func transpose(matrix [][]int) [][]int {
	lena := len(matrix)
	if lena < 0 {
		return [][]int{}
	}
	lenb := len(matrix[0])
	arr := make([][]int, lenb)
	for i := 0; i < lenb; i++ {
		arr[i] = make([]int, lena)
		for j := 0; j < lena; j++ {
			arr[i][j] = 0
		}
	}
	for i := 0; i < lenb; i++ {
		arr[i] = make([]int, lena)
		for j := 0; j < lena; j++ {
			arr[i][j] = matrix[j][i]
		}
	}
	return arr

}
