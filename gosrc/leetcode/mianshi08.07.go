package main

// 面试题 08.07. 无重复字符串的排列组合
/*
 回溯标准模板， 为什么忘记了呢， 可能因为把第一位也计算进去了， 所以只想着从第一位开始遍历， 实际上是从一个 不存在的根节点向每一个节点进行遍历的。


！！！！！！！！！！！！！！！一定要记住，res 没有申请空间，如果仅仅通过值传递，是没有办法保存状态的。
*/
func permutation(S string) []string {
	res := make([]string, 0)
	status := make([]bool, len(S))

	do(S, "", &res, status)

	return res
}

func do(S, cur string, res *[]string, status []bool) {
	if len(cur) == len(S) {
		*res = append(*res, cur)
		return
	}
	for i := 0; i < len(S); i++ {
		if !status[i] {
			cur += string(S[i])
			status[i] = true
			do(S, cur, res, status)
			status[i] = false
			cur = cur[:len(cur)-1]
		}
	}
}

func main() {
	permutation("qwe")
}
