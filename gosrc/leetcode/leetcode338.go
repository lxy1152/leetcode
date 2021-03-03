package main

//           338. 比特位计数

func countBits(num int) []int {
	res := make([]int, 0)
	for i := 0; i <= num; i++ {
		count := 0
		for j := i; j > 0; j = j >> 1 {
			j = j & (j - 1)
			count++
		}
		res = append(res, count)
	}
	return res
}
func main() {
	i := countBits(5)
	for _, v := range i {
		print(v)
	}
}
