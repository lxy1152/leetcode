package main

type UnionFind struct {
	par    []int
	curNum int
}

func regionsBySlashes(grid []string) int {
	n := len(grid)
	for row := range grid {
		for j := range grid[row] {

		}

	}
}

// 并查集的查，
func (f *UnionFind) find(i int) int {
	if f.par[i] != i {
		f.find(f.par[i])
	}
	return f.par[i]
}

func (f *UnionFind) union(i, j int) {
	i1, j1 := f.find(i), f.find(j)
	if i1 == j1 {
		return
	} else {
		f.par[i1] = j1
		f.curNum--
	}
}
func (f *UnionFind) position() int {

}
