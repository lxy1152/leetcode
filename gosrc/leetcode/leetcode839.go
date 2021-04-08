package main

/*
839. 相似字符串组
如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。

例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。

总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。

给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？



示例 1：

输入：strs = ["tars","rats","arts","star"]
输出：2
示例 2：

输入：strs = ["omv","ovm"]
输出：1


提示：

1 <= strs.length <= 300
1 <= strs[i].length <= 300
strs[i] 只包含小写字母。
strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。
*/
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
	px, py := f.find(x), f.find(y)
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
		if count <= 2 {
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
