package main

/*
5690. 最接近目标价格的甜点成本
你打算做甜点，现在需要购买配料。目前共有 n 种冰激凌基料和 m 种配料可供选购。而制作甜点需要遵循以下几条规则：

必须选择 一种 冰激凌基料。
可以添加 一种或多种 配料，也可以不添加任何配料。
每种类型的配料 最多两份 。
给你以下三个输入：

baseCosts ，一个长度为 n 的整数数组，其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格。
toppingCosts，一个长度为 m 的整数数组，其中每个 toppingCosts[i] 表示 一份 第 i 种冰激凌配料的价格。
target ，一个整数，表示你制作甜点的目标价格。
你希望自己做的甜点总成本尽可能接近目标价格 target 。

返回最接近 target 的甜点成本。如果有多种方案，返回 成本相对较低 的一种。

示例 1：

输入：baseCosts = [1,7], toppingCosts = [3,4], target = 10
输出：10
解释：考虑下面的方案组合（所有下标均从 0 开始）：
- 选择 1 号基料：成本 7
- 选择 1 份 0 号配料：成本 1 x 3 = 3
- 选择 0 份 1 号配料：成本 0 x 4 = 0
总成本：7 + 3 + 0 = 10 。

*/

func closestCost(baseCosts []int, toppingCosts []int, target int) int {
	a := len(baseCosts)
	b := len(toppingCosts)
	res := 100000000
	abs := func(a int) int {
		temp := a >> 31
		return (a + temp) ^ temp
	}
	for i := 0; i < a; i++ {
		s := baseCosts[i]
		// 不知道为什么 在这里明明乘法操作优先级大于移位 ,但是却没办法进行正常的计算。 下面移位处同样。
		for j := 0; j < 1<<(b*2); j++ {
			r := s
			flag := 0
			for k := 0; k < b; k++ {
				t := j >> (k * 2) & 3
				if t == 3 {
					flag = 1
					break
				}
				r += toppingCosts[k] * t
			}
			if flag == 1 {
				continue
			}
			if abs(res-target) > abs(r-target) || (abs(res-target) == abs(r-target) && r < res) {
				res = r
			}

		}
	}
	return res
}

func main() {
	print(closestCost([]int{5, 9}, []int{10, 1}, 7))
}
