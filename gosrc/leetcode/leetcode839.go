package main

type unionFind struct {
	par    []int
	curNum int
}

// 并查集的初始化方法， 创建一个大小为n的并查集
func _init_(n int) *unionFind {
	x1 := new(unionFind)
	x1.par = make([]int, n)
	for i := range x1.par {
		x1.par[i] = i
	}
	x1.curNum = n
	return x1
}

//在并查集中查找
func (f *unionFind) find(x int) int {
	if x != f.par[x] {
		f.par[x] = f.find(f.par[x])
	}
	return f.par[x]
}

// 区域合并
func (f *unionFind) union(x, y int) {
	px,py  := f.find(x),f.find(y)
	if px == py {
		return
	}
	f.par[px] = py
	f.curNum -= 1
}

// 返回区域大小
func (f *unionFind) curSize() int {
	return f.curNum
}
func numSimilarGroups(strs []string) int {
	lens := len(strs)

	simJudge := func(str1, str2 string) (is bool) {
		is = false
		count := 0
		for i := 0; i < len(str1); i++ {
			if str1[i] != str2[i] {
				count++
			}
		}
		if count<= 2 {
			is = true
		}
		return
	}

	unionf := _init_(lens)

	for i := 0; i < lens; i++ {
		for j := i + 1; j < lens; j++ {
			if simJudge(strs[i], strs[j]) {
				unionf.union(i, j)
			}
		}
	}
	return unionf.curSize()
}

func main() {
	print(numSimilarGroups([]string{"tars", "rats", "arts", "star"}))
}

