package main

// 765. 情侣牵手
// 我们遍历每个偶数位置 2 * i2∗i ，把它的对象安排到它右边的奇数位置 2 * i + 12∗i+1。
func minSwapsCouples(row []int) int {
	leng := len(row)
	res := 0
	for i := 0; i < leng-1; i = i + 2 {
		if row[i] == row[i+1]^1 {
			continue
		}
		for j := i + 1; j < leng; j++ {
			if row[i] == row[j]^1 {
				row[i+1], row[j] = row[j], row[i+1]
			}
		}
		res += 1
	}
	return res
}
