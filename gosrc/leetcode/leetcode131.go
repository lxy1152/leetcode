package main

// 131. 分割回文串
func partition(s string) (ans [][]string) {
	n := len(s)
	f := make([][]bool, n)
	// 二维数组存储 减小判断回文串的代价。
	for i := range f {
		f[i] = make([]bool, n)
		for j := range f[i] {
			f[i][j] = true
		}
	}
	for i := n - 1; i >= 0; i-- {
		for j := i + 1; j < n; j++ {
			f[i][j] = s[i] == s[j] && f[i+1][j-1]
		}
	}

	// 回朔法标准模板。
	splits := []string{}
	var dfs func(int)
	dfs = func(i int) {
		if i == n {
			ans = append(ans, append([]string(nil), splits...))
			return
		}
		for j := i; j < n; j++ {
			// 如果 i到j 是回文串， 则满足便利要求， 否则剪枝
			if f[i][j] {
				splits = append(splits, s[i:j+1])
				dfs(j + 1)
				// 回退遍历之前的操作。
				splits = splits[:len(splits)-1]
			}
		}
	}
	dfs(0)
	return
}
