package main

/*
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。



示例 1：

输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。


提示：

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成



*/

/*
 最朴素的暴力解法

根据题解可以看到 可以采用分治法来进行求解。！ 为啥自己没想到嘞
*/
func longestCommonPrefix1(strs []string) string {
	if len(strs) == 0 {
		return ""
	}
	if len(strs) == 1 {
		return strs[0]
	}
	prefix := getPrefix(strs[0], strs[1])
	for i := 2; i < len(strs); i++ {
		prefix = getPrefix(prefix, strs[i])
	}
	return prefix
}

func getPrefix(a, b string) string {
	la := len(a)
	lb := len(b)
	prefix := ""
	for i := 0; i < la && i < lb; i++ {
		if a[i] == b[i] {
			prefix += string(a[i])
		} else {
			break
		}
	}
	return prefix
}

// 分治解法
func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}
	prefix := strs[0]
	count := len(strs)
	for i := 1; i < count; i++ {
		prefix = lcp(prefix, strs[i])
		if len(prefix) == 0 {
			break
		}
	}
	return prefix
}

func lcp(str1, str2 string) string {
	length := min(len(str1), len(str2))
	index := 0
	for index < length && str1[index] == str2[index] {
		index++
	}
	return str1[:index]
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}

func main() {
	longestCommonPrefix([]string{"ldog", "lracecar", "lcar"})
}
