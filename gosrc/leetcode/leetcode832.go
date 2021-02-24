package main

// 832. 翻转图像
func flipAndInvertImage(A [][]int) [][]int {
	lena := len(A[0])
	lenb := len(A)
	for j := 0; j < lenb; j++ {
		for i := 0; i < lena/2; i++ {
			tmp := A[j][i] ^ 1
			A[j][i] = A[j][lena-i-1] ^ 1
			A[j][lena-i-1] = tmp
		}
		if lena%2 != 0 {
			A[j][lena/2] ^= 1
		}
	}
	return A
}

func main() {
	flipAndInvertImage([][]int{{1}, {1}})
}
