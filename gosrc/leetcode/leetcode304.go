package main

import "fmt"

// 304. 二维区域和检索 - 矩阵不可变
/*
 实际上就是把一维的前缀和编程了好几个一维前缀和相加的形式，大体上还是和一维前缀和保持一致的。

*/
type NumMatrix struct {
	numsS [][]int
}

func constructor1(matrix [][]int) NumMatrix {
	nums := make([][]int, len(matrix))
	for i := 0; i < len(matrix); i++ {
		nums[i] = make([]int, len(matrix[i])+1)
		nums[i][0] = 0
		for j := 1; j <= len(matrix[i]); j++ {
			nums[i][j] = nums[i][j-1] + matrix[i][j-1]
		}
	}
	return NumMatrix{numsS: nums}
}

func (this *NumMatrix) SumRegion(row1 int, col1 int, row2 int, col2 int) int {
	sum := 0
	for row1 <= row2 {
		sum += this.numsS[row1][col2+1] - this.numsS[row1][col1]
		row1++
	}
	return sum
}

func main() {
	i := constructor1([][]int{{3, 0, 1, 4, 2},
		{5, 6, 3, 2, 1},
		{1, 2, 0, 1, 5},
		{4, 1, 0, 1, 7},
		{1, 0, 3, 0, 5},
	})
	for _, v1 := range i.numsS {
		for k, j := range v1 {

			if k == 5 {
				fmt.Printf("%d %s", j, "\n")
			} else {
				fmt.Printf("%d ", j)
			}
		}
	}
	print(i.SumRegion(1, 2, 2, 4))
}
