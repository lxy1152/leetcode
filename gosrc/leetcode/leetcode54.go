package main

/*
54. 螺旋矩阵
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。


*/

// 模拟做一个数组的遍历，我们应该注意到每次遍历的时候，四面的边界都在缩小， 并且左与右 上与下 缩小的幅度相同， 所以我们可以用两个变量来模拟缩小的幅度
func spiralOrder(t [][]int) []int {

	a := len(t)
	b := len(t[0])
	c := 0
	d := 0
	res := make([]int, 0)
	for {
		i := d
		j := c
		for ; i < b-d; i++ {
			res = append(res, t[j][i])
		}
		// 每个判断都是为了提前跳出for 循环，  如果已经成功遍历的话。
		if len(res) == a*b {
			break
		}
		// for 循环 最后多了一个i++  补偿。 下同
		i--
		// 因为当前j i 位置 在之前已经被存储了。 下同
		j++
		for ; j < a-c; j++ {
			res = append(res, t[j][i])
		}
		if len(res) == a*b {
			break
		}
		j--
		i--
		for ; i >= d; i-- {
			res = append(res, t[j][i])
		}
		if len(res) == a*b {
			break
		}
		i++
		j--
		for ; j > c; j-- {
			res = append(res, t[j][i])
		}
		if len(res) == a*b {
			break
		}
		c++
		d++

	}
	return res
}

func main() {
	spiralOrder([][]int{{1}, {2}, {3}, {4}, {5}})
}
