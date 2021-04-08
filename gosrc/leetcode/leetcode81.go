package main

/*
81. 搜索旋转排序数组 II
已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。

给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。



示例 1：

输入：nums = [2,5,6,0,0,1,2], target = 0
输出：true
示例 2：

输入：nums = [2,5,6,0,0,1,2], target = 3
输出：false


提示：

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
题目数据保证 nums 在预先未知的某个下标上进行了旋转
-104 <= target <= 104


进阶：

这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
*/
//
//func search(nums []int, target int) bool {
//	head:=0
//	if len(nums)==1{
//		return nums[0]==target
//	}
//	for i:=range nums{
//	 	if i<len(nums)-1&&nums[i]>nums[i+1]{
//	 		head=i+1
//
//		}
//	 }
//	 l:=0
//	 r:=head
//	 if head>0&&target>=nums[0]&&target<=nums[head-1]{
//		 l=0
//		 r=head-1
//	 }else if target>=nums[head]&&target<=nums[len(nums)-1]{
//	 	l=head
//	 	r=len(nums)-1
//
//	 }else{
//	 	return false
//	 }
//	for l<=r {
//		for l<len(nums)-1 && nums[l] == nums[l+1] {
//			l++
//		}
//		for r>0 && nums[r] == nums[r-1] {
//			r--
//		}
//		mid := int(uint(l+r) >> 1)
//		if target == nums[mid] {
//			return true
//		} else if target > nums[mid] {
//			l=mid+1
//		} else {
//			r=mid-1
//		}
//	}
//
//	 return false
//}

func search(nums []int, target int) int {
	leng := len(nums)
	if leng < 1 {
		return -1
	}
	if leng == 1 && nums[0] == target {
		return nums[0]
	}
	l := 0
	r := len(nums) - 1
	for l <= r {
		mid := int(uint(l+r) >> 1)
		if nums[mid] == target {
			return mid
		}
		if nums[l] == nums[r] {
			l++
			continue
		}
		// 因为有 可能出现相同大小的缘故， 所以我们不采用原来 固定 用 0 和 mid 做比较的方式了。
		//  比较 mid 和 r  如果mid 小于 r 说明 这个区间是未旋转区间， 可以继续比较  target  大于mid 小于 r 则说明在这个区间之间 ，
		// 否则说明在 l 到 mid 之间 都用夹逼 进行判断。  能夹中 则进行对应的逻辑处理，否则相反。
		if nums[mid] <= nums[r] {
			if nums[mid] < target && target <= nums[r] {
				l = mid + 1
			} else {
				r = mid - 1
			}
		} else {
			if nums[mid] > target && target >= nums[l] {
				r = mid - 1
			} else {
				l = mid + 1
			}

		}
	}
	return -1

}

func main() {
	print(search([]int{1, 3}, 3))
}
