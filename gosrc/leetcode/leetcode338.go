package main

//           338. 比特位计数

func countBits(num int) []int {
	res := make([]int, num+1)
	count := 0
	for i := 1; i <= num; i++ {
		if i&(i-1) == 0 {
			count = i
		}

		res[i] = res[i-count] + 1
	}
	return res
}
func main() {
	i := countBits(5)
	for _, v := range i {
		print(v)
	}
}
