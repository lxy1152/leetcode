package main

/**
14. 最长公共前缀
已解答
简单
相关标签
相关企业
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

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成
*/

func longestCommonPrefix1(strs []string) string {
	res := strs[0]
	for i := 1; i < len(strs); i++ {
		leng := 0
		for j := 0; j < len(res) && j < len(strs[i]); j++ {
			// 相等时 ++ 不等时应该退出 否则如果后一位又对上了还会继续 ++
			if res[j] == strs[i][j] {
				leng++
			} else {
				break
			}
		}
		if leng == 0 {
			return ""
		}
		res = res[:leng]
	}
	return res
}
