package main

//  766. 托普利茨矩阵
//     感觉思路是对的 但是边界有问题， 待优化
func isToeplitzMatrix(matrix [][]int) bool {
	lena := len(matrix)
	lenb := len(matrix[0])
	arr := make([]int, 0)
	if lena == 1 || lenb == 1 {
		return true
	}

	for t := 0; t < min2(lena, lenb); t++ {
		i, j := lena-1, t
		count := t
		for i >= t {
			if j == 0 {
				arr = append(arr, matrix[i][j])
			} else {
				if count < len(arr) && matrix[i][j] != arr[count] && !(i == 0 && j == lenb-1) {
					return false
				} else {
					if !(i == 0 && j == lenb-1) && matrix[i][j] != arr[count] {
						count++

					}
				}
			}
			i -= 1
		}
		if i < lena-1 {
			i = i + 1
		}
		if j < lenb-1 {
			j = j + 1
		}
		for j <= lenb-1 {
			if i == 0 {
				arr = append(arr, matrix[i][j])

			} else {
				if count < len(arr) && matrix[i][j] != arr[count] && !(i == 0 && j == lenb-1) {
					return false
				} else {
					if !(j == lenb-1 && i == 0) && matrix[i][j] != arr[count] {
						count++
					}
				}
			}
			if i == 0 && j == lenb-1 {
				count--
			}
			j += 1
		}
	}
	return true

}

// 简简单单……
func isToeplitzMatrix1(matrix [][]int) bool {
	lena := len(matrix)
	lenb := len(matrix[0])
	if lena == 1 || lenb == 1 {
		return true
	}
	for i := 0; i < lena; i++ {
		for j := 0; j < lenb; j++ {
			if i < lena-1 && j < lenb-1 && matrix[i][j] != matrix[i+1][j+1] {
				return false
			}
		}
	}

	return true

}
func min2(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func main() {
	print(isToeplitzMatrix([][]int{{57, 54}, {84, 57}}))
}
