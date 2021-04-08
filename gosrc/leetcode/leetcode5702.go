package main

// 5702. 找出星型图的中心节点

func findCenter(edges [][]int) int {

	x := make([]int, 100001)
	res := 0
	for i := range edges {
		x[edges[i][0]]++
		x[edges[i][1]]++
		res = max(res, edges[i][0], edges[i][1], x)
	}

	return res
}
func max(res, a, b int, arr []int) int {
	res1 := 0
	if arr[a] > arr[b] {
		res1 = a
	} else {
		res1 = b
	}
	if arr[res] < arr[res1] {
		res = res1
	}
	return res
}
