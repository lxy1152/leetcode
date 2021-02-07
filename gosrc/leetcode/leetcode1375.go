package main

// 1375. 灯泡开关 III
// 房间中有 n 枚灯泡，编号从 1 到 n，自左向右排成一排。最初，所有的灯都是关着的。
//
//在 k 时刻（ k 的取值范围是 0 到 n - 1），我们打开 light[k] 这个灯。
//
//灯的颜色要想 变成蓝色 就必须同时满足下面两个条件：
//
//灯处于打开状态。
//排在它之前（左侧）的所有灯也都处于打开状态。
//请返回能够让 所有开着的 灯都 变成蓝色 的时刻 数目 。

//  分两个数组 一个数组当前点亮右边的灯 另一个数组放 当前点亮左边的灯 如果第二个数组的灯的数目等于当前点亮的灯的数目，那么左边的就全亮， 可继续优化
func numTimesAllBlue(light []int) int {
	toDeal := make([]int, 0)
	Deal := make([]int, 0)
	var count = 0
	leng := len(light)
	if leng <= 1 {
		return 1
	}
	for i := 0; i < leng; i++ {
		for index, foo := range toDeal {
			if foo <= i+1 {
				toDeal = append(toDeal[0:index], toDeal[index+1:]...)
				Deal = append(Deal, foo)

			}
		}
		if light[i] > i+1 {
			toDeal = append(toDeal, light[i])
		} else {
			Deal = append(Deal, light[i])
		}
		if len(Deal) == i+1 {
			count++
		}
	}
	return count
}

// 经过优化， 我们根本不需要存储那么多的状态 我们其实只需要判断当前点亮灯的位置和当前最远亮着的灯
// 如果最远亮着的灯的序号等于数组元素的个数，那么就可以亮。
func numTimesAllBlue1(light []int) int {
	maxlight := 0
	count := 0
	for index, foo := range light {
		maxlight = max5(maxlight, foo)
		if maxlight == index+1 {
			count++
		}
	}
	return count

}
func max5(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func main() {
	print(numTimesAllBlue1([]int{1, 2, 3, 4, 5, 6}))
}
