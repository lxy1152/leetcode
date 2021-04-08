package main

func areAlmostEqual(a string, b string) bool {
	i := len(a)

	map1 := make([]int, 26)
	map2 := make([]int, 26)
	count := 0
	for c := 0; c < i; c++ {
		map1[int(a[c]-'a')]++
		map2[int(b[c]-'a')]++
		if a[c] != b[c] {
			count++
		}
	}

	if count == 0 || count == 2 && verify3(map1, map2) {
		return true
	}
	return false

}
func verify3(a, b []int) bool {
	for i := 0; i < 26; i++ {
		if a[i] != b[i] {
			return false
		}
	}
	return true
}
