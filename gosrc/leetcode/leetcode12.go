package main

func intToRoman(num int) string {
	a := []int{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}
	b := []string{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}
	res := ""
	for i := 0; i < len(a); {
		if num/a[i] > 0 {
			t := num / a[i]
			num = num - t*a[i]
			for t > 0 {
				res += b[i]
				t--
			}
		}
		i++
	}
	return res

}

func main() {
	intToRoman(2000)
}
