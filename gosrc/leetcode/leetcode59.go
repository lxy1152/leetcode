package main

/*
59. 螺旋矩阵 II
给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。



示例 1：


输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
示例 2：

输入：n = 1
输出：[[1]]


提示：

1 <= n <= 20

*/
/*
 和昨天的题简直一模一样， 就是按顺序遍历数组就完事啦

*/
func generateMatrix(n int) [][]int {
	res := make([][]int, n)
	a := 0
	b := 0
	count := 1
	for i := 0; i < n; i++ {
		res[i] = make([]int, n)
	}
	for {
		i := a
		j := b
		for ; i < n-a; i++ {
			res[j][i] = count
			count++
		}
		i--
		j++
		if count == n*n+1 {
			break
		}
		for ; j < n-b; j++ {
			res[j][i] = count
			count++
		}
		j--
		i--
		if count == n*n+1 {
			break
		}
		for ; i >= a; i-- {
			res[j][i] = count
			count++
		}
		i++
		j--
		if count == n*n+1 {
			break
		}
		for ; j > b; j-- {
			res[j][i] = count
			count++
		}
		if count == n*n+1 {
			break
		}
		a++
		b++
	}

	return res
}

func main() {
	generateMatrix(1)
}
