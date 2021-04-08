package main

/*
5713. 字符串中不同整数的数目 显示英文描述
通过的用户数0
尝试过的用户数0
用户总通过次数0
用户总提交次数0
题目难度Easy
给你一个字符串 word ，该字符串由数字和小写英文字母组成。

请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数间至少要用一个空格隔开："123"、"34"、"8" 和 "34" 。

返回对 word 完成替换后形成的 不同 整数的数目。

如果两个整数的 不含前导零 的十进制表示不同，则认为这两个整数也不同。



示例 1：

输入：word = "a123bc34d8ef34"
输出：3
解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
示例 2：

输入：word = "leet1234code234"
输出：2
示例 3：

输入：word = "a1b01c001"
输出：1
解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。


提示：

1 <= word.length <= 1000
word 由数字和小写英文字母组成
*/

func numDifferentIntegers(word string) int {
	count := 0
	mapA := make(map[int]bool, 0)

	for i := 0; i < len(word); i++ {

		var cur int = 0
		flag := false
		exist := true
		for i < len(word) && judgeInt(word[i]) {
			cur *= 10
			cur += int(word[i] - '0')
			i++
			flag = true
		}
		if flag {
			_, exist = mapA[cur]
		}
		if !exist {
			count++
			mapA[cur] = true
		}

	}
	return count
}
func judgeInt(s uint8) bool {
	if s >= '0' && s <= '9' {
		return true
	}
	return false
}
func main() {
	print(numDifferentIntegers("a123bc34d8ef34"))
	print(numDifferentIntegers("0a0a"))
	print(numDifferentIntegers("a1b01c001"))

}
