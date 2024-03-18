package main

//  10. 正则表达式匹配

/*
10. 正则表达式匹配
给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
*/
func isMatch(s string, p string) bool {
	a := len(s)
	b := len(p)
	res := make([][]bool, a+1)
	for i := 0; i <= a; i++ {
		res[i] = make([]bool, b+1)
	}
	res[0][0] = true
	// 动态规划的思想，
	// 如果 p串为空船则不用判断， 所以j从1 开始
	for i := 0; i <= a; i++ {
		for j := 1; j <= b; j++ {
			if p[j-1] == '*' {
				// s[1……i] = p[1……j] 若  s[1……i] = p[1……j-2]相等， 则 x*可以取0次
				res[i][j] = res[i][j-2]
				if match(i, j-1, s, p) {
					// 代表 s[1……i-1] 和p[1……j] 已经匹配， 我们只需要再确定 s[i]和p[j]可以匹配即可在后面进行追加。
					// 这就是为* 需要判断的两种情况。
					res[i][j] = (res[i][j] || res[i-1][j])
				}
			} else {
				if match(i, j, s, p) {
					res[i][j] = res[i-1][j-1]
				}
			}
		}

	}
	return res[a][b]
}

func match(i, j int, s, p string) bool {
	if i == 0 {
		return false
	}
	if p[j-1] == '.' {
		return true
	}
	return s[i-1] == p[j-1]
}

func main() {
	print(isMatch("mississippi", "mis*is*p*."))

}
