package main

// 119. 杨辉三角 II

func getRow(rowIndex int) []int {
	C := make([][]int, rowIndex+1)
	for i := range C {
		C[i] = make([]int, i+1)
		C[i][0], C[i][i] = 1, 1
		for j := 1; j < i; j++ {
			C[i][j] = C[i-1][j-1] + C[i-1][j]
		}
	}
	return C[rowIndex]
}
