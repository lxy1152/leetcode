package main

import "sort"

// 开始第一眼以为是前缀和技巧可以做的，但是仔细一看还是有一些区别的，直接能想到暴力解法，但是需要O(N2)的时间复杂度 不太合适
//
func fairCandySwap(A []int, B []int) []int {
	suma:=0
	sumb:=0
	for _,i:=range A{
		suma+=i
	}
	for _,i:=range B{
		sumb+=i
	}
	res:=(sumb+suma)/2
	sort.Ints(A)
	sort.Ints(B)
	i:=0
	j:=0
	for i<len(A)&&j<len(B){
		if suma-A[i]+B[j]==res{
			return []int{A[i],B[j]}
		}else{
			if suma-A[i]+B[j] >res {
				i++
			}else {
				j++
			}
 		}
	}
	return []int{}
}

func main(){
	print(fairCandySwap([]int{8,73,2,86,32},[]int{56,5,67,100,31})[0],fairCandySwap([]int{8,73,2,86,32},[]int{56,5,67,100,31})[1])
}