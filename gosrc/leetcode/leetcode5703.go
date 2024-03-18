package main

import (
	"container/heap"
)

// 5703. 最大平均通过率
/*
一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes ，其中 classes[i] = [passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。

给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。

一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。

请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10-5 以内的结果都会视为正确结果。

示例 1：

输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
输出：0.78333
解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
示例 2：

输入：classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
输出：0.53485
*/
type node struct {
	a    float64
	b, c int
}

type nodeHeap struct {
	ele []node
}

func (this *nodeHeap) Len() int {
	return len(this.ele)
}

func (this *nodeHeap) Less(i, j int) bool {
	return this.ele[i].a > this.ele[j].a
}

func (this *nodeHeap) Swap(i, j int) {
	temp := this.ele[i]
	this.ele[i] = this.ele[j]
	this.ele[j] = temp
}

func (this *nodeHeap) Push(x interface{}) {
	this.ele = append(this.ele, x.(node))
}

func (this *nodeHeap) Pop() interface{} {
	temp := this.ele[len(this.ele)-1]
	this.ele = this.ele[:len(this.ele)-1]
	return temp
}

// 一个大根堆，每次存储好变化就行。 (b+1)/(a+1)-b/a 是变化量 每次将最大变化量存入堆中
func maxAverageRatio(classes [][]int, extraStudents int) float64 {
	prior := nodeHeap{}
	heap.Init(&prior)
	var sum float64
	for i := range classes {

		sum += float64(classes[i][0]) / float64(classes[i][1])
		heap.Push(&prior, node{
			a: ((float64(classes[i][1]) - float64(classes[i][0])) / (float64(classes[i][1]) * float64(classes[i][1]+1))),
			b: classes[i][0],
			c: classes[i][1],
		})
	}

	for ; extraStudents > 0; extraStudents-- {
		tempnode := heap.Pop(&prior).(node)
		sum += tempnode.a
		tempnode.b += 1
		tempnode.c += 1
		tempnode.a = (float64(tempnode.c) - float64(tempnode.b)) / (float64(tempnode.c) * float64(tempnode.c+1))
		heap.Push(&prior, tempnode)
	}

	return sum / float64(len(classes))

}

func main() {
	print(maxAverageRatio([][]int{{2, 4}, {3, 9}, {4, 5}, {2, 10}}, 4))
}
