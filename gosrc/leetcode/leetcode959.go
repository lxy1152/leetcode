package main

// 将每个1x1的格子按对角线分成四个区域，标记0.1.2.3
//
//	| \0 / |
//	|3 \/ 1|
//	|  /\  |
//	| /2 \ |
//
// n 为正方形格子的边长
type UnionFind struct {
	par    []int
	N      int
	curNum int
}

// 为每个格子赋初值，标志他属于哪一个集合， 因为我们每个格子分四个区域，所以并查集的大小为四倍。
func _init(n int) *UnionFind {
	f := UnionFind{}
	//
	f.par = make([]int, n*n*4)
	for i := 0; i < n*n*4; i++ {
		f.par[i] = i
	}
	f.N = n
	f.curNum = n * n * 4
	return &f

}

func regionsBySlashes(grid []string) int {
	n := len(grid)
	f := _init(n)
	for row, items := range grid {
		for line, item := range items {
			//当大于第一行的时候，后一行的格子的0区域可以和上一行格子的2区域联通
			if row > 0 {
				f.union(f.position(row-1, line, 2), f.position(row, line, 0))
			}
			//当大于第一列的时候，后一列的格子的3区域可以和上一列格子的1区域联通
			if line > 0 {
				f.union(f.position(row, line-1, 1), f.position(row, line, 3))
			}
			//当不等于 / (空或'\')，自身的0和1 2和3 区域可以联通
			if rune(item) != '/' {
				f.union(f.position(row, line, 0), f.position(row, line, 1))
				f.union(f.position(row, line, 2), f.position(row, line, 3))
			}
			//当不等于 \ (空或'/')，自身的0和3 1和2 区域可以联通
			if rune(item) != '\\' {
				f.union(f.position(row, line, 0), f.position(row, line, 3))
				f.union(f.position(row, line, 1), f.position(row, line, 2))
			}

		}
	}
	return f.curNum
}

// 并查集的查的模板一定要记住，不能漏掉赋值。
func (f *UnionFind) find(i int) int {
	if f.par[i] != i {
		f.par[i] = f.find(f.par[i])
	}
	return f.par[i]
}

func (f *UnionFind) union(i, j int) {
	i1 := f.find(i)
	j1 := f.find(j)
	if i1 == j1 {
		return
	}
	f.par[i1] = j1
	f.curNum -= 1
}
func (f *UnionFind) position(row, line, i int) int {
	return (row*f.N+line)*4 + i

}

func main() {
	print(regionsBySlashes([]string{"/\\", "\\/"}))
}
