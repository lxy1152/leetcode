package main

import (
	"fmt"
	"math/rand"
	"time"
)

const (
	// MaxLevel defines the maximum level for the skip list
	MaxLevel int = 16
	// Probability is the P value for random level generation
	Probability float32 = 0.5
)

type Node struct {
	key   int
	value interface{}
	next  []*Node // 指向不同层的下一个节点的指针数组
}

type SkipList struct {
	head   *Node
	level  int // 当前跳表索引的层数
	length int // 跳表长度
}

// NewNode 创建一个新的跳表节点
func NewNode(key int, value interface{}, level int) *Node {
	return &Node{
		key:   key,
		value: value,
		next:  make([]*Node, level),
	}
}

// NewSkipList 创建一个新的跳表
func NewSkipList() *SkipList {
	return &SkipList{
		head:   NewNode(0, nil, MaxLevel),
		level:  1,
		length: 0,
	}
}

// randomLevel 用于生成节点层数
func randomLevel() int {
	level := 1
	for rand.Float32() < Probability && level < MaxLevel {
		level++
	}
	return level
}

// Insert 向跳表中插入键值对
func (sl *SkipList) Insert(key int, value interface{}) {
	update := make([]*Node, MaxLevel)
	current := sl.head

	// 从顶层开始，找到每层小于key的最大节点
	for i := sl.level - 1; i >= 0; i-- {
		for current.next[i] != nil && current.next[i].key < key {
			current = current.next[i]
		}
		update[i] = current // 纪录可能需要更新的位置
	}

	current = current.next[0]

	// 如果key已存在，更新值
	if current != nil && current.key == key {
		current.value = value
		return
	}

	// 否则，为key创建一个新节点
	level := randomLevel()
	if level > sl.level { // 如果新节点层数大于跳表的当前层数，更新跳表的当前层数
		for i := sl.level; i < level; i++ {
			update[i] = sl.head
		}
		sl.level = level
	}

	node := NewNode(key, value, level)

	// 将新节点插入到跳表中
	for i := 0; i < level; i++ {
		node.next[i] = update[i].next[i]
		update[i].next[i] = node
	}

	sl.length++
}

// Search 在跳表中搜索键
func (sl *SkipList) Search(key int) (interface{}, bool) {
	current := sl.head
	for i := sl.level - 1; i >= 0; i-- {
		for current.next[i] != nil && current.next[i].key < key {
			current = current.next[i]
		}
	}

	current = current.next[0]

	if current != nil && current.key == key {
		return current.value, true
	}

	return nil, false
}

// Delete 在跳表中删除键
func (sl *SkipList) Delete(key int) bool {
	update := make([]*Node, MaxLevel)
	current := sl.head

	// Find the node to be deleted
	for i := sl.level - 1; i >= 0; i-- {
		for current.next[i] != nil && current.next[i].key < key {
			current = current.next[i]
		}
		update[i] = current
	}

	current = current.next[0]

	// If the key exists
	if current != nil && current.key == key {
		// Update the pointers and delete the node
		for i := 0; i < sl.level; i++ {
			if update[i].next[i] != current {
				break
			}
			update[i].next[i] = current.next[i]
		}

		// Reduce the level of the skip list if necessary
		for sl.level > 1 && sl.head.next[sl.level-1] == nil {
			sl.level--
		}

		sl.length--
		return true
	}

	return false
}

func main() {
	rand.Seed(time.Now().UnixNano())
	sl := NewSkipList(5)

	sl.Insert(3)
	sl.Insert(6)
	sl.Insert(7)
	sl.Insert(9)
	sl.Insert(12)
	sl.Insert(19)
	sl.Insert(17)
	sl.Insert(26)
	sl.Insert(21)
	sl.Insert(25)

	fmt.Println("Skip List:")
	sl.Print()

	fmt.Println("Search for 9: ", sl.Search(9))
	fmt.Println("Search for 15: ", sl.Search(15))
}
